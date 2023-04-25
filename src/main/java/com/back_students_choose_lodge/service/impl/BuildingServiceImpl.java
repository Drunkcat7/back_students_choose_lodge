package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.RoomDao;
import com.back_students_choose_lodge.entity.Building;
import com.back_students_choose_lodge.dao.BuildingDao;
import com.back_students_choose_lodge.entity.Room;
import com.back_students_choose_lodge.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Building)表服务实现类
 *
 * @author makejava
 * @since 2023-04-25 17:44:13
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingDao buildingDao;
    @Resource
    private RoomDao roomDao;

    /**
     * 新建宿舍楼
     * @param building
     * @return 新增房间数
     */
    /**
     * 楼id  buildingId
     * 楼名   buildingName
     * 楼层   buildingFloor
     * 每层房数 buildingRoomSum
     * 性别   sex
     */
    @Override
    public int newBuilding(Building building) {
//        1. 新增宿舍楼
        int status = this.buildingDao.insert(building);

//        2. 查询新增的宿舍楼
        Building buildingLast = this.buildingDao.queryLastInfo();
        System.out.print(buildingLast.getBuildingId());

//        3. 宿舍楼 中建 房间
//        外层循环(楼层)，里层循环(每层房数)，房间名字(楼名-101)
        List<Room> roomList = new ArrayList<Room>();
        String roomName = "";
//        楼层循环
        for (int floor = 1; floor <= buildingLast.getBuildingFloor(); floor++) {
//            每层房数循环
            for (int roomSum = 1; roomSum <= buildingLast.getBuildingRoomSum(); roomSum++) {
//                新建房间room
                Room room = new Room();
//                楼id
                room.setBuildingId(buildingLast.getBuildingId());
//                房名
                roomName = buildingLast.getBuildingName() + "-";
                if (roomSum <= 9) {
                    roomName += floor + "0" + roomSum;
                } else {
                    roomName += floor + "" + roomSum;
                }
                room.setRoomName(roomName);
//                System.out.println("roomName: " + roomName);
//                存入roomList这个list中
                roomList.add(room);
            }
        }
        return this.roomDao.insertRooms(roomList);
    }


    /**～～～～～～～～～～～～～～～～～～～～～～～～～～～～·*/

    /**
     * 通过ID查询单条数据
     *
     * @param buildingId 主键
     * @return 实例对象
     */
    @Override
    public Building queryById(Integer buildingId) {
        return this.buildingDao.queryById(buildingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Building> queryAllByLimit(int offset, int limit) {
        return this.buildingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building insert(Building building) {
        this.buildingDao.insert(building);
        return building;
    }

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building update(Building building) {
        this.buildingDao.update(building);
        return this.queryById(building.getBuildingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildingId) {
        return this.buildingDao.deleteById(buildingId) > 0;
    }
}
