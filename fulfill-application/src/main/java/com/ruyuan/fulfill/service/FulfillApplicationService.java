package com.ruyuan.fulfill.service;

import com.ruyuan.fulfill.command.OrderFulfillCommand;
import com.ruyuan.fulfill.command.executor.OrderFulfillCommandExecutor;
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

    /**
     * 执行订单履约
     *
     * @param command 订单履约命令
     */
    public void executeOrderFulfill(OrderFulfillCommand command) {
        // 调用命名执行器 执行订单履约
        orderFulfillCommandExecutor.execute(command);
    }
}
