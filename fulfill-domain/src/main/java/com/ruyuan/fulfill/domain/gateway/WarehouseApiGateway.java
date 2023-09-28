package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;

import java.util.List;

/**
 * @author ly
 */
public interface WarehouseApiGateway {

    Warehouses getAll();

    Boolean lockInventory(Long warehouseId,
                          Long orderId,
                          List<String> skuCodes,
                          List<Long> inventoryCount);

    void sendFulfillOrder(FulfillOrder fulfillOrder,
                          Warehouse warehouse);

}
