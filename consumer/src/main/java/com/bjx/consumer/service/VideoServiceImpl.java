package com.bjx.consumer.service;

import com.bjx.consumer.dao.VideoRepository;
import com.bjx.consumer.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {
    private static final String separator = "/";

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video findById(Long videoId) {
        return videoRepository.findById(videoId).get();
    }

    @Override
    public List<Video> findByCourseId(Long courseId){
        return videoRepository.findByCourseId(courseId);
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void delete(Long videoId) {
        videoRepository.delete(videoId);
    }

    /**
     * 保存数据库对象
     * @param type 类型 1-课程图片 2-课程视频
     * @return
     */
    @Override
    public Object uploadVideo(MultipartFile fileUpload, Long id, Integer type) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();

        String classPath = this.getClass().getResource("/").getPath().substring(1) + "static";

        String filePath;
        if(type.intValue() == 1){
            filePath = classPath + separator + "course";
            fileName = id + ".jpg";
        }else{
            filePath = classPath + separator + "video";
            fileName = id + ".mp4";
        }
        Map<String,Object> map=new HashMap<>();
        try {
            File dir = new File(filePath);
            if (!dir.exists()){
                dir.mkdirs();
            }

            File file = new File(filePath + separator + fileName);
            if (file.exists()){
                file.delete();
            }
            fileUpload.transferTo(file);

            map.put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",1);
        }

        return map;
    }

}
