package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.UserSelectedRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserSelectedRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 02:39:43
 */
public interface UserSelectedRoomDao {
    /**
     * 通过实体作为筛选条件查询
     *
     * @param userSelectedRoom 实例对象
     * @return 对象列表
     */
    List<UserSelectedRoom> queryAll(UserSelectedRoom userSelectedRoom);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

    /**
     * 通过ID查询单条数据
     *
     * @param userSelectedRoomId 主键
     * @return 实例对象
     */
    UserSelectedRoom queryById(Integer userSelectedRoomId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserSelectedRoom> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);




    /**
     * 新增数据
     *
     * @param userSelectedRoom 实例对象
     * @return 影响行数
     */
    int insert(UserSelectedRoom userSelectedRoom);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelectedRoom> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserSelectedRoom> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelectedRoom> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserSelectedRoom> entities);

    /**
     * 修改数据
     *
     * @param userSelectedRoom 实例对象
     * @return 影响行数
     */
    int update(UserSelectedRoom userSelectedRoom);

    /**
     * 通过主键删除数据
     *
     * @param userSelectedRoomId 主键
     * @return 影响行数
     */
    int deleteById(Integer userSelectedRoomId);

}

