package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Room;

import java.util.List;

/**
 * (Room)表服务接口
 *
 * @author makejava
 * @since 2023-04-25 23:05:39
 */
public interface RoomService {

    /**
     * 通过实体作为筛选条件查询
     *
     * @param buildingName 宿舍楼名
     * @return 对象列表
     */
    List<Room> queryAllRoomByBuildingName(String buildingName);

    /** ～～～～～～～～～～～～～～～～～～～～～～～· */

    /**
     * 通过ID查询单条数据
     *
     * @param roomId 主键
     * @return 实例对象
     */
    Room queryById(Integer roomId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Room> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    Room insert(Room room);

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    Room update(Room room);

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roomId);

}
