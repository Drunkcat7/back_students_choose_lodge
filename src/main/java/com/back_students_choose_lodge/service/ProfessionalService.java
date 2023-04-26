package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Professional)表服务接口
 *
 * @author makejava
 * @since 2023-04-26 10:36:27
 */
public interface ProfessionalService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    List<Professional> queryAll();

}
