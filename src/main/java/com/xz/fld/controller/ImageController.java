package com.xz.fld.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
public class ImageController extends BaseController {

    @RequestMapping(value = "/fld/images/{filename}", method = RequestMethod.GET)
    @ApiOperation(value = "访问图片", notes = "访问图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filename", value = "图片名字", required = true,  paramType = "query", dataType = "String")
    })
    public void showImage(@PathVariable("filename") String filename, HttpServletResponse response) {

        response.setContentType("image/png");
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(super.imagePath + filename));
            OutputStream os = response.getOutputStream()) {
            byte[] buff = new byte[1024];
            int length = -1;
            while (-1 != (length=bis.read(buff))) {
                os.write(buff, 0, length);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
