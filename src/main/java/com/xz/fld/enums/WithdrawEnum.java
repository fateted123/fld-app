package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum WithdrawEnum {

    待处理((byte)0, "待处理"), 已转账((byte)1, "已转账"), 取消转账((byte)2, "取消转账");

    private byte k;
    private String v;

    private WithdrawEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static WithdrawEnum getShareChannelEnum(byte k) {
        for (WithdrawEnum bannerTypeEnumEnum : values()) {
            if (bannerTypeEnumEnum.getK() == k) {
                return bannerTypeEnumEnum;
            }
        }

        throw new BizException("转账状态异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
