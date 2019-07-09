package com.bjx.provider.util;

import com.bjx.provider.entity.Course;
import com.bjx.provider.vo.CourseVO;

public class CommonUtils {
    /**
     * 转化持久类为VO
     * @param course 持久类
     * @return 对象VO
     */
    public static CourseVO covert(Course course){
        CourseVO courseVO = new CourseVO();
        courseVO.setCreateTime(course.getCreateTime());
        courseVO.setId(course.getId());
        courseVO.setName(course.getName());
        courseVO.setOrder(course.getOrder());
        courseVO.setTeacher(course.getTeacher());

        return courseVO;
    }

    /**
     * VO转化为持久类
     * @param courseVO 持久类
     * @return 对象VO
     */
    public static Course covert( CourseVO courseVO){
        Course course = new Course();
        course.setCreateTime(courseVO.getCreateTime());
        course.setId(courseVO.getId());
        course.setName(courseVO.getName());
        course.setOrder(courseVO.getOrder());
        course.setTeacher(courseVO.getTeacher());

        return course;
    }

}
