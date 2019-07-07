package com.example.system_management.controller;

import com.example.system_management.model.UserDomain;
import com.example.system_management.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
        @Autowired
        private UserService userService;

        @ResponseBody
        @PostMapping("/add")
        public int addUser(UserDomain user){
            return userService.addUser(user);
        }

        @ResponseBody
        @GetMapping("/all")
        public Object findAllUser(
                @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                        int pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                        int pageSize){
            return userService.findAllUser(pageNum,pageSize);
        }

        @RequestMapping("/get_user_list")
        public Object getUserList(Integer draw,Integer start,Integer length){
                PageInfo<UserDomain> pageInfo=userService.findAllUser((start/length)+1,length);


                ResultData<UserDomain> resultData =new ResultData();
               /* resultData.setData(pageInfo.getList());
                resultData.setDraw(draw);
                resultData.setRecordsTotal(Integer.parseInt(pageInfo.getTotal()+""));
                resultData.setRecordsFiltered(Integer.parseInt(pageInfo.getTotal()+""));*/
                return resultData;
        }

        private class ResultData<T> {
        }


        @ResponseBody
        @RequestMapping("/to_user_list")
        public ModelAndView toIndex(){
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("user/user_list");
                return modelAndView;
        }
}
