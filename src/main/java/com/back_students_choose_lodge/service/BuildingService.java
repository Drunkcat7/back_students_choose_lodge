package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Building;

import java.util.List;

/**
 * (Building)表服务接口
 *
 * @author makejava
 * @since 2023-04-25 17:44:13
 */
public interface BuildingService {
    /**
     * 通过主键删除数据
     *
     * @param buildingId 宿舍楼名
     * @return 影响行数
     */
    boolean deleteByBuildingId(Integer buildingId);


    /**
     * 查询所有宿舍楼
     * @param
     * @return
     */
    List<Building> queryBuildingAll();

    /**
     * 修改宿舍楼性别
     * @param building
     * @return 修改后的实例对象
     */
    Building updateBuildingSex(Building building);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * 新建宿舍楼
     * @param building
     * @return 新增房间数
     */
    int newBuilding(Building building);

    /** ---------------------- */

    /**
     * 通过ID查询单条数据
     *
     * @param buildingId 主键
     * @return 实例对象
     */
    Building queryById(Integer buildingId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Building> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building insert(Building building);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buildingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildingId);

}
