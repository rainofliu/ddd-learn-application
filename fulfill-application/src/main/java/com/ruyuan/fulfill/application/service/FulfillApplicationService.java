package com.ruyuan.fulfill.application.service;

import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.GetOrderFulfillCommand;
import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.command.executor.AuditInterceptedFulfillOrderCommandExecutor;
import com.ruyuan.fulfill.application.command.executor.GetOrderFulfillCommandExecutor;
import com.ruyuan.fulfill.application.command.executor.InterceptedFulfillOrderQueryExecutor;
import com.ruyuan.fulfill.application.command.executor.OrderFulfillCommandExecutor;
import com.ruyuan.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 履约 应用服务
 *
 * @author ly
 */
@Component
public class FulfillApplicationService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;

    @Autowired
    private GetOrderFulfillCommandExecutor getOrderFulfillCommandExecutor;

    @Autowired
    private InterceptedFulfillOrderQueryExecutor interceptedFulfillOrderQueryExecutor;

    @Autowired
    private AuditInterceptedFulfillOrderCommandExecutor auditInterceptedFulfillOrderCommandExecutor;

    /**
     * 执行订单履约
     *
     * @param command 订单履约命令
     */
    public void executeOrderFulfill(OrderFulfillCommand command) {
        // 调用命名执行器 执行订单履约
        orderFulfillCommandExecutor.execute(command);
    }

    public FulfillOrderDTO executeGetOrderFulfillCommand(GetOrderFulfillCommand command) {
        return getOrderFulfillCommandExecutor.execute(command);
    }

    public InterceptedFulfillOrdersDTO executeInterceptedFulfillOrderQuery(InterceptedFulfillOrderQuery interceptedFulfillOrderQuery) {
        return interceptedFulfillOrderQueryExecutor.execute(interceptedFulfillOrderQuery);
    }

    public void executeAuditInterceptedFulfillOrderCommand(AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand) {
        auditInterceptedFulfillOrderCommandExecutor.execute(auditInterceptedFulfillOrderCommand);
    }
}
