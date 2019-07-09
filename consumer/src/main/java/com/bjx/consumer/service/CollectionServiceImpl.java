package com.bjx.consumer.service;

import com.bjx.consumer.bean.CollectionVO;
import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.dao.CollectionRepository;
import com.bjx.consumer.entity.Collection;
import com.bjx.consumer.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CollectionRepository collectionRepository;


    @Override
    public ResponseDto collection(Long courseId, Long userId, Long videoId) {
        ResponseDto responseDto = new ResponseDto(true);

        //不能重复收藏
        List<Collection> collections = collectionRepository.findByUserIdAndCourseId(userId, courseId);
        if(collections != null && collections.size() > 0){
            responseDto.setSuccess(false);
        }

        Collection collection = new Collection();
        collection.setUserId(userId);
        collection.setCourseId(courseId);
        collection.setVideoId(videoId);
        collectionRepository.save(collection);

        return responseDto;
    }

    @Override
    public List<CollectionVO> findUserCollection(Long userId) {
        List<Collection> collections = collectionRepository.findByUserId(userId);


        List<CollectionVO> list = new ArrayList<CollectionVO>();
        if(collections == null || collections.size() == 0){
            return list;
        }

        for(Collection collection : collections){
            CourseVO courseVO = courseService.findById( collection.getCourseId());

            CollectionVO vo = new CollectionVO();
            vo.setCourseId(courseVO.getId());
            vo.setCourseName(courseVO.getName());
            vo.setVideoId(collection.getVideoId());
            vo.setVideoName(videoService.findById(collection.getVideoId()).getName());

            list.add(vo);
        }

        return list;
    }


    @Override
    public void recordProgress(Long courseId, Long userId, Long videoId) {
        List<Collection> collections = collectionRepository.findByUserIdAndCourseId(userId, courseId);
        if(collections != null && collections.size() > 0){
            Collection collection = collections.get(0);
            collection.setVideoId(videoId);
            collectionRepository.save(collection);
        }
    }
}
