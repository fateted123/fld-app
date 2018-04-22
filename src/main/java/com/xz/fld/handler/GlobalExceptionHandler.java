package com.xz.fld.handler;

import com.xz.fld.dto.ResponseDTO;
import com.xz.fld.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResponseDTO processBizException(BizException bie) {
        logger.error(bie.getMessage(), bie);
        return ResponseDTO.failed(bie.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDTO processException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseDTO.failed("系统异常，请联系客服");
    }
}
