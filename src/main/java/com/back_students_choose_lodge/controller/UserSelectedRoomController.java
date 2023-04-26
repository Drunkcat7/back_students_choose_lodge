package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.UserSelectedRoom;
import com.back_students_choose_lodge.service.UserSelectedRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserSelectedRoom)表控制层
 *
 * @author makejava
 * @since 2023-04-27 02:39:43
 */
@RestController
@RequestMapping("userSelectedRoom")
public class UserSelectedRoomController {
    /**
     * 服务对象
     */
    @Resource
    private UserSelectedRoomService userSelectedRoomService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserSelectedRoom selectOne(Integer id) {
        return this.userSelectedRoomService.queryById(id);
    }

}
