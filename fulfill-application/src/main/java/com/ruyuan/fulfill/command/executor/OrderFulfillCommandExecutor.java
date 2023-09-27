package com.ruyuan.fulfill.command.executor;

import com.ruyuan.fulfill.command.OrderFulfillCommand;
import com.ruyuan.fulfill.command.dto.OrderDTO;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
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
    private FulfillOrderGateway fulfillOrderGateway;

    /**
     * 执行订单履约流程
     *
     * @param command 订单履约命令
     */
    public void execute(OrderFulfillCommand command) {
        OrderDTO orderDTO = command.getOrderDTO();

    }
}
