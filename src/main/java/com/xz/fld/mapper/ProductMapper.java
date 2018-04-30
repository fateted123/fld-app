package com.xz.fld.mapper;

import com.xz.fld.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> listProduct(@Param("status") Byte status,
                              @Param("offset") Integer offset,
                              @Param("pageSize") Integer pageSize);

    List<Product> listHotProduct();

    List<Product> listSelectedProduct();
}