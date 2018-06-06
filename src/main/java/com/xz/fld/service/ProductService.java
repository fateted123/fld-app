package com.xz.fld.service;

import com.xz.fld.domain.Product;
import com.xz.fld.dto.ProductDTO;
import com.xz.fld.dto.ProductEnableDTO;
import com.xz.fld.dto.ProductFeatureDTO;
import com.xz.fld.enums.*;
import com.xz.fld.exception.BizException;
import com.xz.fld.mapper.ProductMapper;
import com.xz.fld.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Value("${fld.image.url}")
    private String productImageUrl;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> listSelectedProducts() {
        List<Product> products = productMapper.listSelectedProduct();
        return formatProduct(products);
    }

    public List<ProductDTO> listHotProducts() {
        List<Product> products = productMapper.listHotProduct();
        return formatProduct(products);
    }

    public List<ProductDTO> listProducts(byte status) {
        List<Product> products = productMapper.listProduct(status, 0, 50);
        return formatProduct(products);
    }

    private List<ProductDTO> formatProduct(List<Product> products) {
        List<ProductDTO> dtoList = new ArrayList<>(products.size());

        for (Product product : products) {
            ProductDTO dto = new ProductDTO();
            dtoList.add(dto);
            formatProDTO(dto, product);
        }

        return dtoList;
    }

    private void formatProDTO(ProductDTO dto, Product product) {
        dto.setApplyConditions(product.getApplyConditions());
        dto.setCompanyName(product.getCompanyName());
        dto.setCooperRatio(product.getCooperRatio());
        dto.setCooperType(product.getCooperType());
        dto.setCooperTypeDesc(CooperTypeEnum.getBannerEnum(product.getCooperType()).getV());
        dto.setCpaPrice(product.getCpaPrice());
        dto.setCreateTime(DateUtils.dateToString(product.getCreateTime()));
        dto.setHotProductDesc(HotProductEnum.getBannerEnum(product.getHotProductFlag()).getV());
        dto.setHotProductFlag(product.getHotProductFlag());
        dto.setLimitDown(product.getLimitDown());
        dto.setLimitUp(product.getLimitUp());
        dto.setProductDeadline(DateUtils.dateToYYYYMMDD(product.getProductDeadline()));
        dto.setProductId(product.getProductId());
        dto.setProductIntroduce(product.getProductIntroduce());
        dto.setProductLable1(product.getProductLable1());
        dto.setProductLable2(product.getProductLable2());
        dto.setProductLable3(product.getProductLable3());
        dto.setProductLable4(product.getProductLable4());
        dto.setProductLable5(product.getProductLable5());
        dto.setProductLogo(productImageUrl + product.getProductLogo());
        dto.setProductName(product.getProductName());
        dto.setProductRank(product.getProductRank());
        dto.setProductStatus(product.getProductStatus());
        dto.setProductStatusDesc(ProductStatusEnum.getBannerEnum(product.getProductStatus()).getV());
        dto.setProductType(product.getProductType());
        dto.setProductTypeDesc(ProductTypeEnum.getBannerEnum(product.getProductType()).getV());
        dto.setProductUrl(product.getProductUrl());
        dto.setRateDown(product.getRateDown());
        dto.setRateUp(product.getRateUp());
        dto.setRebatePrice(product.getRebatePrice());
        dto.setRebateRatio(product.getRebateRatio());
        dto.setRebateType(product.getRebateType());
        dto.setRebateTypeDesc(RebateTypeEnum.getBannerEnum(product.getRebateType()).getV());
        dto.setResponseType(product.getResponseType());
        dto.setResponseTypeDesc(ResponseTypeEnum.getBannerEnum(product.getResponseType()).getV());
        dto.setSelectedProductDesc(SelectedProductEnum.getBannerEnum(product.getSelectedProductFlag()).getV());
        dto.setSelectedProductFlag(product.getSelectedProductFlag());
        dto.setProductFeature(product.getProductFeature());
        dto.setStagesRange(product.getStagesRange());
        dto.setProductFeature(product.getProductFeature());
    }

    private String formatFeature(String pf) {
        if (StringUtils.isBlank(pf)) {
            return "";
        }

        String[] arr = pf.split("-");
        String re = "";
        for (String m : arr) {
            re += ProductFeatureEnum.getEnum(Byte.valueOf(m)).getV() + "-";
        }

        return re;
    }

    private List<ProductDTO> formatProductFeature(List<ProductDTO> list, ProductFeatureEnum penum) {

        List<ProductDTO> tmp = new ArrayList<>();
        for (ProductDTO dto : list) {
            String feature = dto.getProductFeature();
            if (StringUtils.isBlank(feature)) {
                continue;
            }

            String[] arr = feature.split("-");
            if (arr.length <= 0) {
                continue;
            }

            List<String> farray = Arrays.asList(arr);

            if (!farray.contains(String.valueOf(penum.getK()))) {
                continue;
            }

            try {
                ProductDTO xx = (ProductDTO)dto.clone();
                xx.setProductFeature(String.valueOf(penum.getK()));
                tmp.add(xx);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw new BizException("系统异常");
            }

        }

        return tmp;
    }

    public ProductEnableDTO listEnableProducts() {
        List<Product> products = productMapper.listEnableProduct(null);
        ProductEnableDTO dto = new ProductEnableDTO();

        List<ProductDTO> dtoList = formatProduct(products);

        dto.setFastLowerMoneyProducts(formatProductFeature(dtoList, ProductFeatureEnum.fast_Lower_money));
        dto.setBackCreditProducts(formatProductFeature(dtoList, ProductFeatureEnum.back_credit));
        dto.setLowInterestProducts(formatProductFeature(dtoList, ProductFeatureEnum.low_interest));
        dto.setHightRebateProducts(formatProductFeature(dtoList, ProductFeatureEnum.hight_rebate));
        dto.setHightLimitProducts(formatProductFeature(dtoList, ProductFeatureEnum.hight_limit));
        dto.setEasyProducts(formatProductFeature(dtoList, ProductFeatureEnum.easy_access));

        return dto;
    }

    public List<ProductFeatureDTO> listFeature() {

        List<ProductFeatureDTO> dtos = new ArrayList<>();

        ProductFeatureEnum[] values = ProductFeatureEnum.values();
        for (ProductFeatureEnum en : values) {
            ProductFeatureDTO dto = new ProductFeatureDTO();
            dtos.add(dto);

            dto.setFeatureName(en.getV());
            dto.setProductFeature(en.getK());
        }


        return dtos;
    }

}
