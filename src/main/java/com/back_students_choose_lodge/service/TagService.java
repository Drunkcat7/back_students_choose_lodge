package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author makejava
 * @since 2023-04-26 14:27:32
 */
public interface TagService {

    /**
     * 查询全部数据
     *
     * @return List实例对象
     */
    List<Tag> queryAll();

}
