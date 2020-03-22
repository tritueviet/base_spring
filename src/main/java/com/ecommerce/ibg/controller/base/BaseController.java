package com.ecommerce.ibg.controller.base;

import com.ecommerce.ibg.component.JwtToken;
import com.ecommerce.ibg.model.base.BaseResponse;
import com.ecommerce.ibg.model.base.ResponseImpl;
import com.ecommerce.ibg.model.user.UserDemo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    private ObjectMapper mapper;
    @Autowired
    private JwtToken jwtToken;

    @Autowired
    public BaseController() {
        mapper = new ObjectMapper();
    }

    protected <T> BaseResponse<T> validToken(String token) {
        UserDemo userDemo = jwtToken.verifyToken(token.substring(6).trim());
        if (userDemo == null) {
            return ResponseImpl.ok().with(0, "Token không đúng định dạng!").build();
        }
        if (userDemo.getExpiredTime() < System.currentTimeMillis()) {
            return ResponseImpl.ok().with(0, "Token đã hết hạn!").build();
        }
        //TODO check tren db userDemo.getToken()
        return ResponseImpl.ok().with(1, "OK").with(userDemo).build();
    }

}
