package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ly
 */
@Component
public class InterceptedFulfillOrderQueryExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    public InterceptedFulfillOrdersDTO execute(InterceptedFulfillOrderQuery command) {
        List<FulfillOrder> fulfillOrders = fulfillOrderGateway.queryInterceptedFulfillOrders();
        return new InterceptedFulfillOrdersDTO();
    }
}
