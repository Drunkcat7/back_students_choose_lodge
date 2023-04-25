package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Building)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-25 17:44:13
 */
public interface BuildingDao {
    /**
     * 通过主键删除数据
     *
     * @param buildingName 宿舍楼名
     * @return 影响行数
     */
    int deleteByBuildingName(String buildingName);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 影响行数
     */
    int insert(Building building);

    /**
     * 查询最新一条的的宿舍楼信息
     * @return 实例对象
     */
    Building queryLastInfo();

    /** ------------------------------- */

    /**
     * 通过ID查询单条数据
     *
     * @param buildingId 主键
     * @return 实例对象
     */
    Building queryById(Integer buildingId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Building> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param building 实例对象
     * @return 对象列表
     */
    List<Building> queryAll(Building building);



    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Building> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Building> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Building> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Building> entities);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 影响行数
     */
    int update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buildingId 主键
     * @return 影响行数
     */
    int deleteById(Integer buildingId);

}

