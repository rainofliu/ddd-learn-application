package com.ruyuan.fulfill.domain.service;

import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class WarehouseDomainService {

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    public Warehouse preAllocateWareHouse(FulfillOrder fulfillOrder) {
        Warehouses warehouses = warehouseApiGateway.getAll();
        Warehouse warehouse = warehouses.selectNearest(fulfillOrder.getDeliveryAddress());
        warehouse.setWarehouseGateway(warehouseApiGateway);
        Boolean inventoryEnough = warehouse.isInventoryEnough(fulfillOrder.getFulfillOrderItems());
        if (Boolean.TRUE.equals(inventoryEnough)) {
            warehouse.lockInventory(fulfillOrder);
            //  将履约订单分配给选择的仓库
            fulfillOrder.allocatedWareHouse(warehouse);
            return warehouse;
        }
        return null;
    }
}
