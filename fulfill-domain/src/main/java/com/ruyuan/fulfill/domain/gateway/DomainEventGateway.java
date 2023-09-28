package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;

/**
 * @author ly
 */
public interface DomainEventGateway {

     void publishOrderInterceptedEvent(
            OrderInterceptedEvent orderInterceptedEvent);

     void publishOrderFulfillDeniedEvent(
            OrderFulfillDeniedEvent orderFulfillDeniedEvent);
}
