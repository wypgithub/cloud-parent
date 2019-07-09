package com.bjx.consumer.controller;

import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.entity.Video;
import com.bjx.consumer.service.CommentService;
import com.bjx.consumer.service.CourseService;
import com.bjx.consumer.service.UserService;
import com.bjx.consumer.service.VideoService;
import com.bjx.consumer.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController{
    @Autowired
    private CourseService courseService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("test")
    public String banned(Long userId, Integer duration) {
        return "11111111111111111";
    }



}
