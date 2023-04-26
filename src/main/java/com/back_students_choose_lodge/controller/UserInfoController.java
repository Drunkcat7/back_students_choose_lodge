package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.entity.UserInfo;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/addUser")
    @Role(roles = {"admin"})
    public Boolean addUser(UserInfo userInfo, Account account) {
        return this.userInfoService.addUser(userInfo, account);
    }
}

