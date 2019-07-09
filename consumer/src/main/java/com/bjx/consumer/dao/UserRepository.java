package com.bjx.consumer.dao;

import com.bjx.consumer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    /**
     * 用户法规，次数加1
     * @param id 用户ID
     */
    @Modifying
    @Query(value = "update user set fouls_size = fouls_size+1 where id=?1",nativeQuery = true)
    void foul(Long id);

    @Query("select u from User u,Attention a where u.id=a.userId and a.ownId = ?1")
    List<User> findAttention(Long userId);
}
