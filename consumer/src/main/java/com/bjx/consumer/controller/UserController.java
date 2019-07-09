package com.bjx.consumer.controller;


import com.bjx.consumer.bean.Constant;
import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.entity.*;
import com.bjx.consumer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("courseList", courseService.recommendCourse());
        return "user/index";
    }

    @RequestMapping("collectionPage")
    public String collectionList(Model model) {
        model.addAttribute("collectionList", collectionService.findUserCollection(getCurrentUser().getId()));

        return "user/collection";
    }

    @RequestMapping("attentionPage")
    public String collection(Model model, Long userId) {
        model.addAttribute("userList", userService.findAttention(userId));
        return "user/attention";
    }

    @RequestMapping("person")
    public String person(Model model, Long userId) {
        User currentUser = getCurrentUser();
        boolean own = true;
        //进入他人个人主页
        if(userId != null && !userId.equals(currentUser.getId())){
            own = false;
            currentUser = userService.findById(userId);
        }
        model.addAttribute("own", own);
        model.addAttribute("currentUser", currentUser);

        return "user/person";
    }

    @ResponseBody
    @RequestMapping("editUser")
    public ResponseDto editUser(@RequestBody User user){
        User editUser = userService.editUser(user,getCurrentUser());

        request.getSession().setAttribute(Constant.CURRENT_USER, editUser);

        return new ResponseDto(true);
    }


    @ResponseBody
    @RequestMapping("editPwd")
    public ResponseDto editPwd(String oldPwd,String newPwd) {
        ResponseDto responseDto = new ResponseDto(false);

        User user = getCurrentUser();
        if(!user.getPassword().equals(oldPwd)){
            responseDto.setMessage("旧密码错误");
            return responseDto;
        }
        user.setPassword(newPwd);
        userService.save(user);
        responseDto.setSuccess(true);

        return responseDto;
    }

    @RequestMapping("courseIndex")
    public String courseIndex(Long courseId,Model model) {
        model.addAttribute("videoList", videoService.findByCourseId(courseId));
        model.addAttribute("course", courseService.findById(courseId));
        return "user/course";
    }

    @RequestMapping("commentList")
    public String commentList(Long courseId,Model model) {
        model.addAttribute("commentList", commentService.findByCourseId(courseId));
        return "user/comment";
    }

    @RequestMapping("teacherCoursePage")
    public String teacherCoursePage(String teacherName,Model model) {
        model.addAttribute("courseList", courseService.findByTeacher(teacherName));
        return "user/teacher_course";
    }

    @ResponseBody
    @RequestMapping("report")
    public ResponseDto courseIndex(Long commentId) {
        commentService.updateStatus(commentId, 2);

        return new ResponseDto(true);
    }

    @ResponseBody
    @RequestMapping("collection")
    public ResponseDto collection(Long courseId, Long videoId) {
        return collectionService.collection(courseId, getCurrentUser().getId(), videoId);
    }

    @ResponseBody
    @RequestMapping("recordProgress")
    public ResponseDto recordProgress(Long courseId, Long videoId) {
        collectionService.recordProgress(courseId, getCurrentUser().getId(), videoId);
        return new ResponseDto(true);
    }

    @ResponseBody
    @RequestMapping("attention")
    public ResponseDto attention(Long userId) {
        Attention attention = new Attention();
        attention.setUserId(userId);
        attention.setOwnId(getCurrentUser().getId());
        attentionService.save(attention);

        return new ResponseDto(true);
    }

    @ResponseBody
    @RequestMapping("comment")
    public ResponseDto comment(@RequestBody Comment comment) {
        ResponseDto responseDto = new ResponseDto(true);

        User currentUser = getCurrentUser();

        //当前时间还没到禁言时间不可评论
        if(currentUser.getBannedTime() != null && LocalDateTime.now().isBefore(currentUser.getBannedTime())){
            responseDto.setSuccess(false);
            responseDto.setMessage("您已被管理员禁言,不可发表评论");
        }else {
            comment.setUserId(currentUser.getId());
            comment.setUserName(currentUser.getRealName());
            commentService.save(comment);
        }
        return responseDto;
    }



}
