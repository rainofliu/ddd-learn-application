package com.ruyuan.fulfill.domain.model.fulfillorder;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 履约 聚合根
 *
 * @author ly
 */
@Data
public class FulfillOrder {

    private OrderId orderId;
    private List<FulfillOrderItem> fulfillOrderItems;
    private DeliveryAddress deliveryAddress;
    private PayType payType;
    private PaymentDetail paymentDetail;
    private FulfillOrderStatus fulfillOrderStatus;
    private LogisticsOrder logisticsOrder;

    private FulfillOrderGateway fulfillOrderGateway;

    public List<String> getSkuCodes() {
        return new ArrayList<>();
    }

    public List<Long> getPurchaseCounts() {
        return new ArrayList<>();
    }

    public Long getOrderId() {
        return 0L;
    }

    public void allocatedWareHouse(Warehouse warehouse) {
        fulfillOrderGateway.saveAllocatedWarehouse(this,warehouse);
    }

    public void allocatedLogistics(LogisticsOrder logisticsOrder) {
        fulfillOrderGateway.saveAllocatedLogisticsOrder(this,logisticsOrder);
    }

}
