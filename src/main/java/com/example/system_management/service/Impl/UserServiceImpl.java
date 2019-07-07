package com.example.system_management.service.Impl;

import com.example.system_management.dao.UserDao;
import com.example.system_management.model.UserDomain;
import com.example.system_management.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserDomain user) {

        return userDao.insert(user);
    }

    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserDomain> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public String login(String userName, String password) {
        return userDao.login(userName,password);
    }


}
