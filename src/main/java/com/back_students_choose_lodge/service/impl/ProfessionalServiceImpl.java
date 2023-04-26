package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.entity.Professional;
import com.back_students_choose_lodge.dao.ProfessionalDao;
import com.back_students_choose_lodge.service.ProfessionalService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Professional)表服务实现类
 *
 * @author makejava
 * @since 2023-04-26 10:36:27
 */
@Service("professionalService")
public class ProfessionalServiceImpl implements ProfessionalService {
    @Resource
    private ProfessionalDao professionalDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public List<Professional> queryAll() {
        return this.professionalDao.queryAll();
    }
}
