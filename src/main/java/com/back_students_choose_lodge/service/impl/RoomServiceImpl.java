package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.BuildingDao;
import com.back_students_choose_lodge.entity.Building;
import com.back_students_choose_lodge.entity.Room;
import com.back_students_choose_lodge.dao.RoomDao;
import com.back_students_choose_lodge.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Room)表服务实现类
 *
 * @author makejava
 * @since 2023-04-25 23:05:39
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomDao roomDao;
    @Resource
    private BuildingDao buildingDao;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param buildingId 宿舍楼id
     * @return 对象列表
     */
    @Override
    public List<Room> queryAllRoom(int buildingId) {
        Room room = new Room();
        room.setBuildingId(buildingId);
        return this.roomDao.queryAll(room);
    }

    /**～～～～～～～～～～～～～～～～～～～～～～·*/

    /**
     * 通过ID查询单条数据
     *
     * @param roomId 主键
     * @return 实例对象
     */
    @Override
    public Room queryById(Integer roomId) {
        return this.roomDao.queryById(roomId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Room> queryAllByLimit(int offset, int limit) {
        return this.roomDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    @Override
    public Room insert(Room room) {
        this.roomDao.insert(room);
        return room;
    }

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    @Override
    public Room update(Room room) {
        this.roomDao.update(room);
        return this.queryById(room.getRoomId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roomId) {
        return this.roomDao.deleteById(roomId) > 0;
    }
}
