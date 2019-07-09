package com.bjx.consumer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * entity of user
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "real_name")
    private String realName;

    @Column(nullable = false, name = "age")
    private int age;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "phone")
    private String phone;

    @Column(nullable = false, name = "sex")
    private String sex;

    /**
     * 禁言截止时间
     */
    @Column(nullable = true, name = "banned_time")
    private LocalDateTime bannedTime;

    /**
     * 犯规次数
     */
    @Column(nullable = true, name = "fouls_size")
    private Integer foulsSize = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getFoulsSize() {
        return foulsSize;
    }

    public void setFoulsSize(Integer foulsSize) {
        this.foulsSize = foulsSize;
    }

    public LocalDateTime getBannedTime() {
        return bannedTime;
    }

    public void setBannedTime(LocalDateTime bannedTime) {
        this.bannedTime = bannedTime;
    }
}
