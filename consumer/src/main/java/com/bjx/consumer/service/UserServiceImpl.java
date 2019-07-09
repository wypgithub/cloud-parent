package com.bjx.consumer.service;


import com.bjx.consumer.bean.Constant;
import com.bjx.consumer.bean.ResponseDto;
import com.bjx.consumer.dao.UserRepository;
import com.bjx.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAttention(Long userId) {
        return userRepository.findAttention(userId);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void banned(Long userId, Integer duration) {
        User user = userRepository.findById(userId).get();
        user.setBannedTime(LocalDateTime.now().plusDays( duration));
        userRepository.save(user);
    }

    @Override
    public User editUser(User user, User currentUser) {
        currentUser.setRealName(user.getRealName());
        currentUser.setSex(user.getSex());
        currentUser.setEmail(user.getEmail());
        currentUser.setAge(user.getAge());
        currentUser.setPhone(user.getPhone());
        userRepository.save(currentUser);

        return currentUser;
    }

    @Override
    public ResponseDto registeredUser(User user) {
        ResponseDto response = new ResponseDto(true);

        User exist = userRepository.findByUserName(user.getUserName());
        //Account has been registered
        if(exist != null){
            response.setSuccess(false);
            response.setMessage("The account has been registered, please change a account");
        }else {
            userRepository.save(user);
        }

        return response;
    }

    @Override
    public ResponseDto login(String userName, String password, HttpServletRequest request) {
        ResponseDto response = new ResponseDto(true);

        User user = userRepository.findByUserNameAndPassword(userName, password);
        if(user == null){
            response.setSuccess(false);
            response.setMessage("Invalid account or password");
        }else {
            //Store user information to session
            request.getSession().setAttribute(Constant.CURRENT_USER, user);
        }

        return response;
    }
}
