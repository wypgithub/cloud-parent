package com.bjx.consumer.bean;


public class CollectionVO {
    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 学习进度视频ID
     */
    private Long videoId;
    /**
     * 学习进度视频名称
     */
    private String videoName;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public CollectionVO() {
    }

    public CollectionVO(Long courseId, String courseName, Long videoId, String videoName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.videoId = videoId;
        this.videoName = videoName;
    }
}
