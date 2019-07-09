package com.bjx.consumer.service;


import com.bjx.consumer.bean.CollectionVO;
import com.bjx.consumer.bean.ResponseDto;

import java.util.List;

public interface CollectionService {
    ResponseDto collection(Long courseId, Long userId, Long videoId);

    List<CollectionVO> findUserCollection(Long userId);

    void recordProgress(Long courseId, Long userId, Long videoId);
}
