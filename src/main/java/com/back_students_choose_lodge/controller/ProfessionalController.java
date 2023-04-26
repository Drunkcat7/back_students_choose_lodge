package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Professional;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.ProfessionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Professional)表控制层
 *
 * @author makejava
 * @since 2023-04-26 10:36:27
 */
@RestController
@RequestMapping("professional")
public class ProfessionalController {
    /**
     * 服务对象
     */
    @Resource
    private ProfessionalService professionalService;

    /**
     * 查询所有数据
     *
     * @return 全部的专业
     */
    @GetMapping("/addProfessional")
    @Role(roles = {"admin"})
    public ResponseEntity<List<Professional>> queryAll() {
        return ResponseEntity.ok(this.professionalService.queryAll());
    }
}

