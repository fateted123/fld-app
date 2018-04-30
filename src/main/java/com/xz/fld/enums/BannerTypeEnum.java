package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum BannerTypeEnum {
    home_page((byte)0, "首页"), other((byte)1, "其它");

    private byte k;
    private String v;

    private BannerTypeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static BannerTypeEnum getBannerEnum(byte k) {
        for (BannerTypeEnum bannerTypeEnumEnum : values()) {
            if (bannerTypeEnumEnum.getK() == k) {
                return bannerTypeEnumEnum;
            }
        }

        throw new BizException("bannerType类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
