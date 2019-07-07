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
       @GetMapping("/index")
        public ModelAndView toIndex(){
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("index");
                return modelAndView;
        }



    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "login_action")
    public ModelAndView login_action(String userName,String password, HttpServletRequest request, HttpSession session){
           ModelAndView mav=new ModelAndView();
        session.setAttribute("userName",userName);
        session.setAttribute("password",password);
          /* String n= userService.login(userName,password);*/

       /* if (n!=null){*/
        if (userService.login(userName,password)!=null){
            mav.setViewName("index");
            return mav;
        }else {
            session.setAttribute("errormsg","账号或密码错误");
        }
        mav.setViewName("login");
        return  mav;
    }


}
