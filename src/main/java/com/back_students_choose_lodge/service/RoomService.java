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
     * @param buildingId 宿舍楼id
     * @return 对象列表
     */
    List<Room> queryAllRoom(Integer buildingId);

    /**
     * 修改专业
     *
     * @param roomId 房间id列表
     * @return 影响行数
     */
    int updateProfessionalByRoomId(String professional, Integer[] roomId);


    /**
     * 获取我的所有房间
     * @param uid 用户id
     * @return 对象列表
     */
    List<Room> queryMyAllRoom(Integer uid);


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
