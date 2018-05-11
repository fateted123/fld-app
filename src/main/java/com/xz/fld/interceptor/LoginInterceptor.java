package com.xz.fld.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xz.fld.common.ThreadLocalHolder;
import com.xz.fld.dto.ResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private final String privateKey;

    public LoginInterceptor(String privateKey) {
        this.privateKey = privateKey;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        String accessToken = request.getHeader("access-token");

        boolean flag = false;

        try {

            if (StringUtils.isBlank(accessToken)) {
                return false;
            }

            logger.info("privateKey=" + privateKey);

            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance

            DecodedJWT jwt = verifier.verify(accessToken);
            String uid = jwt.getClaim("uid").asString();
            logger.info(uid);

            ThreadLocalHolder.setUid(uid);
            flag = true;
            return true;

        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return false;
        } finally {
            if (!flag) {
                response.setContentType("application/json");
                try(ServletOutputStream os = response.getOutputStream()) {
                    os.write(JSON.toJSONString(ResponseDTO.login("")).getBytes());
                    os.flush();
                }
            }
        }

    }
}
