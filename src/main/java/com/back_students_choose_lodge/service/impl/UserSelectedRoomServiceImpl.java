package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.UserSelectedRoomDao;
import com.back_students_choose_lodge.entity.UserSelectedRoom;
import com.back_students_choose_lodge.service.UserSelectedRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (UserSelectedRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 02:39:43
 */
@Service("userSelectedRoomService")
public class UserSelectedRoomServiceImpl implements UserSelectedRoomService {
    @Resource
    private UserSelectedRoomDao userSelectedRoomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userSelectedRoomId 主键
     * @return 实例对象
     */
    @Override
    public UserSelectedRoom queryById(Integer userSelectedRoomId) {
        return this.userSelectedRoomDao.queryById(userSelectedRoomId);
    }

    /**
     * 新增数据
     *
     * @param userSelectedRoom 实例对象
     * @return 实例对象
     */
    @Override
    public UserSelectedRoom insert(UserSelectedRoom userSelectedRoom) {
        this.userSelectedRoomDao.insert(userSelectedRoom);
        return userSelectedRoom;
    }

    /**
     * 修改数据
     *
     * @param userSelectedRoom 实例对象
     * @return 实例对象
     */
    @Override
    public UserSelectedRoom update(UserSelectedRoom userSelectedRoom) {
        this.userSelectedRoomDao.update(userSelectedRoom);
        return this.queryById(userSelectedRoom.getUserSelectedRoomId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userSelectedRoomId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userSelectedRoomId) {
        return this.userSelectedRoomDao.deleteById(userSelectedRoomId) > 0;
    }
}
