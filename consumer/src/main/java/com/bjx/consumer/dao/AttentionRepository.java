package com.bjx.consumer.dao;

import com.bjx.consumer.entity.Attention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttentionRepository extends JpaRepository<Attention,Long> {
    Attention save(Attention attention);

}
