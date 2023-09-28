package com.ruyuan.fulfill.application.converter;

import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class FulfillOrderConverter {
    
    public FulfillOrder convert(OrderDTO orderDTO){
        return new FulfillOrder();
    }
}
