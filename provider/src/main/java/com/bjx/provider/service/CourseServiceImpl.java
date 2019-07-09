package com.bjx.provider.service;

import com.bjx.provider.dao.CourseRepository;
import com.bjx.provider.entity.Course;
import com.bjx.provider.util.CommonUtils;
import com.bjx.provider.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
public class CourseServiceImpl{
    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping("/findById")
    CourseVO findById(@RequestParam("id") Long id){
        return CommonUtils.covert(courseRepository.findById(id).get());
    }

    @RequestMapping("/save")
    public CourseVO save(@RequestBody CourseVO course) {
        return CommonUtils.covert(courseRepository.save(CommonUtils.covert(course)));
    }

    @RequestMapping("/findAll")
    public List<CourseVO> findAll() {
        List<CourseVO> courseVOS = new ArrayList<CourseVO>();

        List<Course> all = courseRepository.findAll();
        for(Course course : all){
            courseVOS.add( CommonUtils.covert(course));
        }

        return courseVOS;
    }

    @RequestMapping("/findByTeacher")
    public List<CourseVO> findByTeacher(@RequestParam("teacher") String teacher) {
        List<CourseVO> courseVOS = new ArrayList<CourseVO>();
        List<Course> all = courseRepository.findByTeacher(teacher);
        for(Course course : all){
            courseVOS.add( CommonUtils.covert(course));
        }

        return courseVOS;
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("courseId") Long courseId) {
        courseRepository.delete(courseId);
    }

    @RequestMapping("/recommendCourse")
    public List<List<CourseVO>> recommendCourse() {
        List<List<CourseVO>> courseList= new ArrayList<List<CourseVO>>();

        List<Course> all = courseRepository.recommendCourse();
        if (all.size() == 0){
            return courseList;
        }

        // 排序结果
        Course[] sortResult = new Course[all.size()];
        //固定位置排序剩余结果
        List<Course> remain = new ArrayList<Course>();
        for(Course course : all){
            if(course.getOrder().intValue() != -1){
                sortResult[course.getOrder().intValue() - 1] = course;
            }else {
                remain.add(course);
            }
        }

        //将剩余依次放进去
        int index = 0;
        for(int i=0;i<sortResult.length;i++){
            if(sortResult[i] == null){
                sortResult[i] = remain.get(index++);
            }
        }


        //按照前端界面一行一组4课程规则进行组合
        List<CourseVO> temp = new ArrayList<CourseVO>();
        for(int i=0;i<sortResult.length;i++){
            temp.add(CommonUtils.covert(sortResult[i]));
            //组合一组数据
            if(temp.size() == 4){
                courseList.add(temp);
                temp = new ArrayList<CourseVO>();
            }
        }
        if(all.size() % 4 != 0){
            courseList.add(temp);
        }

        return courseList;
    }
}
