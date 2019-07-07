package com.example.system_management.dao;

import com.example.system_management.model.UserDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
     String login(@Param("userName") String userName, @Param("password") String password);

}
