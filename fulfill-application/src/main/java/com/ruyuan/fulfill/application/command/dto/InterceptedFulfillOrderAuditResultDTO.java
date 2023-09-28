package com.ruyuan.fulfill.application.command.dto;

public class InterceptedFulfillOrderAuditResultDTO {

    private Long orderId;
    private Boolean auditResult;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Boolean auditResult) {
        this.auditResult = auditResult;
    }
}
