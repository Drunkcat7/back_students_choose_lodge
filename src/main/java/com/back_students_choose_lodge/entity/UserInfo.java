package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2023-04-25 22:35:32
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 570961896311192727L;
    /**
     * 用户信息id
     */
    private Integer userInfoId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 考生号
     */
    private Integer studentId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 考生号
     */
    private String professional;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String tel;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 是否已选宿舍(0未选，1已选)
     */
    private Integer isSelectedRoom;
    /**
     * 是否确认信息（0未确认，1确认）
     */
    private Integer isConfirmUserInfo;
    /**
     * 是否可以修改tag(0可以修改，1不可以修改)
     */
    private Integer isUpdateTag;


    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIsSelectedRoom() {
        return isSelectedRoom;
    }

    public void setIsSelectedRoom(Integer isSelectedRoom) {
        this.isSelectedRoom = isSelectedRoom;
    }

    public Integer getIsConfirmUserInfo() {
        return isConfirmUserInfo;
    }

    public void setIsConfirmUserInfo(Integer isConfirmUserInfo) {
        this.isConfirmUserInfo = isConfirmUserInfo;
    }

    public Integer getIsUpdateTag() {
        return isUpdateTag;
    }

    public void setIsUpdateTag(Integer isUpdateTag) {
        this.isUpdateTag = isUpdateTag;
    }

}

