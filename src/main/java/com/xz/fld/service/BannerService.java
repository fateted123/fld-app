package com.xz.fld.service;

import com.xz.fld.domain.Banner;
import com.xz.fld.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;


    public List<Banner> loadBanner() {
        List<Banner> banners = bannerMapper.listBanner((byte) 1);
        return banners;
    }
}
