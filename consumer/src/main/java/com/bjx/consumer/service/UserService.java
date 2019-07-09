package com.bjx.consumer.service;


import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    List<User> findAttention(Long userId);

    void banned(Long userId, Integer duration);

    ResponseDto registeredUser(User user);

    User editUser(User user, User currentUser);

    ResponseDto login(String userName, String password, HttpServletRequest request);
}
