package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum ProductTypeEnum {

    API((byte)0, "API"), H5((byte)1, "H5"), SDK((byte)2, "SDK");

    private byte k;
    private String v;

    private ProductTypeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static ProductTypeEnum getBannerEnum(byte k) {
        for (ProductTypeEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("产品类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
