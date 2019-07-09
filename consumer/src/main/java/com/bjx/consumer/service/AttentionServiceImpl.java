package com.bjx.consumer.service;

import com.bjx.consumer.dao.AttentionRepository;
import com.bjx.consumer.entity.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionRepository attentionRepository;

    @Override
    public Attention save(Attention attention) {
        return attentionRepository.save(attention);
    }
}
