package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.UserSelectedRoom;
import com.back_students_choose_lodge.my_interceptor.CurrentUser;
import com.back_students_choose_lodge.my_interceptor.CurrentUserInfo;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.UserSelectedRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
     * 获取房间管理信息
     *
     * @return Map
     */
    @GetMapping("/roomManagementInfo")
    @Role(roles = {"admin"})
    public List<Map<String, Object>> roomManagementInfo() {
        return this.userSelectedRoomService.roomManagementInfo();
    }

    /**
     * 我的房间
     * @param user
     * @return
    w */
    @GetMapping("/myRoom")
    @Role(roles = {"user"})
    public Map<String, Object> myRoom(@CurrentUser CurrentUserInfo user) {
        return this.userSelectedRoomService.myRoom(user.getUid());
    }

    /**
     * 删除用户宿舍选择
     * @param uid
     * @return
     */
    @GetMapping("/deselectUserRoom")
    @Role(roles = {"admin"})
    public Boolean deselectUserRoom(Integer uid) {
        return this.userSelectedRoomService.deselectUserRoom(uid);
    }


    /**
     * 学生加入宿舍，选床
     * @param buildingId
     * @param roomId
     * @param bedNumber
     * @param user
     * @return
     */
    @PostMapping("/insertUserRoom")
    @Role(roles = {"user"})
    public Boolean insertUserRoom(Integer buildingId,Integer roomId,Integer bedNumber,@CurrentUser CurrentUserInfo user) {
        return this.userSelectedRoomService.insertUserRoom(buildingId,roomId,bedNumber,user.getUid());
    }
    /**~~~~~~~~~~~~~~~~~分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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
