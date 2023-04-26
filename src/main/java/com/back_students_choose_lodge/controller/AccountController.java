package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Account;
import com.back_students_choose_lodge.my_interceptor.CurrentUser;
import com.back_students_choose_lodge.my_interceptor.CurrentUserInfo;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.AccountService;
import com.back_students_choose_lodge.tools.GetStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
@RestController
@RequestMapping("account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 用户注册
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping("/reg")
    public ResponseEntity<Account> registeredAdd(Account account) {
        return ResponseEntity.ok(this.accountService.insert(account));
    }

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 用户信息与token
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(String user, String password) {
        return ResponseEntity.ok(GetStatus.get(this.accountService.login(user, password)));
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @GetMapping("/delUser")
    @Role(roles = {"admin"})
    public Boolean delUser(Integer uid) {
        return this.accountService.deleteById(uid);
    }

    /**
     * 查询用户单条信息
     * @param uid
     * @return
     */
    @GetMapping("/getUserById")
    @Role(roles = {"admin"})
    public Account getUserById(Integer uid) {
        return this.accountService.getUserById(uid);
    }



    @GetMapping("/userInfo")
    @Role(roles = {"user"})//普通用户
    public Map<String, Object> userInfo(@CurrentUser CurrentUserInfo currentUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", currentUser);
        return map;
    }

    @GetMapping("/admin")
    @Role(roles = {"admin"})//管理员
    public Map<String, Object> userAdmin(@CurrentUser CurrentUserInfo currentUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", currentUser);
        map.put("msg", "ADMIN");
        return map;
    }
}

