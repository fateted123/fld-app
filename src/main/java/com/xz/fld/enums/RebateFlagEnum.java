package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum RebateFlagEnum {

    不返利((byte)0, "不返利")
    , 待返利((byte)1, "待返利")
    , 已返利((byte)2, "已返利")
    , 争议((byte)3, "争议");

    private byte k;
    private String v;

    private RebateFlagEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static RebateFlagEnum getEnum(byte k) {
        for (RebateFlagEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("订单返利标志异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
