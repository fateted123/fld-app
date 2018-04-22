package com.xz.fld.domain;

import java.util.Date;

public class Banner {
    private Integer id;

    private String imageUrl;

    private String imageTitle;

    private Date createTime;

    private Byte status;

    private Byte rank;

    private String imageLink;

    private Byte linkeType;

    private String productionParam;

    private Byte bizType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle == null ? null : imageTitle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRank() {
        return rank;
    }

    public void setRank(Byte rank) {
        this.rank = rank;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink == null ? null : imageLink.trim();
    }

    public Byte getLinkeType() {
        return linkeType;
    }

    public void setLinkeType(Byte linkeType) {
        this.linkeType = linkeType;
    }

    public String getProductionParam() {
        return productionParam;
    }

    public void setProductionParam(String productionParam) {
        this.productionParam = productionParam == null ? null : productionParam.trim();
    }

    public Byte getBizType() {
        return bizType;
    }

    public void setBizType(Byte bizType) {
        this.bizType = bizType;
    }
}