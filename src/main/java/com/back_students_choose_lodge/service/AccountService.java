package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Account;

import java.util.Map;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
public interface AccountService {


    /**
     * 新增数据==>用户注册
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);

    /**
     * 用户登录
     * @param user
     * @param password
     * @return 登录的对象
     */
    Map<String,Object> login(String user, String password);

}
