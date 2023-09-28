package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;

/**
 * @author ly
 */
public interface RiskControlApiGateway {

    Boolean riskControlIntercept(FulfillOrder fulfillOrder);
}
