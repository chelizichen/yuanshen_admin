package com.czq.back.entity;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "signature")
    private String signature;

    @Column(name = "level")
    private String level;

    @Column(name = "logintime")
    private String loginTime;

    @Column(name = "createtime")
    private String createTime;

    @Column(name = "truthname")
    private String truthName;

    @Column(name = "avatar")
    private String avatar;

    // Constructors, getters, and setters

    // Default constructor
    public User() {
    }

    // Getters and setters for all fields




    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // signature
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    // level
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    // truthName
    public String getTruthName() {
        return truthName;
    }

    public void setTruthName(String truthName) {
        this.truthName = truthName;
    }

    // avatar
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
