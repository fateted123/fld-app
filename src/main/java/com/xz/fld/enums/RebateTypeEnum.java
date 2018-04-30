package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum RebateTypeEnum {

    ratio((byte)0, "按比例"), price((byte)1, "按单价");

    private byte k;
    private String v;

    private RebateTypeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static RebateTypeEnum getBannerEnum(byte k) {
        for (RebateTypeEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("返利方式类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
