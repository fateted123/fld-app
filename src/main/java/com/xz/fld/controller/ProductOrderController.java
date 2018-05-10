package com.xz.fld.controller;

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
        if (null == accessToken || "".equals(accessToken)) {
            return ResponseDTO.failed("请登录");
        }

        String uid = accessTokenHandler.decodeToken(accessToken);

        productOrderService.createOrder(uid, productId);

        return ResponseDTO.success();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "订单列表", notes = "获取个人订单列表")
    public ResponseDTO list(@RequestHeader("access-token") String accessToken) {
        if (null == accessToken || "".equals(accessToken)) {
            return ResponseDTO.failed("请登录");
        }

        String uid = accessTokenHandler.decodeToken(accessToken);

        return ResponseDTO.success(productOrderService.listOrders(uid));
    }
}
