package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.RiskControlApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class RiskControlApiGatewayImpl implements RiskControlApiGateway {

    @Override
    public Boolean riskControlIntercept(FulfillOrder fulfillOrder) {
        return true;
    }
}
