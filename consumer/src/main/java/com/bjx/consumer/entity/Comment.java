package com.bjx.consumer.entity;

import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 内容
     */
    @Column(nullable = false, name = "content")
    private String content;

    /**
     * 用户ID
     */
    @Column(nullable = false, name = "user_id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Column(nullable = false, name = "user_name")
    private String userName;

    /**
     * 课程ID
     */
    @Column(nullable = false, name = "course_id")
    private Long courseId;

    /**
     * 状态 1-正常 2-被举报
     */
    @Column(nullable = false, name = "status")
    private Integer status = 1;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
