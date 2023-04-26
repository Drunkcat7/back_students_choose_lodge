package com.back_students_choose_lodge.service;

import com.back_students_choose_lodge.entity.UserSelectedTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (UserSelectedTag)表服务接口
 *
 * @author makejava
 * @since 2023-04-26 17:10:32
 */
public interface UserSelectedTagService {

    /**
     * 新增
     *
     * @return
     */
    int insert(Integer[] tagIds, Integer uid);

    /**
     * 统计总行数
     *
     * @param uid 查询条件
     * @return 总行数
     */
    long count(Integer uid);

    /**
     * 修改
     *
     * @return
     */
    int updateTag(Integer[] tagIds, Integer uid);
}
