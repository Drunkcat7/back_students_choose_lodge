package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.AccountDao;
import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.service.AccountService;
import com.back_students_choose_lodge.tools.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account insert(Account account) {
        this.accountDao.insert(account);
        return account;
    }

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 登录成功的用户
     */
    @Override
    public Map<String, Object> login(String user, String password) {
        Map<String, Object> map = new HashMap<>();
        Account loginUser = this.accountDao.login(user, password);
        if (loginUser == null) return null;
        map.put("uid", loginUser.getUid());
        map.put("user", loginUser.getUser());
        map.put("level", loginUser.getLevel());
        //登录成功生成token
        String token = JwtUtil.getJwtToken(loginUser.getUid(), loginUser.getUser(), loginUser.getLevel());
        map.put("token", token);
        return map;
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return Boole
     */
    @Override
    public Boolean deleteById(Integer uid) {
        return this.accountDao.deleteById(uid) != 0;
    }

    /**
     * 通过主键查询用户单条信息
     *
     * @param uid 主键
     * @return 影响行数
     */
    @Override
    public Account getUserById(Integer uid) {
        return this.accountDao.getUserById(uid);
    }

}
