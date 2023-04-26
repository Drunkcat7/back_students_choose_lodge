package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Room;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.RoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Room)表控制层
 *
 * @author makejava
 * @since 2023-04-25 23:05:39
 */
@RestController
@RequestMapping("room")
public class RoomController {
    /**
     * 服务对象
     */
    @Resource
    private RoomService roomService;


    /**
     * 通过实体作为筛选条件查询
     *
     * @param buildingId 宿舍楼号
     * @return 对象列表
     */
    @GetMapping("/queryAllRoom")
    @Role(roles = {"admin"})//管理员
    public List<Room> queryAllRoom(Integer buildingId) {
        return this.roomService.queryAllRoom(buildingId);
    }


    /**
     * 修改房间专业
     * @param professional
     * @param roomId 房间id列表
     * @return 影响行数
     */
    @PutMapping("/updateProfessional")
    @Role(roles = {"admin"})//管理员
    public Integer updateProfessional(String professional, Integer[] roomId) {
        System.out.println("有多少个 "+roomId.length);
        for(int i = 0; i < roomId.length; i++){
            System.out.println(roomId[i]);
        }
        return this.roomService.updateProfessionalByRoomId(professional,roomId);
    }



    /** ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～· */

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Room selectOne(Integer id) {
        return this.roomService.queryById(id);
    }

}
