package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum ResponseTypeEnum {

    //数据返回方式 0-线上返回 1-手工返回 2-不返回

    on_line((byte)0, "线上返回"), manual((byte)1, "手工返回"), no_return((byte)2, "不返回");

    private byte k;
    private String v;

    private ResponseTypeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static ResponseTypeEnum getBannerEnum(byte k) {
        for (ResponseTypeEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("返回方式类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
