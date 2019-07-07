package com.example.system_management.service;

import com.example.system_management.model.UserDomain;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);


    String login(String userName, String password);
}