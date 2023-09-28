package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;

import java.util.List;

/**
 * @author ly
 */
public interface FulfillOrderGateway {

    void save(FulfillOrder fulfillOrder);

    void saveAllocatedWarehouse(FulfillOrder fulfillOrder,
                                Warehouse warehouse);

    void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder,
                                     LogisticsOrder logisticsOrder);

    List<FulfillOrder> queryInterceptedFulfillOrders();

    FulfillOrder getByOrderId(Long orderId);

    Warehouse getAllocatedWarehouse(Long orderId);
}
