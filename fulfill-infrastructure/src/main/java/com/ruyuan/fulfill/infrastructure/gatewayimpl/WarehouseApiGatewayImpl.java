package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ly
 */
@Component
public class WarehouseApiGatewayImpl implements WarehouseApiGateway {

    @Override
    public Warehouses getAll() {
        return null;
    }

    @Override
    public Boolean lockInventory(Long warehouseId, Long orderId, List<String> skuCodes, List<Long> inventoryCount) {
        return null;
    }

    @Override
    public void sendFulfillOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {

    }
}
