package com.bjx.provider.dao;

import com.bjx.provider.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course,Long> {
    @Modifying
    @Query("delete from Course c where c.id = ?1")
    void delete(long id);

    List<Course> findByTeacher(String teacher);

    @Query(value = "select cou.* from course cou left join collection col on cou.id=col.course_id GROUP BY cou.id ORDER BY COUNT(cou.id) DESC",nativeQuery = true)
    List<Course> recommendCourse();
}
