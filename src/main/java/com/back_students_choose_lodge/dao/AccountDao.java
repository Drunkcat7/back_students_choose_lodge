package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
public interface AccountDao {

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return
     */
    Account login(@Param("user") String user, @Param("password") String password);


    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

    /**
     * 通过主键查询用户单条信息
     *
     * @param uid 主键
     * @return 影响行数
     */
    Account getUserById(Integer uid);

    /**
     * 修改
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 获取最新用户信息
     * @return
     */
    Account getNewUser();

}

