package com.bjx.consumer.service;

import com.bjx.consumer.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    void save(Comment comment);

    /**
     * 编辑评论状态
     * @param id 评论ID
     * @param status 状态
     */
    void updateStatus(Long id, Integer status);

    /**
     * 查询课程评论
     * @param courseId 课程ID
     */
    List<Comment> findByCourseId(Long courseId);


    /**
     * 评论审核是否属实
     * @param commentId ID
     * @param flag 是否属实
     * @param userId 举报用户ID
     */
    void review(Long commentId, boolean flag, Long userId);
}
