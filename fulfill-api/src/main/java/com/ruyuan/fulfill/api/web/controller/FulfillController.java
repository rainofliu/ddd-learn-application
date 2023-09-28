package com.ruyuan.fulfill.api.web.controller;

import com.ruyuan.fulfill.api.web.request.QueryInterceptedFulfillOrderRequest;
import com.ruyuan.fulfill.api.web.response.AuditInterceptedFulfillOrderResponse;
import com.ruyuan.fulfill.api.web.response.QueryInterceptedFulfillOrderResponse;
import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import com.ruyuan.fulfill.application.service.FulfillApplicationService;
import com.ruyuan.fulfill.api.web.request.AuditInterceptedFulfillOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RestController
public class FulfillController {
    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @GetMapping(value = "/fulfill/order/intercepted")
    public QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrder(
            @RequestBody QueryInterceptedFulfillOrderRequest queryInterceptedFulfillOrderRequest) {
        // 把web request，转换为app层的query命令，交给app层去执行这个query命令
        InterceptedFulfillOrderQuery interceptedFulfillOrderQuery =
                new InterceptedFulfillOrderQuery();
        InterceptedFulfillOrdersDTO interceptedFulfillOrdersDTO =
                fulfillApplicationService.executeInterceptedFulfillOrderQuery(interceptedFulfillOrderQuery);
        // 对app层返回的结果dto，转化为web response，再返回给请求者
        QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrderResponse =
                new QueryInterceptedFulfillOrderResponse();
        return queryInterceptedFulfillOrderResponse;
    }

    @PostMapping(value = "/fulfill/order/intercepted/audit")
    public AuditInterceptedFulfillOrderResponse auditInterceptedFulfillOrder(
            @RequestBody AuditInterceptedFulfillOrderRequest auditInterceptedFulfillOrderRequest) {
        // 要把web request转换为app层的command
        AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand =
                new AuditInterceptedFulfillOrderCommand();
        fulfillApplicationService.executeAuditInterceptedFulfillOrderCommand(
                auditInterceptedFulfillOrderCommand);
        return new AuditInterceptedFulfillOrderResponse();
    }
}
