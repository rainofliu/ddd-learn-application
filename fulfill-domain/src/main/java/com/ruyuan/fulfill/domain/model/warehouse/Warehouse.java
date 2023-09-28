package com.ruyuan.fulfill.domain.model.warehouse;

import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderItem;

import java.util.List;

/**
 * @author ly
 */
public class Warehouse {

    private Long warehouseId;
    private WarehouseApiGateway warehouseGateway;

    public Boolean isInventoryEnough(List<FulfillOrderItem> fulfillOrderItems) {
        return true;
    }

    public Boolean lockInventory(FulfillOrder fulfillOrder) {
        return warehouseGateway.lockInventory(warehouseId, fulfillOrder.getOrderId(),
                fulfillOrder.getSkuCodes(), fulfillOrder.getPurchaseCounts());
    }

    public void setWarehouseGateway(WarehouseApiGateway warehouseGateway) {
        this.warehouseGateway = warehouseGateway;
    }
}
