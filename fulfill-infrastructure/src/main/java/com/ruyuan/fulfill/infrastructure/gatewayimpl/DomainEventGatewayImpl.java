package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;
import com.ruyuan.fulfill.domain.gateway.DomainEventGateway;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Component
public class DomainEventGatewayImpl implements DomainEventGateway {
    @Override
    public void publishOrderInterceptedEvent(OrderInterceptedEvent orderInterceptedEvent) {

    }

    @Override
    public void publishOrderFulfillDeniedEvent(OrderFulfillDeniedEvent orderFulfillDeniedEvent) {

    }
}
