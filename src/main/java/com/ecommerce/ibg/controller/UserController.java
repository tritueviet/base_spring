package com.ecommerce.ibg.controller;

import com.ecommerce.ibg.controller.base.BaseController;
import com.ecommerce.ibg.model.base.BaseResponse;
import com.ecommerce.ibg.model.base.ResponseImpl;
import com.ecommerce.ibg.model.oracle.UserOracle;
import com.ecommerce.ibg.model.user.UserDemo;
import com.ecommerce.ibg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1.0/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController() {
    }

    @PostMapping("login")
    public ResponseEntity<BaseResponse<String>> login(@RequestBody UserDemo userDemo) {
        return ResponseEntity.ok().body(userService.login(userDemo));
    }

    @PostMapping("register")
    public ResponseEntity<BaseResponse<UserOracle>> register(@RequestBody UserOracle userOracle) {
        return ResponseEntity.ok().body(ResponseImpl.ok().with(1, "OK").with(userService.register(userOracle)).build());
    }

    @GetMapping("validToken")
    public ResponseEntity<BaseResponse<UserDemo>> validDataToken(@RequestHeader("Authorization") String token) {
        BaseResponse<UserDemo> baseResponse = validToken(token);
        if (baseResponse.getStatus() != 1) {
            return ResponseEntity.ok().body(baseResponse);
        }
        return ResponseEntity.ok().body(baseResponse);
    }
}
