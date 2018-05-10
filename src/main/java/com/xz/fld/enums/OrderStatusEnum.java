package com.xz.fld.enums;

import com.xz.fld.exception.BizException;

public enum OrderStatusEnum {

    意向申请((byte)0, "意向申请"), 申请中((byte)1, "申请中"), 提交进件((byte)2, "提交进件"),申请成功((byte)3, "申请成功"),
    申请失败((byte)4, "申请失败"),取消申请((byte)5, "取消申请"),审核中((byte)6, "审核中"),完成注册((byte)7, "完成注册")
    ,放款成功((byte)8, "放款成功");

    private byte k;
    private String v;

    private OrderStatusEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static OrderStatusEnum getEnum(byte k) {
        for (OrderStatusEnum bannerEnum : values()) {
            if (bannerEnum.getK() == k) {
                return bannerEnum;
            }
        }

        throw new BizException("订单状态异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
