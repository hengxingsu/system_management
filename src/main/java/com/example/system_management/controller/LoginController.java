package com.example.system_management.controller;

import com.example.system_management.model.UserDomain;
import com.example.system_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
        @Autowired
        private UserService userService;

        /**
         * 页面跳转-跳转到登录页面（login.html）
         * @return
         */


       @ResponseBody
       @GetMapping("/to_login_page")
        public ModelAndView toLoginPage(){
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("index");
                return modelAndView;
        }


}
