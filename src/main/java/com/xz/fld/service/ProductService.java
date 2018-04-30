package com.xz.fld.service;

import com.xz.fld.domain.Product;
import com.xz.fld.dto.ProductDTO;
import com.xz.fld.enums.*;
import com.xz.fld.mapper.ProductMapper;
import com.xz.fld.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

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
        }

        return dtoList;
    }

}
