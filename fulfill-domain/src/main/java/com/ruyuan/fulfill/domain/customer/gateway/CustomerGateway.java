package com.ruyuan.fulfill.domain.customer.gateway;

import com.ruyuan.fulfill.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
