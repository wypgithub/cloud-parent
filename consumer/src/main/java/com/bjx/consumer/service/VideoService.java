package com.bjx.consumer.service;

import com.bjx.consumer.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    Video findById(Long videoId);

    List<Video> findByCourseId(Long courseId);

    Video save(Video video);

    void delete(Long videoId);

    Object uploadVideo(MultipartFile fileUpload, Long id, Integer type);
}
