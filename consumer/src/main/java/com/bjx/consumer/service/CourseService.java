package com.bjx.consumer.service;

import com.bjx.consumer.vo.CourseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider")
public interface CourseService{
    @RequestMapping("/findById")
    CourseVO findById(@RequestParam("id") Long id);

    @RequestMapping("/findAll")
    List<CourseVO> findAll();

    @RequestMapping("/findByTeacher")
    List<CourseVO> findByTeacher(@RequestParam("teacher") String teacher);

    @RequestMapping("/save")
    CourseVO save(@RequestBody CourseVO course);

    @RequestMapping("/delete")
    void delete(@RequestParam("courseId") Long courseId);

    @RequestMapping("/recommendCourse")
    List<List<CourseVO>> recommendCourse();
}
