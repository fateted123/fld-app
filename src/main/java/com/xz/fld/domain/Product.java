package com.xz.fld.domain;

import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String companyName;

    private Integer limitUp;

    private Integer limitDown;

    private String rateUp;

    private String rateDown;

    private Byte productType;

    private String productLogo;

    private Byte cooperType;

    private String cooperRatio;

    private String cpaPrice;

    private Byte rebateType;

    private String rebateRatio;

    private String rebatePrice;

    private Byte productStatus;

    private String productIntroduce;

    private String productUrl;

    private Integer productRank;

    private String productLable1;

    private String productLable2;

    private String productLable3;

    private String productLable4;

    private String productLable5;

    private Date productDeadline;

    private String applyConditions;

    private Byte responseType;

    private Byte hotProductFlag;

    private Byte selectedProductFlag;

    private Date createTime;

    private Date modifyTime;

    private Byte productFeature;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getLimitUp() {
        return limitUp;
    }

    public void setLimitUp(Integer limitUp) {
        this.limitUp = limitUp;
    }

    public Integer getLimitDown() {
        return limitDown;
    }

    public void setLimitDown(Integer limitDown) {
        this.limitDown = limitDown;
    }

    public String getRateUp() {
        return rateUp;
    }

    public void setRateUp(String rateUp) {
        this.rateUp = rateUp == null ? null : rateUp.trim();
    }

    public String getRateDown() {
        return rateDown;
    }

    public void setRateDown(String rateDown) {
        this.rateDown = rateDown == null ? null : rateDown.trim();
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo == null ? null : productLogo.trim();
    }

    public Byte getCooperType() {
        return cooperType;
    }

    public void setCooperType(Byte cooperType) {
        this.cooperType = cooperType;
    }

    public String getCooperRatio() {
        return cooperRatio;
    }

    public void setCooperRatio(String cooperRatio) {
        this.cooperRatio = cooperRatio == null ? null : cooperRatio.trim();
    }

    public String getCpaPrice() {
        return cpaPrice;
    }

    public void setCpaPrice(String cpaPrice) {
        this.cpaPrice = cpaPrice == null ? null : cpaPrice.trim();
    }

    public Byte getRebateType() {
        return rebateType;
    }

    public void setRebateType(Byte rebateType) {
        this.rebateType = rebateType;
    }

    public String getRebateRatio() {
        return rebateRatio;
    }

    public void setRebateRatio(String rebateRatio) {
        this.rebateRatio = rebateRatio == null ? null : rebateRatio.trim();
    }

    public String getRebatePrice() {
        return rebatePrice;
    }

    public void setRebatePrice(String rebatePrice) {
        this.rebatePrice = rebatePrice == null ? null : rebatePrice.trim();
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductIntroduce() {
        return productIntroduce;
    }

    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce == null ? null : productIntroduce.trim();
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl == null ? null : productUrl.trim();
    }

    public Integer getProductRank() {
        return productRank;
    }

    public void setProductRank(Integer productRank) {
        this.productRank = productRank;
    }

    public String getProductLable1() {
        return productLable1;
    }

    public void setProductLable1(String productLable1) {
        this.productLable1 = productLable1 == null ? null : productLable1.trim();
    }

    public String getProductLable2() {
        return productLable2;
    }

    public void setProductLable2(String productLable2) {
        this.productLable2 = productLable2 == null ? null : productLable2.trim();
    }

    public String getProductLable3() {
        return productLable3;
    }

    public void setProductLable3(String productLable3) {
        this.productLable3 = productLable3 == null ? null : productLable3.trim();
    }

    public String getProductLable4() {
        return productLable4;
    }

    public void setProductLable4(String productLable4) {
        this.productLable4 = productLable4 == null ? null : productLable4.trim();
    }

    public String getProductLable5() {
        return productLable5;
    }

    public void setProductLable5(String productLable5) {
        this.productLable5 = productLable5 == null ? null : productLable5.trim();
    }

    public Date getProductDeadline() {
        return productDeadline;
    }

    public void setProductDeadline(Date productDeadline) {
        this.productDeadline = productDeadline;
    }

    public String getApplyConditions() {
        return applyConditions;
    }

    public void setApplyConditions(String applyConditions) {
        this.applyConditions = applyConditions == null ? null : applyConditions.trim();
    }

    public Byte getResponseType() {
        return responseType;
    }

    public void setResponseType(Byte responseType) {
        this.responseType = responseType;
    }

    public Byte getHotProductFlag() {
        return hotProductFlag;
    }

    public void setHotProductFlag(Byte hotProductFlag) {
        this.hotProductFlag = hotProductFlag;
    }

    public Byte getSelectedProductFlag() {
        return selectedProductFlag;
    }

    public void setSelectedProductFlag(Byte selectedProductFlag) {
        this.selectedProductFlag = selectedProductFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Byte getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(Byte productFeature) {
        this.productFeature = productFeature;
    }
}