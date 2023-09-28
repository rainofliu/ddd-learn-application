package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;
import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.gateway.DomainEventGateway;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.service.LogisticsDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class AuditInterceptedFulfillOrderCommandExecutor {

    @Autowired
    private LogisticsDomainService logisticsDomainService;
    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;
    @Autowired
    private WarehouseApiGateway warehouseApiGateway;
    @Autowired
    private DomainEventGateway domainEventGateway;

    public void execute(AuditInterceptedFulfillOrderCommand command) {
        InterceptedFulfillOrderAuditResultDTO auditResultDTO =
                command.getInterceptedFulfillOrderAuditResultDTO();
        // 审核结果
        Boolean auditResult = auditResultDTO.getAuditResult();
        // 订单id
        Long orderId = auditResultDTO.getOrderId();

        if (auditResult) {
            FulfillOrder fulfillOrder = fulfillOrderGateway.getByOrderId(orderId);
            Warehouse warehouse = fulfillOrderGateway.getAllocatedWarehouse(orderId);
            // 分物流
            logisticsDomainService.allocateLogistics(fulfillOrder, warehouse);
            // 下库房
            warehouseApiGateway.sendFulfillOrder(fulfillOrder,warehouse);
        }else {
            // 如果审核没通过，则发布订单履约被拒绝的领域事件
            OrderFulfillDeniedEvent orderFulfillDeniedEvent = new OrderFulfillDeniedEvent();
            domainEventGateway.publishOrderFulfillDeniedEvent(orderFulfillDeniedEvent);
        }

    }
}
