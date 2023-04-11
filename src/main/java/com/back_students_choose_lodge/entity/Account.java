package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2023-04-10 21:23:01
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -44072115420120065L;
    /**
     * uid
     */
    private Integer uid;
    
    private String user;
    
    private String password;
    /**
     * 用户等级
     */
    private Integer level;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}

