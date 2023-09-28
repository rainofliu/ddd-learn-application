package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.command.GetOrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class GetOrderFulfillCommandExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    public FulfillOrderDTO execute(GetOrderFulfillCommand command) {
        FulfillOrder fulfillOrder =fulfillOrderGateway.getByOrderId(command.getOrderId());
        return new FulfillOrderDTO();
    }
}
