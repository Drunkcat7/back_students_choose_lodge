package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.UserSelectedRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (UserSelectedRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-26 23:22:33
 */
public interface UserSelectedRoomDao {

    /**
     * 获取已选房间中的uid
     * @param roomId
     * @return
     */
    List<Integer> queryByRoomId(Integer roomId);
    /*======================分界线======================*/
    /**
     * 通过ID查询单条数据
     *
     * @param userSelectedRoom 主键
     * @return 实例对象
     */
    UserSelectedRoom queryById(Integer userSelectedRoom);

    /**
     * 查询指定行数据
     *
     * @param userSelectedRoom 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UserSelectedRoom> queryAllByLimit(UserSelectedRoom userSelectedRoom, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userSelectedRoom 查询条件
     * @return 总行数
     */
    long count(UserSelectedRoom userSelectedRoom);

    /**
     * 新增数据
     *
     * @param userSelectedRoom 实例对象
     * @return 影响行数
     */
    int insert(UserSelectedRoom userSelectedRoom);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelectedRoom> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
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
     * @param userSelectedRoom 主键
     * @return 影响行数
     */
    int deleteById(Integer userSelectedRoom);

}

