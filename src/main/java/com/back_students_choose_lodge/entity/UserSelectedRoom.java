package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (UserSelectedRoom)实体类
 *
 * @author makejava
 * @since 2023-04-27 02:39:42
 */
public class UserSelectedRoom implements Serializable {
    private static final long serialVersionUID = 231824047040657000L;
    /**
     * 用户选宿id
     */
    private Integer userSelectedRoomId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 楼id
     */
    private Integer buildingId;
    /**
     * 房间id
     */
    private Integer roomId;
    /**
     * 床号1,2,3,4
     */
    private Integer bedNumber;


    public Integer getUserSelectedRoomId() {
        return userSelectedRoomId;
    }

    public void setUserSelectedRoomId(Integer userSelectedRoomId) {
        this.userSelectedRoomId = userSelectedRoomId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

}
