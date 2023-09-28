package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class FulfillOrderDOConverter {

    public FulfillOrderDO convert(FulfillOrder fulfillOrder) {
        return new FulfillOrderDO();
    }
}
