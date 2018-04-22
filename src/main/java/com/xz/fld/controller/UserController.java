package com.xz.fld.controller;

import com.xz.fld.common.MessageFormat;
import com.xz.fld.domain.User;
import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.dto.UserDTO;
import com.xz.fld.dto.UserRegister4PhoneDTO;
import com.xz.fld.handler.AccessTokenHandler;
import com.xz.fld.service.CacheService;
import com.xz.fld.service.UserService;
import com.xz.fld.util.IDUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessTokenHandler accessTokenHandler;

    @Autowired
    private CacheService cacheService;


    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信验证码", notes = "发送短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true,  paramType = "query", dataType = "String")
    })
    public ResponseDTO sendMsg(String phone, HttpServletRequest session, HttpServletResponse response) {

        OutputStreamWriter out = null;
        BufferedReader in = null;

        try {
            String code = IDUtils.createCode();
            System.out.println(">>>>>>>>>>手机" + phone + "验证码=" + code);
            System.out.println(phone);
            String postData = "sname=DL-wanglu&spwd=wl12345678wl&scorpid=&sprdid=1012888&sdst=" + phone + "&smsg=" + String.format(MessageFormat.registerMessage, code);
            System.out.println(postData);
            //发送POST请求
            URL url = new URL(sendMsgUrl);
            System.out.println(sendMsgUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();

            //获取响应状态
            System.out.println(conn.getResponseCode());
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return ResponseDTO.failed("发送失败");
            }

            //获取响应内容体
            String line, result = "";
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            System.out.println(result);

            cacheService.putRegistCode(code, phone);

            System.out.println(">>>>>>cache code=" + cacheService.getRegistCode(phone));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.failed("发送失败");
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            } catch (IOException io) {
            }

        }

        return ResponseDTO.success();
    }

    @RequestMapping(value = "/register4Phone", method = RequestMethod.POST)
    @ApiOperation(value = "注册", notes = "手机端用户注册")
    public ResponseDTO register4Phone(UserRegister4PhoneDTO userRegister4PhoneDTO, HttpServletResponse response) {
        userService.register4Phone(userRegister4PhoneDTO);
        return ResponseDTO.success();
    }



    @RequestMapping(value = "/login4Password", method = RequestMethod.POST)
    @ApiOperation(value = "密码登录", notes = "手机密码登录，登录成功后，响应头里返回access-token，客户端需保存，下次请求将access-token放在请求头里即可。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,  paramType = "query", dataType = "String"),
    })
    public ResponseDTO login4Password(String phone, String password, HttpServletResponse response) {

        User user = userService.login4Pwd(phone, password);

        String token = accessTokenHandler.createToken(user.getUserId());
        System.out.println(token);

        response.setHeader("access-token", token);

        return ResponseDTO.success();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", notes = "获取用户详细信息")
    public ResponseDTO getUserInfo(@RequestHeader("access-token") String accessToken) {

        if (null == accessToken || "".equals(accessToken)) {
            return ResponseDTO.failed("请先登录");
        }

        System.out.println(">>>>>>>>>>>" + accessToken);

        String uid = accessTokenHandler.decodeToken(accessToken);

        return ResponseDTO.success(userService.getUserInfo(uid));
    }


}