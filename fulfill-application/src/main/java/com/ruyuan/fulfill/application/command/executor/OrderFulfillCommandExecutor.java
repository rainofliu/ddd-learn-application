package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.converter.FulfillOrderConverter;
import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;
import com.ruyuan.fulfill.domain.gateway.DomainEventGateway;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.gateway.RiskControlApiGateway;
import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.service.LogisticsDomainService;
import com.ruyuan.fulfill.domain.service.WarehouseDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单履约 命令 执行器
 *
 * @author ly
 */
@Component
public class OrderFulfillCommandExecutor {

    @Autowired
    private FulfillOrderConverter fulfillOrderConverter;

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private WarehouseDomainService warehouseDomainService;

    @Autowired
    private LogisticsDomainService logisticsDomainService;

    @Autowired
    private RiskControlApiGateway riskControlApiGateway;

    @Autowired
    private DomainEventGateway domainEventGateway;

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    /**
     * 执行订单履约流程
     * 专门负责订单履约流程的编排，把这个流程按照战术建模的设计，完成落地开发
     *
     * @param command 订单履约命令
     */
    public void execute(OrderFulfillCommand command) {
        OrderDTO orderDTO = command.getOrderDTO();
        // 第一步，保存订单，需要去使用履约订单仓储/gateway来进行保存
        // 履约单
        FulfillOrder fulfillOrder = fulfillOrderConverter.convert(orderDTO);
        fulfillOrderGateway.save(fulfillOrder);

        // 第二步，预分仓
        Warehouse warehouse = warehouseDomainService.preAllocateWareHouse(fulfillOrder);

        // 第三步，风控拦截
        Boolean riskControlIntercept = riskControlApiGateway.riskControlIntercept(fulfillOrder);
        if (!riskControlIntercept) {
            // 如果被风控拦截了，此时就需要发布订单被拦截的领域事件，通知人工审核
            domainEventGateway.publishOrderInterceptedEvent(new OrderInterceptedEvent());
            return;
        }

        // 第四步，分物流
        logisticsDomainService.allocateLogistics(fulfillOrder,warehouse);
        // 第五步，下发库房
        warehouseApiGateway.sendFulfillOrder(fulfillOrder,warehouse);
    }
}
