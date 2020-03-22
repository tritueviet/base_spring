package com.ecommerce.ibg.api.repository;

import com.ecommerce.ibg.api.api.RestApi;
import com.ecommerce.ibg.model.user.UserDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UtilsRepository {
    private RestApi restApi;

    @Autowired
    public UtilsRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    public UserDemo callApi(UserDemo userDemo) {
        return restApi.callApiDemo(userDemo);
    }
}
