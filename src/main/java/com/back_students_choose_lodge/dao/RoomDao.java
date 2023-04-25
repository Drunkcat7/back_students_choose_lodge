package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Room)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-25 23:05:38
 */
public interface RoomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roomId 主键
     * @return 实例对象
     */
    Room queryById(Integer roomId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Room> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param room 实例对象
     * @return 对象列表
     */
    List<Room> queryAll(Room room);

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 影响行数
     */
    int insert(Room room);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Room> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Room> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Room> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Room> entities);

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 影响行数
     */
    int update(Room room);

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 影响行数
     */
    int deleteById(Integer roomId);

}

