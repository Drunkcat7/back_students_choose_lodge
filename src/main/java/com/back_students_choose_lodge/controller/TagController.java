package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.Tag;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)表控制层
 *
 * @author makejava
 * @since 2023-04-26 14:27:31
 */
@RestController
@RequestMapping("tag")
public class TagController {
    /**
     * 服务对象
     */
    @Resource
    private TagService tagService;

    /**
     * 获取爱好选择表
     *
     * @return List
     */
    @GetMapping("/tagAll")
    @Role(roles = {"user"})
    public ResponseEntity<List<Tag>> queryAll() {
        return ResponseEntity.ok(this.tagService.queryAll());
    }
}

