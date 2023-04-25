package com.back_students_choose_lodge.entity;

import java.io.Serializable;

/**
 * (Building)实体类
 *
 * @author makejava
 * @since 2023-04-25 17:44:12
 */
public class Building implements Serializable {
    private static final long serialVersionUID = 682240885152594273L;
    /**
     * 楼id
     */
    private Integer buildingId;
    /**
     * 楼名
     */
    private String buildingName;
    /**
     * 楼层
     */
    private Integer buildingFloor;
    /**
     * 每层房数
     */
    private Integer buildingRoomSum;
    /**
     * 性别
     */
    private String sex;


    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(Integer buildingFloor) {
        this.buildingFloor = buildingFloor;
    }

    public Integer getBuildingRoomSum() {
        return buildingRoomSum;
    }

    public void setBuildingRoomSum(Integer buildingRoomSum) {
        this.buildingRoomSum = buildingRoomSum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
