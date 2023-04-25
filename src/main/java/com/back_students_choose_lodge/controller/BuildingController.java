package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Building;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Building)表控制层
 *
 * @author makejava
 * @since 2023-04-25 17:44:13
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingService buildingService;

    /**
     * 新建宿舍楼
     *
     * @param buildingName,buildingFloor,buildingRoomSum,sex
     * @return 新增房间数
     */
    @PostMapping("/newBuilding")
    @Role(roles = {"admin"})//管理员
    public int newBuilding(String buildingName, int buildingFloor, int buildingRoomSum, String sex) {
        /**
         * 楼名   buildingName
         * 楼层   buildingFloor
         * 每层房数 buildingRoomSum
         * 性别   sex
         */
        Building building = new Building();
        building.setBuildingName(buildingName);
        building.setBuildingFloor(buildingFloor);
        building.setBuildingRoomSum(buildingRoomSum);
        building.setSex(sex);
        return this.buildingService.newBuilding(building);
    }

    /**
     * 通过宿舍楼名删除数据
     *
     * @param buildingName 宿舍楼名
     * @return 是否成功
     */
    @PostMapping("/deleteBuilding")
    @Role(roles = {"admin"})//管理员
    public boolean deleteBuilding(String buildingName) {
        return this.buildingService.deleteByBuildingName(buildingName);
    }

    /**
     * 查询所有宿舍楼
     *
     * @param
     * @return 对象列表
     */
    @GetMapping("/queryBuildingAll")
    @Role(roles = {"admin"})//管理员
    public List<Building> queryBuildingAll() {
        return this.buildingService.queryBuildingAll();
    }

    /**~~~~~~~~~~~~~~~~~分界线~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Building selectOne(Integer id) {
        return this.buildingService.queryById(id);
    }


}
