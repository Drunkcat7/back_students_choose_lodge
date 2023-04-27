package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.UserSelectedRoom;

import java.util.List;
import java.util.Map;

/**
 * (UserSelectedRoom)表服务接口
 *
 * @author makejava
 * @since 2023-04-27 02:39:43
 */
public interface UserSelectedRoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param userSelectedRoomId 主键
     * @return 实例对象
     */
    UserSelectedRoom queryById(Integer userSelectedRoomId);

    /**
     * 新增数据
     *
     * @param userSelectedRoom 实例对象
     * @return 实例对象
     */
    UserSelectedRoom insert(UserSelectedRoom userSelectedRoom);

    /**
     * 修改数据
     *
     * @param userSelectedRoom 实例对象
     * @return 实例对象
     */
    UserSelectedRoom update(UserSelectedRoom userSelectedRoom);

    /**
     * 通过主键删除数据
     *
     * @param userSelectedRoomId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userSelectedRoomId);

    /**
     * 获取房间管理信息
     *
     * @return Map
     */
    List<Map<String, Object>> roomManagementInfo();

    /**
     * 我的房间
     */
    Map<String, Object> myRoom(Integer uid);

    /**
     * 删除用户宿舍选择
     *
     * @param uid
     * @return
     */
    Boolean deselectUserRoom(Integer uid);


    /**
     * 学生加入宿舍，选床
     * @param buildingId
     * @param roomId
     * @param bedNumber
     * @param uid
     * @return
     */
    Boolean insertUserRoom(Integer buildingId,Integer roomId,Integer bedNumber,Integer uid);

}
