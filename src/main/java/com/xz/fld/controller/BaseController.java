package com.xz.fld.controller;

import org.springframework.beans.factory.annotation.Value;

public abstract class BaseController {

    @Value("${send.message.url}")
    protected String sendMsgUrl;
}
