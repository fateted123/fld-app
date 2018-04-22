package com.xz.fld.exception;

public class BizException extends RuntimeException {

    private int errCode;

    public BizException(String msg) {
        super(msg);
    }

    public BizException(String msg, int errCode) {
        this(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}
