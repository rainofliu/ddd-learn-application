package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.LogisticsApiGateway;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompanies;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class LogisticsApiGatewayImpl implements LogisticsApiGateway {

    @Override
    public LogisticsCompanies getAll() {
        return new LogisticsCompanies();
    }
}
