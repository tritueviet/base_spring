package com.ecommerce.ibg.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecommerce.ibg.model.user.UserDemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtToken {
    @Value("${secret.key}")
    String scretKey;

    public String signToken(UserDemo userDemo) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(scretKey);
            return JWT.create().withClaim("userName", userDemo.getUserName())
                    .withClaim("expired", System.currentTimeMillis() + 2592000000L)
                    .withClaim("token", userDemo.getToken())
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException e) {
        }
        return null;
    }

    public UserDemo verifyToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            UserDemo userDemo = new UserDemo();
            userDemo.setUserName(decodedJWT.getClaim("userName").asString());
            userDemo.setExpiredTime(decodedJWT.getClaim("expired").asLong());
            userDemo.setToken(decodedJWT.getClaim("token").asString());
            return userDemo;
        } catch (Exception e) {
        }
        return null;
    }
}
