package com.ruyuan.fulfill.application.command;

import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ly
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderFulfillCommand {

    private OrderDTO orderDTO;
}
