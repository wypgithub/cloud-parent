package com.bjx.provider.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(nullable = false, name = "name")
    private String name;

    /**
     * 教师
     */
    @Column(nullable = false, name = "teacher")
    private String teacher;

    /**
     * 推荐排序
     */
    @Column(nullable = false, name = "sort_order")
    private Integer order;

    /**
     * 创建时间
     */
    @Column(nullable = false, name = "create_time")
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
