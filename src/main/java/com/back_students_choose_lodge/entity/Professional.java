package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (Professional)实体类
 *
 * @author makejava
 * @since 2023-04-26 10:36:27
 */
public class Professional implements Serializable {
    private static final long serialVersionUID = -57199730803254184L;
    /**
     * 专业id 主键
     */
    private Integer professionalId;
    /**
     * 专业名
     */
    private String professionalContent;


    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getProfessionalContent() {
        return professionalContent;
    }

    public void setProfessionalContent(String professionalContent) {
        this.professionalContent = professionalContent;
    }

}

