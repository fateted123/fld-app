package com.xz.fld.controller;

import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/share")
public class ShareRegistController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toRegist", method = RequestMethod.GET)
    @ApiOperation(value = "邀请注册页面", notes = "用户分享邀请链接吸引用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户ID", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "channel", value = "分享频道", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "token", value = "签名", required = true,  paramType = "query", dataType = "String")
    })
    public ModelAndView toRegist(String uid, byte channel, String token) {

        log.info(uid);
        log.info("" + channel);
        log.info(token);

        userService.checkShareRegist(uid, channel, token);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("shareRegist");
        mv.addObject("uid", uid);
        mv.addObject("channel", channel);
        mv.addObject("token", token);

        return mv;
    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    @ApiOperation(value = "邀请注册页面", notes = "用户分享邀请链接吸引用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "uid", value = "用户ID", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "channel", value = "分享频道", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "token", value = "签名", required = true,  paramType = "query", dataType = "String")
    })
    @ResponseBody
    public ResponseDTO regist(String phone, String pwd, String code, String uid, byte channel, String token) {

        log.info(phone);
        log.info(pwd);
        log.info(code);

        userService.register4Share(phone, pwd, code, uid, channel, token);

        return ResponseDTO.success();
    }
}
