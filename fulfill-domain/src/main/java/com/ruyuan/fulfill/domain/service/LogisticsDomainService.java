package com.ruyuan.fulfill.domain.service;

import com.ruyuan.fulfill.domain.gateway.LogisticsApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompanies;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompany;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class LogisticsDomainService {

    @Autowired
    private LogisticsApiGateway logisticsApiGateway;

    public void allocateLogistics(FulfillOrder fulfillOrder, Warehouse warehouse) {
        // 查询所有的物流公司
        LogisticsCompanies logisticsCompanies = logisticsApiGateway.getAll();
        // 选择仓库附近最合适的物流公司
        LogisticsCompany logisticsCompany = logisticsCompanies.selectBest();
        // 向物流公司申请电子物流面单
        LogisticsOrder logisticsOrder = logisticsCompany.applyLogisticsOrder(fulfillOrder, warehouse);
        // 把电子物流面单分配给履约订单
        fulfillOrder.allocatedLogistics(logisticsOrder);
    }
}
