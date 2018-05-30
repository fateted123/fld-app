package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum ShareChannelEnum {

    weibo((byte)7, "微博"), weixin((byte)3, "微信"), weixin_pengyou((byte)4, "朋友圈"), qq((byte)5, "QQ"), qqzoo((byte)6, "QQ空间"),
    android((byte)1, "Android"),ios((byte)2, "IOS");

    private byte k;
    private String v;

    private ShareChannelEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static ShareChannelEnum getShareChannelEnum(byte k) {
        for (ShareChannelEnum bannerTypeEnumEnum : values()) {
            if (bannerTypeEnumEnum.getK() == k) {
                return bannerTypeEnumEnum;
            }
        }

        throw new BizException("分享渠道类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
