package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.RoomDao;
import com.back_students_choose_lodge.dao.UserInfoDao;
import com.back_students_choose_lodge.dao.UserSelectedRoomDao;
import com.back_students_choose_lodge.entity.Room;
import com.back_students_choose_lodge.entity.UserSelectedRoom;
import com.back_students_choose_lodge.service.UserSelectedRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private RoomDao roomDao;
    @Resource
    private UserInfoDao userInfoDao;
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

    /**
     * 获取房间管理信息
     *
     * @return Map
     */
    @Override
    public List<Map<String, Object>> roomManagementInfo() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Integer> roomIds = this.userSelectedRoomDao.queryAllRoomId();
        for (Integer roomId : roomIds) {
            Map<String, Object> map = new HashMap<>();
            List<UserSelectedRoom> userRoomList = this.userSelectedRoomDao.queryAllUid(roomId);
            for (UserSelectedRoom userSelectedRoom : userRoomList) {
                map.put("roomId", roomId);
                map.put("title", this.roomDao.roomTitle(roomId));
                map.put("bedNumber" + userSelectedRoom.getBedNumber(),
                        this.userInfoDao.queryById(userSelectedRoom.getUid()));
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 我的房间
     * @param uid
     * @return
     */
    @Override
    public Map<String, Object> myRoom(Integer uid) {
        Room room = this.roomDao.myRoom(uid);
        if (room == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("roomId", room.getRoomId());
        map.put("roomName", room.getRoomName());
        map.put("buildingId", room.getBuildingId());
        return map;
    }
}
