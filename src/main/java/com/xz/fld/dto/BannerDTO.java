package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDTO {

    private Integer id;

    private String imageUrl;

    private String imageTitle;

    private String createTime;

    private Byte status;

    private Byte rank;

    private String imageLink;

    private Byte linkeType;

    private String productionParam;

    private Byte bizType;
}
