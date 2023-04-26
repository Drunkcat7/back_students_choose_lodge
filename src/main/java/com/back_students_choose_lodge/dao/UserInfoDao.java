package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-25 22:35:32
 */
public interface UserInfoDao {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserInfo> queryAllUser();

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int update(UserInfo userInfo);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int insert(UserInfo userInfo);

    /**
     * 通过ID查询单条数据
     *
     * @param uid 用户id
     * @return 实例对象
     */
    UserInfo queryById(Integer uid);


    int confirmUserInfo(Integer userInfoId);

    /**
     * 修改个性签名
     *
     * @param introduce
     * @return
     */
    int updateIntroduce(@Param("uid") Integer uid, @Param("introduce") String introduce);

    /**
     * 已经确认标签
     * @param uid
     * @return
     */
    int confirmIsUpdateTag(@Param("uid") Integer uid);
    /*=============================================================分界线=============================================================*/


    /**
     * 查询指定行数据
     *
     * @param userInfo 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<UserInfo> queryAllByLimit(UserInfo userInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userInfo 查询条件
     * @return 总行数
     */
    long count(UserInfo userInfo);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserInfo> entities);


    /**
     * 通过主键删除数据
     *
     * @param userInfoId 主键
     * @return 影响行数
     */
    int deleteById(Integer userInfoId);
}

