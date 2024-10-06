package com.dream;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class JwtTest {

    @Test
    public void testGen() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","张三");

        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))  //添加过期时间
//                .withExpiresAt(new Date(System.currentTimeMillis()))  //添加过期时间
//                .sign(Algorithm.HMAC256("dream"));//指定算法，配置密钥
                .sign(Algorithm.HMAC256("itheima"));//指定算法，配置密钥

        System.out.println(token);
    }

    @Test
    public void testParse() {
        //定义字符串，模拟用户传递过来的token
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
//                ".eyJ1c2VyIjp7Im5hbWUiOiLlvKDkuIkiLCJpZCI6MX0sImV4cCI6MTcyNzczNTg4M30" +
//                ".4cNwildqGCfb13rbRI7p8J-NnWs-6BL1SbVs46XCJK4";

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiLlvKDkuIkiLCJpZCI6MX0sImV4cCI6MTcyNzY5MzUyM30.6oHApmGHvmJRyaSXj8tHANau-eMySM-_FM_jKIGR_v0";
        String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiLlvKDkuIkiLCJpZCI6MX0sImV4cCI6MTcyNzgxNzAyMn0.zR8crIKmT-pmLXy_MRa6WfAvLULLTFLGsXihxqFSO48";
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("dream")).build(); // itheima
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build(); // itheima

//        DecodedJWT decodedJWT = jwtVerifier.verify(token);  //验证token，生成一个解析后的JWT对象
        DecodedJWT decodedJWT = jwtVerifier.verify(token1);  //验证token，生成一个解析后的JWT对象
        Map<String,Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        //如果篡改了头部和载荷部分的数据，那么验证失败
        //如果密钥改了，验证失败
        //token过期
    }
}
