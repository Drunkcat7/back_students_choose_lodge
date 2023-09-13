package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (UserInfo)表服务接口
 *
 * @author makejava
 * @since 2023-04-25 22:35:33
 */
public interface UserInfoService {

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
     * @return Boolean
     */
    Boolean updateUser(UserInfo userInfo, Account account);

    /**
     * 添加用户
     *
     * @param userInfo
     * @param account
     * @return
     */
    Map<String,Object> addUser(UserInfo userInfo, Account account);

    /**
     * 查询用户自己的信息
     *
     * @param uid
     * @return
     */
    UserInfo queryUserInfoByUid(Integer uid);

    int confirmUserInfo(Integer userInfoId);

    /**
     * 修改个性签名
     *
     * @param introduce
     * @return
     */
    Boolean updateIntroduce(Integer uid, String introduce);
}
