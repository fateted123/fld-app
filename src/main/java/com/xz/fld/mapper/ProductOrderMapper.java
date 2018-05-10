package com.xz.fld.mapper;

import com.xz.fld.domain.ProductOrder;

import java.util.List;

public interface ProductOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(ProductOrder record);

    int insertSelective(ProductOrder record);

    ProductOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(ProductOrder record);

    int updateByPrimaryKey(ProductOrder record);

    List<ProductOrder> listOrders(String uid);
}