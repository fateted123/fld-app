package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int productId;

    private byte productFeature;

    private String productName;

    private String companyName;

    private Integer limitUp;

    private Integer limitDown;

    private String rateUp;

    private String rateDown;

    private Byte productType;

    private String productTypeDesc;

    private String productLogo;

    private Byte cooperType;

    private String cooperTypeDesc;

    private String cooperRatio;

    private String cpaPrice;

    private Byte rebateType;

    private String rebateTypeDesc;

    private String rebateRatio;

    private String rebatePrice;

    private Byte productStatus;

    private String productStatusDesc;

    private String productIntroduce;

    private String productUrl;

    private Integer productRank;

    private String productLable2;

    private String productLable1;

    private String productLable3;

    private String productLable4;

    private String productLable5;

    private String productDeadline;

    private String applyConditions;

    private Byte responseType;

    private String responseTypeDesc;

    private Byte hotProductFlag;

    private String hotProductDesc;

    private Byte selectedProductFlag;

    private String selectedProductDesc;

    private String createTime;

    private String stagesRange;

}
