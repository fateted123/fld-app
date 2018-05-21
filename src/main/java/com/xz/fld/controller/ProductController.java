package com.xz.fld.controller;

import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/product", produces = "application/json")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/home/hot", method = RequestMethod.POST)
    @ApiOperation(value = "首页热点产品", notes = "获取首页热点产品列表")
    public ResponseDTO listHomeHot(HttpServletRequest request) {
        return ResponseDTO.success(productService.listHotProducts());
    }

    @RequestMapping(value = "/home/selected", method = RequestMethod.POST)
    @ApiOperation(value = "首页精品产品", notes = "获取首页精品产品列表")
    public ResponseDTO listHomeSelected(HttpServletRequest request) {
        return ResponseDTO.success(productService.listSelectedProducts());
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "产品列表", notes = "根据产品特性获取所有可用的产品列表")
    public ResponseDTO list() {
        return ResponseDTO.success(productService.listEnableProducts());
    }

    @RequestMapping(value = "/listFeature", method = RequestMethod.POST)
    @ApiOperation(value = "产品分类", notes = "根据产品特性")
    public ResponseDTO listFeature() {
        return ResponseDTO.success(productService.listFeature());
    }
}
