package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductEnableDTO {

    //易通过
    private List<ProductDTO> easyProducts;
    //额度高
    private List<ProductDTO> hightLimitProducts;
    //返利高
    private List<ProductDTO> hightRebateProducts;
    //利息低
    private List<ProductDTO> lowInterestProducts;
    //还信用卡
    private List<ProductDTO> backCreditProducts;
    //下款快
    private List<ProductDTO> fastLowerMoneyProducts;
}
