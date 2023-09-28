package com.ruyuan.fulfill.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ly
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderFulfillCommand {

    private Long orderId;
}
