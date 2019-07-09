package com.bjx.consumer.entity;

import javax.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户ID
     */
    @Column(nullable = false, name = "user_id")
    private Long userId;
    /**
     * 课程ID
     */
    @Column(nullable = false, name = "course_id")
    private Long courseId;
    /**
     * 学习进度视频ID
     */
    @Column(nullable = false, name = "video_id")
    private Long videoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}
