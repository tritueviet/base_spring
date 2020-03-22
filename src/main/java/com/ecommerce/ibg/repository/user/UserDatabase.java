package com.ecommerce.ibg.repository.user;

import com.ecommerce.ibg.model.oracle.UserOracle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserDatabase extends JpaRepository<UserOracle, Long> {

    @Query("select c from UserOracle c where c.id = :id")
    Stream<UserOracle> findById(@Param("id") String id);

    @Query("select c from UserOracle c where (c.phone = :username or c.email= :username) and c.password = :password")
    UserOracle login(@Param("username") String username, @Param("password") String password);
}