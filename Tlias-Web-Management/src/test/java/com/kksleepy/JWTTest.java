package com.kksleepy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    @Test
    public void testGenerateJwt(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",1001);
        dataMap.put("username","zhangsan");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"a2tzbGVlcHk=")  //编码算法和密钥
                .addClaims(dataMap)  //添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))  //设置过期时间
                .compact();  //生成token
        System.out.println(jwt);
    }
    @Test
    public void testJwtParse(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAwMSwidXNlcm5hbWUiOiJ6aGFuZ3NhbiIsImV4cCI6MTc0MzU5MDE5OH0.0efLMUSvbeOQdHNKMUy_sZHNI40OirgXsEfZwjZFDIA";
        Claims claims = Jwts.parser().setSigningKey("a2tzbGVlcHk=")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
