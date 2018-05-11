package com.xz.fld.common;

public class ThreadLocalHolder {
    private static final ThreadLocal<String> uidThreadLocal = new ThreadLocal<>();

    public static void setUid(String uid) {
        uidThreadLocal.set(uid);
    }

    public static String getUid() {
        return uidThreadLocal.get();
    }
}
