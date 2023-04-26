package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (UserSelectedTag)实体类
 *
 * @author makejava
 * @since 2023-04-26 17:10:32
 */
public class UserSelectedTag implements Serializable {
    private static final long serialVersionUID = 681298843390776075L;
    /**
     * 用户选择标签id
     */
    private Integer userSelectedTagId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 标签id
     */
    private Integer tagId;


    public Integer getUserSelectedTagId() {
        return userSelectedTagId;
    }

    public void setUserSelectedTagId(Integer userSelectedTagId) {
        this.userSelectedTagId = userSelectedTagId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}

