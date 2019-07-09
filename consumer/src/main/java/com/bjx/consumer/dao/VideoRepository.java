package com.bjx.consumer.dao;

import com.bjx.consumer.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {

    List<Video> findByCourseId(Long courseId);

    @Modifying
    @Query("delete from Video v where v.id = ?1")
    void delete(long id);
}
