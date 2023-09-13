package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.AccountDao;
import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.entity.UserInfo;
import com.back_students_choose_lodge.dao.UserInfoDao;
import com.back_students_choose_lodge.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-04-25 22:35:33
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private AccountDao accountDao;

    /**
     * 查询所有用户信息
     *
     * @return List
     */
    @Override
    public List<UserInfo> queryAllUser() {
        return this.userInfoDao.queryAllUser();
    }

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    @Override
    public Boolean updateUser(UserInfo userInfo, Account account) {

        if (account.getLevel() == null || account.getLevel() != 1) {
            account.setLevel(0);
        }
        int i = this.userInfoDao.update(userInfo);
        int t = 0;
        if (!(account.getUser() == null && account.getPassword() == null)) {
            t = this.accountDao.update(account);
        }
        return i != 0 || t != 0;
    }

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @param account
     * @return
     */
    @Override
    public Boolean addUser(UserInfo userInfo, Account account) {
        int t = this.accountDao.insert(account);
        if (t != 0) {
            Account newUser = this.accountDao.getNewUser();
            userInfo.setUid(newUser.getUid());
        }
        int i = this.userInfoDao.insert(userInfo);
        return i != 0 && t != 0;
    }

    /**
     * 查询用户自己的信息
     *
     * @param uid
     * @return
     */
    @Override
    public UserInfo queryUserInfoByUid(Integer uid) {
        return this.userInfoDao.queryById(uid);
    }

    /**
     * 确认信息
     *
     * @param userInfoId
     * @return
     */
    @Override
    public int confirmUserInfo(Integer userInfoId) {
        return this.userInfoDao.confirmUserInfo(userInfoId);
    }

    /**
     * 修改个签
     *
     * @param uid
     * @param introduce
     * @return
     */
    @Override
    public Boolean updateIntroduce(Integer uid, String introduce) {
        return this.userInfoDao.updateIntroduce(uid, introduce) != 0;
    }


}
