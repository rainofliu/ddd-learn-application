package com.ruyuan.fulfill.api.rpc;

import com.ruyuan.fulfill.application.command.GetOrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.rpc.FulfillApi;
import com.ruyuan.fulfill.rpc.dto.FulfillOrderCO;
import com.ruyuan.fulfill.application.service.FulfillApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应该暴露为dubbo service
 *
 * @author ly
 */
@Service
public class FulfillApiImpl implements FulfillApi {
    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @Override
    public FulfillOrderCO getFulfillOrderById(Long orderId) {
        GetOrderFulfillCommand command = new GetOrderFulfillCommand(orderId);
        FulfillOrderDTO fulfillOrderDTO = fulfillApplicationService.executeGetOrderFulfillCommand(command);
        return new FulfillOrderCO();
    }
}
