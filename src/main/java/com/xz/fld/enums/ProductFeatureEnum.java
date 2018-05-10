package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum ProductFeatureEnum {

    easy_access((byte)1, "易通过"),
    hight_limit((byte)2, "额度高"),
    hight_rebate((byte)3, "返利高"),
    low_interest((byte)4, "利息低"),
    back_credit((byte)5, "还信用卡"),
    fast_Lower_money((byte)6, "下款快");

    private byte k;
    private String v;

    private ProductFeatureEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static ProductFeatureEnum getEnum(byte k) {
        for (ProductFeatureEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("产品特性异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
