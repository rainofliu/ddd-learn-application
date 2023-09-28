package com.ruyuan.fulfill.domain.model.logistics;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;

/**
 * @author ly
 */
public class LogisticsCompany {

    public LogisticsOrder applyLogisticsOrder(FulfillOrder fulfillOrder,
                                              Warehouse warehouse) {
        return new LogisticsOrder();
    }
}
