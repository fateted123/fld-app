package com.xz.fld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public abstract class BaseController {

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Value("${send.message.url}")
    protected String sendMsgUrl;

    @Value("${message.code.day.max.count}")
    protected int phoneNumCodeCount;

    @Value("${message.code.ip.max.count}")
    protected int ipCodeCount;

    @Value("${fld.image.local}")
    protected String imagePath;
}
