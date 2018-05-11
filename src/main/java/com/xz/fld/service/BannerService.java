package com.xz.fld.service;

import com.xz.fld.domain.Banner;
import com.xz.fld.dto.BannerDTO;
import com.xz.fld.mapper.BannerMapper;
import com.xz.fld.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerService {

    @Value("${fld.image.url}")
    private String imageUrl;

    @Autowired
    private BannerMapper bannerMapper;


    public List<BannerDTO> loadBanner() {
        List<Banner> banners = bannerMapper.listBanner((byte) 1);
        List<BannerDTO> dtoList = new ArrayList<>(banners.size());

        for (Banner banner : banners) {
            BannerDTO bannerDTO = new BannerDTO();
            dtoList.add(bannerDTO);

            bannerDTO.setBizType(banner.getBizType());
            bannerDTO.setCreateTime(DateUtils.dateToString(banner.getCreateTime()));
            bannerDTO.setId(banner.getId());
            bannerDTO.setImageLink(banner.getImageLink());
            bannerDTO.setImageTitle(banner.getImageTitle());
            bannerDTO.setImageUrl(imageUrl + banner.getImageUrl());
            bannerDTO.setLinkeType(banner.getLinkeType());
            bannerDTO.setProductionParam(banner.getProductionParam());
            bannerDTO.setRank(banner.getRank());
            bannerDTO.setStatus(banner.getStatus());
        }

        return dtoList;
    }
}
