package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum ProductStatusEnum {

    wait_enable((byte)0, "待上架"), enable((byte)1, "上架"), unable((byte)2, "下架"),delete((byte)3, "删除");

    private byte k;
    private String v;

    private ProductStatusEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static ProductStatusEnum getBannerEnum(byte k) {
        for (ProductStatusEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("产品状态异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
