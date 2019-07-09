package com.bjx.consumer.service;

import com.bjx.consumer.dao.CommentRepository;
import com.bjx.consumer.dao.UserRepository;
import com.bjx.consumer.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Comment> findAll() {
        //查询被举报的评论
        return commentRepository.findByStatus(2);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        commentRepository.updateStatus(id, status);
    }

    @Override
    public List<Comment> findByCourseId(Long courseId) {
        return commentRepository.findByCourseId(courseId);
    }

    @Override
    public void review(Long commentId, boolean flag, Long userId) {
        if(flag){
            //举报属实直接删除评论
            commentRepository.delete(commentId);

            //对用户犯规次数加1
            userRepository.foul(userId);
        }else {
            //举报不属实 忽略此次举报
            commentRepository.updateStatus(commentId, 1);
        }
    }
}
