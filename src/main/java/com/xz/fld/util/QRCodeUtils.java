package com.xz.fld.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.xz.fld.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtils {

    protected static final Logger log = LoggerFactory.getLogger(QRCodeUtils.class);

    private static final int width = 200;
    private static final int height = 200;
    private static final String format = "png";


    public static void createQRCode(String context, String filename, String filepath) {
        Path file = Paths.get(filepath + filename);

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(context, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException("二维码生成失败");
        }

    }

}
