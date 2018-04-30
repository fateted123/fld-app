package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum SelectedProductEnum {

    unable((byte)0, "不显示"), enable((byte)1, "显示");

    private byte k;
    private String v;

    private SelectedProductEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static SelectedProductEnum getBannerEnum(byte k) {
        for (SelectedProductEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("精品产品类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
