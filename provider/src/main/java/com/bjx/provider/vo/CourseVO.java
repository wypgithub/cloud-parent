package com.bjx.provider.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseVO implements Serializable {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 教师
     */
    private String teacher;

    /**
     * 推荐排序
     */
    private Integer order;

    /**
     * 创建时间
     */
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
