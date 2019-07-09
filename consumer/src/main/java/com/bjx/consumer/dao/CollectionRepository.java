package com.bjx.consumer.dao;

import com.bjx.consumer.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Long> {
    List<Collection> findByUserId(Long userId);

    List<Collection> findByUserIdAndCourseId(Long userId, Long courseId);
}
