package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (UserSelectedRoom)实体类
 *
 * @author makejava
 * @since 2023-04-26 23:22:33
 */
public class UserSelectedRoom implements Serializable {
    private static final long serialVersionUID = 499956860364420077L;
    /**
     * 用户选宿id
     */
    private Integer userSelectedRoom;
    /**
     * 楼id
     */
    private Integer buildingId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 房间id
     */
    private Integer roomId;


    public Integer getUserSelectedRoom() {
        return userSelectedRoom;
    }

    public void setUserSelectedRoom(Integer userSelectedRoom) {
        this.userSelectedRoom = userSelectedRoom;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

}

