package com.ruyuan.fulfill.rpc;

import com.ruyuan.fulfill.rpc.dto.FulfillOrderCO;

/**
 * @author ly
 */
public interface FulfillApi {
    FulfillOrderCO getFulfillOrderById(Long orderId);
}
