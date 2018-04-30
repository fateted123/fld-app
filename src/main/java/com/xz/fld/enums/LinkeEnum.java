package com.xz.fld.enums;


import com.xz.fld.exception.BizException;

public enum LinkeEnum {

    h5((byte)1, "H5跳转"),local_native((byte)2, "应用内跳转");

    private byte k;
    private String v;

    private LinkeEnum(byte k, String v) {
        this.k = k;
        this.v = v;
    }

    public static LinkeEnum getLinkeEnum(byte k) {
        for (LinkeEnum linkeEnum : values()) {
            if (linkeEnum.getK() == k) {
                return linkeEnum;
            }
        }

        throw new BizException("跳转枚举类型异常");
    }

    public byte getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
