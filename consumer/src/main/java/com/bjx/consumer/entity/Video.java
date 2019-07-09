package com.bjx.consumer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(nullable = false, name = "name")
    private String name;

    /**
     * 创建时间
     */
    @Column(nullable = false, name = "create_time")
    private LocalDateTime createTime;

    /**
     * 课程ID
     */
    @Column(nullable = false, name = "course_id")
    private Long courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
