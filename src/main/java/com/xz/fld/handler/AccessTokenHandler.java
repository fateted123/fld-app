package com.xz.fld.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xz.fld.exception.BizException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessTokenHandler {

    @Value("${login.token.privatekey}")
    private String privateKey;

    public String createToken(String userId) {
        try {

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND, 30);

            Algorithm algorithm = Algorithm.HMAC256(privateKey);

            Map<String, Object> headerClaims = new HashMap();
            headerClaims.put("typ", "JWT");
            headerClaims.put("alg", "HS256");

            String token = JWT.create()
                    .withHeader(headerClaims)
                    .withClaim("uid", userId)
                    .withExpiresAt(cal.getTime())
                    .sign(algorithm);

            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("创建token失败");
        }
    }

    public String decodeToken(String accessToken) {
        try {
            System.out.println("privateKey=" + privateKey);

            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance

            DecodedJWT jwt = verifier.verify(accessToken);
            String uid = jwt.getClaim("uid").asString();
            System.out.println(uid);

            return uid;

        } catch (Exception e){
            e.printStackTrace();
            throw new BizException("签名不合法");
        }
    }


}
