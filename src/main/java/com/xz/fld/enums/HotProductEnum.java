package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum HotProductEnum {

    unable((byte)0, "不显示"), enable((byte)1, "显示");

    private byte k;
    private String v;

    private HotProductEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static HotProductEnum getBannerEnum(byte k) {
        for (HotProductEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("热度产品类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
