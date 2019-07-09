package com.bjx.consumer.controller;

import com.bjx.consumer.bean.Constant;
import com.bjx.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    /**
     * Get the currently logged in user
     * @return user
     */
    protected User getCurrentUser(){
        Object userObj = request.getSession().getAttribute(Constant.CURRENT_USER);
        return userObj == null? null : (User)userObj;
    }
}
