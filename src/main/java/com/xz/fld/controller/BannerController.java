package com.xz.fld.controller;

import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.service.BannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/banner", produces = "application/json")
public class BannerController extends BaseController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/getBanner", method = RequestMethod.POST)
    @ApiOperation(value = "首页banner", notes = "获取首页banner图片列表")
    public ResponseDTO getBanner(HttpServletRequest request) {
        return ResponseDTO.success(bannerService.loadBanner());
    }
}
