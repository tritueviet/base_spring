package com.ecommerce.ibg.repository.user;

import com.ecommerce.ibg.model.oracle.UserOracle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserDatabase userDatabase;

    public UserOracle register(UserOracle userOracle) {
        return userDatabase.save(userOracle);
    }

    public UserOracle login(String userName, String password) {
        return userDatabase.login(userName, password);
    }
}
