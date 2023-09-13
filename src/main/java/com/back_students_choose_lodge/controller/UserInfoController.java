package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.entity.UserInfo;
import com.back_students_choose_lodge.my_interceptor.CurrentUser;
import com.back_students_choose_lodge.my_interceptor.CurrentUserInfo;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (UserInfo)表控制层
 *
 * @author makejava
 * @since 2023-04-25 22:35:32
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;


    /**
     * 查询用户自己的信息
     *
     * @return
     */
    @GetMapping("/myUserInfo")
    @Role(roles = {"user"})
    public UserInfo queryUserInfoByUid(@CurrentUser CurrentUserInfo user) {
        return this.userInfoService.queryUserInfoByUid(user.getUid());
    }

    /**
     * 查询所有用户信息
     *
     * @return List
     */
    @GetMapping("/allUser")
    @Role(roles = {"admin"})
    public List<UserInfo> allUser() {
        return this.userInfoService.queryAllUser();
    }

    /**
     * 修改学生信息
     *
     * @param userInfo
     * @param account
     * @return
     */
    @PostMapping("/updateUser")
    @Role(roles = {"admin"})
    public Boolean updateUserInfo(UserInfo userInfo, Account account) {
        return this.userInfoService.updateUser(userInfo, account);
    }

    /**
     * 新增学生信息
     *
     * @param userInfo
     * @param account
     * @return
     */
    @PostMapping("/addUser")
    @Role(roles = {"admin"})
    public Map<String, Object> addUser(UserInfo userInfo, Account account) {
        return this.userInfoService.addUser(userInfo, account);
    }

    /**
     * 确认用户信息
     *
     * @param userInfoId
     * @return
     */
    @GetMapping("/confirmUserInfo")
    @Role(roles = {"user"})
    public Boolean confirmUserInfo(Integer userInfoId) {
        int i = this.userInfoService.confirmUserInfo(userInfoId);
        return i != 0;
    }

    /**
     * 修改个性签名
     *
     * @param introduce
     * @param user
     * @return
     */
    @PutMapping("/updateIntroduce")
    @Role(roles = {"user"})
    public Boolean updateIntroduce(String introduce, @CurrentUser CurrentUserInfo user) {
        return this.userInfoService.updateIntroduce(user.getUid(), introduce);
    }

    /**
     * 检查用户是否确认过标签
     * @param user token解析的用户信息
     * @return boolean
     */
    @GetMapping("/checkUserTag")
    @Role(roles = {"user"})
    public Boolean checkUserTag(@CurrentUser CurrentUserInfo user) {
        return this.userInfoService.queryUserInfoByUid(user.getUid()).getIsUpdateTag() == 1;
    }
}

