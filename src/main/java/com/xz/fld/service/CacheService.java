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
}
