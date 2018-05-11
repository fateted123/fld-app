package com.xz.fld.config;

import com.xz.fld.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Value("${login.token.privatekey}")
    private String privateKey;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor(privateKey));

        ir.addPathPatterns("/user/getUserInfo*");
        ir.addPathPatterns("/user/getInviteQRcode*");
        ir.addPathPatterns("/user/resetPwd*");
        ir.addPathPatterns("/user/getShareRegistUrl*");
        ir.addPathPatterns("/user/listInvitInfo*");
        ir.addPathPatterns("/order/create*");
        ir.addPathPatterns("/order/list*");
    }
}
