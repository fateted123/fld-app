package com.xz.fld.controller;

import com.xz.fld.common.ThreadLocalHolder;
import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.handler.AccessTokenHandler;
import com.xz.fld.service.ProductOrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ProductOrderController extends BaseController {

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private AccessTokenHandler accessTokenHandler;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "下订单", notes = "根据选择产品创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "产品ID", required = true,  paramType = "query", dataType = "String")
    })
    public ResponseDTO create(int productId, @RequestHeader("access-token") String accessToken) {

        String uid = ThreadLocalHolder.getUid();

        productOrderService.createOrder(uid, productId);

        return ResponseDTO.success();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "订单返利列表", notes = "获取个人返利信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "返利状态 -1-全部 1-待返利 2-已返利 3-争议 ", required = true,  paramType = "query", dataType = "String")
    })
    public ResponseDTO list(byte status, @RequestHeader("access-token") String accessToken) {

        String uid = ThreadLocalHolder.getUid();

        return ResponseDTO.success(productOrderService.listOrders(uid, status));
    }
}
