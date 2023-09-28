package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.infrastructure.convertor.FulfillOrderDOConverter;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.FulfillOrderMapper;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ly
 */
@Component
public class FulfillOrderGatewayImpl implements FulfillOrderGateway {
    @Autowired
    private FulfillOrderDOConverter fulfillOrderDOConverter;
    @Resource
    private FulfillOrderMapper fulfillOrderMapper;

    @Override
    public void save(FulfillOrder fulfillOrder) {
        FulfillOrderDO fulfillOrderDO = fulfillOrderDOConverter.convert(fulfillOrder);
        fulfillOrderMapper.create(fulfillOrderDO);
    }

    @Override
    public void saveAllocatedWarehouse(FulfillOrder fulfillOrder, Warehouse warehouse) {

    }

    @Override
    public void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder, LogisticsOrder logisticsOrder) {

    }

    @Override
    public List<FulfillOrder> queryInterceptedFulfillOrders() {
        return null;
    }

    @Override
    public FulfillOrder getByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Warehouse getAllocatedWarehouse(Long orderId) {
        return null;
    }
}
