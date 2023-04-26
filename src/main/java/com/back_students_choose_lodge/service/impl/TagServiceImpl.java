package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.entity.Tag;
import com.back_students_choose_lodge.dao.TagDao;
import com.back_students_choose_lodge.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-04-26 14:27:32
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    private TagDao tagDao;

    /**
     * 查询全部数据
     *
     * @return List实例对象
     */
    @Override
    public List<Tag> queryAll() {
        return this.tagDao.queryAll();
    }
}
