package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Building;
import com.back_students_choose_lodge.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
