package com.ruyuan.fulfill.domain.customer.gateway;

import com.ruyuan.fulfill.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
