package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (Room)实体类
 *
 * @author makejava
 * @since 2023-04-25 23:05:38
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 262334729946632398L;
    /**
     * 房间id
     */
    private Integer roomId;
    /**
     * 楼id
     */
    private Integer buildingId;
    /**
     * 房间名字
     */
    private String roomName;
    /**
     * 专业
     */
    private String professional;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

}
