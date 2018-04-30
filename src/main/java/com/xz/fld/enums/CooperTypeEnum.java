package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum CooperTypeEnum {

    CPA((byte)0, "CPA"), CPS((byte)1, "CPS"), other((byte)2, "其它");

    private byte k;
    private String v;

    private CooperTypeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static CooperTypeEnum getBannerEnum(byte k) {
        for (CooperTypeEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("分润方式类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
