package com.xz.fld.controller;

import com.xz.fld.common.MessageFormat;
import com.xz.fld.common.ThreadLocalHolder;
import com.xz.fld.domain.User;
import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.dto.UserDTO;
import com.xz.fld.dto.UserRegister4PhoneDTO;
import com.xz.fld.handler.AccessTokenHandler;
import com.xz.fld.service.CacheService;
import com.xz.fld.service.UserService;
import com.xz.fld.util.IDUtils;
import com.xz.fld.util.IPUtils;
import com.xz.fld.util.QRCodeUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public ResponseDTO sendMsg(String phone, HttpServletRequest request, HttpServletRequest session, HttpServletResponse response) {

        OutputStreamWriter out = null;
        BufferedReader in = null;

        try {

            String cacheCode = cacheService.getRegistCode(phone);
            if (StringUtils.isNotBlank(cacheCode)) {
                return ResponseDTO.failed("请稍后发送短信");
            }

            int count = cacheService.getCodeCounter(phone);
            if (phoneNumCodeCount <= count) {
                return ResponseDTO.failed("超过当天发送最大次数");
            }

            String ip = IPUtils.getIpAddr(request);
            log.info("注册IP={}", ip);

            int ipCount = cacheService.getIPCodeCounter(ip);
            if (ipCodeCount <= ipCount) {
                return ResponseDTO.failed("IP超过当天发送最大次数");
            }

            String code = IDUtils.createCode();
            log.info(">>>>>>>>>>手机{},验证码{}", phone, code);
            System.out.println(phone);
            String postData = "sname=dlxzkj00&spwd=1qazxsw2&scorpid=&sprdid=1012888&sdst=" + phone + "&smsg=" + String.format(MessageFormat.registerMessage, code);
            log.info(postData);
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
                log.info("{} send code connect failed!", phone);
                return ResponseDTO.failed("发送失败");
            }

            //获取响应内容体
            String line, result = "";
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            log.info(result);

            cacheService.putCodeCounter(phone, count);
            cacheService.putIPCodeCounter(ip, ipCount);
            cacheService.putRegistCode(code, phone);

            log.info(">>>>>>cache code={}", cacheService.getRegistCode(phone));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
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

        log.info("登录用户{},密码{}", phone, password);
        User user = userService.login4Pwd(phone, password);

        String token = accessTokenHandler.createToken(user.getUserId());
        log.info(token);

        response.setHeader("access-token", token);

        return ResponseDTO.success();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", notes = "获取用户详细信息")
    public ResponseDTO getUserInfo(@RequestHeader("access-token") String accessToken) {

        return ResponseDTO.success(userService.getUserInfo(ThreadLocalHolder.getUid()));
    }

    @RequestMapping(value = "/getInviteQRcode", method = RequestMethod.POST)
    @ApiOperation(value = "用户邀请二维码", notes = "获取用户邀请二维码图片")
    public void getInviteQRcode(@RequestHeader("access-token") String accessToken, HttpServletResponse response) {

        String uid = ThreadLocalHolder.getUid();
        String filename = "invite_" + uid ;
        String context = "http://www.baidu.com";

        Path file = Paths.get(imagePath + filename);
        boolean fileExist = Files.exists(file, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        if (!fileExist) {
            QRCodeUtils.createQRCode(context, filename, imagePath);
        }

        response.setContentType("image/png");
        try(OutputStream os = response.getOutputStream()) {
            file = Paths.get(imagePath + filename);
            os.write(Files.readAllBytes(file));
            os.flush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
    
    @RequestMapping(value = "/getShareRegistUrl", method = RequestMethod.POST)
    @ApiOperation(value = "用户邀请地址", notes = "获取用户各大平台的专属邀请地址")
    public ResponseDTO getShareRegistUrl(@RequestHeader("access-token") String accessToken) {

        String uid = ThreadLocalHolder.getUid();
        return ResponseDTO.success(userService.getUserShareUrl(uid));
    }

    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    @ApiOperation(value = "重置密码", notes = "重置密码，成功后，客户端需要将token清除，重新登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "短信验证码", required = true,  paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true,  paramType = "query", dataType = "String")
    })
    @ResponseBody
    public ResponseDTO resetPwd(String phone, String code, String newPwd) {

        log.info("新密码{}", newPwd);

        userService.resetPwd(phone, code, newPwd);
        return ResponseDTO.success();
    }

    @RequestMapping(value = "/listInvitInfo", method = RequestMethod.POST)
    @ApiOperation(value = "我的邀请信息", notes = "获取我的所有邀请信息")
    @ResponseBody
    public ResponseDTO listInvitInfo(@RequestHeader("access-token") String accessToken) {

        String uid = ThreadLocalHolder.getUid();
        return ResponseDTO.success(userService.loadInvit(uid));
    }

}