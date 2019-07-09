package com.bjx.consumer.controller;

import com.bjx.consumer.bean.Constant;
import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.entity.User;
import com.bjx.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController extends BaseController{
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("login")
    public ResponseDto login(String userName, String password){
        return userService.login(userName, password, request);
    }

    @ResponseBody
    @RequestMapping("registered")
    public ResponseDto registeredUser(@RequestBody User user){
        return userService.registeredUser(user);
    }

    @RequestMapping("logout")
    public void logout(HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(Constant.CURRENT_USER);
        response.sendRedirect("/loginPage");
    }
}
