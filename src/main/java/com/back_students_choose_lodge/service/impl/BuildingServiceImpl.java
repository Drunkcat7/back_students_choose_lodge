package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.entity.Building;
import com.back_students_choose_lodge.dao.BuildingDao;
import com.back_students_choose_lodge.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 新建宿舍楼
     * @param building
     * @return 是否成功
     */
    /**
     * 楼id  buildingId
     * 楼名   buildingName
     * 楼层   buildingFloor
     * 每层房数 buildingRoomSum
     * 性别   sex
     */
    @Override
    public boolean newBuilding(Building building) {
//        1. 新增宿舍楼
        int status = this.buildingDao.insert(building);
//        2. 宿舍楼 中建 房间
//        外层循环(楼层)，里层循环(每层房数)，房间名字(楼名-101)
        return status == 1 ? true : false;
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
