package com.ruyuan.fulfill.application.command;

import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;

public class AuditInterceptedFulfillOrderCommand {

    private InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO;

    public InterceptedFulfillOrderAuditResultDTO getInterceptedFulfillOrderAuditResultDTO() {
        return interceptedFulfillOrderAuditResultDTO;
    }

    public void setInterceptedFulfillOrderAuditResultDTO(InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO) {
        this.interceptedFulfillOrderAuditResultDTO = interceptedFulfillOrderAuditResultDTO;
    }
}
