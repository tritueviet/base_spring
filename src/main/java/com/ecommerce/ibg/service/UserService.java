package com.ecommerce.ibg.service;

import com.ecommerce.ibg.component.JwtToken;
import com.ecommerce.ibg.model.base.BaseResponse;
import com.ecommerce.ibg.model.base.ResponseImpl;
import com.ecommerce.ibg.model.oracle.UserOracle;
import com.ecommerce.ibg.model.user.UserDemo;
import com.ecommerce.ibg.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private JwtToken jwtToken;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
    }

    public BaseResponse<String> login(UserDemo userDemo) {
        UserOracle userOracle = userRepository.login(userDemo.getUserName(), userDemo.getPassword());
        if (userOracle == null) {
            return ResponseImpl.ok().with(0, "Thông tin xác thực không chính xác").build();
        }
        userDemo.setToken("xxxxx");
        return ResponseImpl.ok().with(1, "OK").with(jwtToken.signToken(userDemo)).build();
    }

    public UserOracle register(UserOracle userOracle) {
        return userRepository.register(userOracle);
    }
}
