package com.ruyuan.fulfill.domain.model.warehouse;

import com.ruyuan.fulfill.domain.model.fulfillorder.DeliveryAddress;

/**
 * 代表了仓库集合的领域模型
 *
 * @author ly
 */
public class Warehouses {

    public Warehouse selectNearest(DeliveryAddress deliveryAddress) {
        return new Warehouse();
    }
}
