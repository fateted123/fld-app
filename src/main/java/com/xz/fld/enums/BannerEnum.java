package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum BannerEnum {

    to_be_displayed((byte)0, "待显示"), display((byte)1, "已显示"), un_display((byte)2, "不显示");

    private byte k;
    private String v;

    private BannerEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static BannerEnum getBannerEnum(byte k) {
        for (BannerEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("banner类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
