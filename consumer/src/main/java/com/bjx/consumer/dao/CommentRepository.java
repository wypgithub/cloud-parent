package com.bjx.consumer.dao;

import com.bjx.consumer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByStatus(Integer status);

    List<Comment> findByCourseId(Long courseId);

    @Modifying
    @Query("delete from Comment c where c.id = ?1")
    void delete(long id);

    @Modifying
    @Query(value = "update Comment c set c.status = ?2 where c.id=?1")
    void updateStatus(Long id, Integer status);
}
