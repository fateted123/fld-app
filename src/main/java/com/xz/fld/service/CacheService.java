package com.xz.fld.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @CachePut(value = "registerCode", key = "#phone")
    public String putRegistCode(String code, String phone) {
        return code;
    }

    @Cacheable(value = "registerCode", key = "#phone")
    public String getRegistCode(String phone) {
        return null;
    }

    @CachePut(value = "oneDaySendCodeCounter", key = "#phone")
    public int putCodeCounter(String phone, int count) {
        return count + 1;
    }

    @Cacheable(value = "oneDaySendCodeCounter", key = "#phone")
    public int getCodeCounter(String phone) {
        return 0;
    }

    @CachePut(value = "oneDayIPSendCOdeCounter", key = "#ip")
    public int putIPCodeCounter(String ip, int count) {
        return count + 1;
    }

    @Cacheable(value = "oneDayIPSendCOdeCounter", key = "#ip")
    public int getIPCodeCounter(String ip) {
        return 0;
    }
}
