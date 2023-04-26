package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author makejava
 * @since 2023-04-26 14:27:31
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = -59951322067983714L;
    /**
     * 标签id 主键
     */
    private Integer tagId;
    /**
     * 标签标题例如：爱好
     */
    private String tagTitle;
    /**
     * 标签内容
     */
    private String tagContext;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public String getTagContext() {
        return tagContext;
    }

    public void setTagContext(String tagContext) {
        this.tagContext = tagContext;
    }

}

