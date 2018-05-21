package com.xz.fld.controller;

import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class AppVersionController extends BaseController {

    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping(value = "/checkUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "检查更新", notes = "检查应用是否需要更新")
            @ApiImplicitParams({
            @ApiImplicitParam(name = "version", value = "手机号码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "platform", value = "平台 1-Android 2-IOS", required = true,  paramType = "query", dataType = "String")
    })

    @ResponseBody
    public ResponseDTO getVersion(String version, byte platform) {
        return ResponseDTO.success(appVersionService.loadVersion(version, platform));
    }
}
