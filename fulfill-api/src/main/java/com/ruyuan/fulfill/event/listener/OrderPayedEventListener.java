package com.ruyuan.fulfill.event.listener;

import com.ruyuan.fulfill.command.OrderFulfillCommand;
import com.ruyuan.fulfill.command.dto.OrderDTO;
import com.ruyuan.fulfill.domain.event.OrderPayedEvent;
import com.ruyuan.fulfill.service.FulfillApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单已支付事件的监听器
 *
 * @author ly
 */
@Component
public class OrderPayedEventListener {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    public void consume(OrderPayedEvent orderPayedEvent) {
        Long orderId = orderPayedEvent.getOrderId();

        OrderDTO orderDTO = new OrderDTO(orderId);
        OrderFulfillCommand command = new OrderFulfillCommand(orderDTO);

        fulfillApplicationService.executeOrderFulfill(command);

    }
}
