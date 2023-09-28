package com.ruyuan.fulfill.domain.model.fulfillorder;

public class FulfillOrderItem {

    private String skuCode;
    private Long purchaseCount;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Long getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Long purchaseCount) {
        this.purchaseCount = purchaseCount;
    }
}
