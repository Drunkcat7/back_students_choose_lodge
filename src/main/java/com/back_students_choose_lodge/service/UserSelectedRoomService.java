package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.UserSelectedRoom;

import java.util.List;

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

}
