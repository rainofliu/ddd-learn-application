package com.ruyuan.fulfill.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单已支付事件 (领域事件）
 *
 * @author ly
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayedEvent {

    private Long orderId;
}
