package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.Professional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Professional)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-26 10:36:27
 */
public interface ProfessionalDao {

    /**
     * 查询全部数据
     *
     * @return 实例对象
     */
    List<Professional> queryAll();


    /*==================================================================分界限===============================================*/

    /**
     * 查询指定行数据
     *
     * @param professional 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Professional> queryAllByLimit(Professional professional, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param professional 查询条件
     * @return 总行数
     */
    long count(Professional professional);

    /**
     * 新增数据
     *
     * @param professional 实例对象
     * @return 影响行数
     */
    int insert(Professional professional);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Professional> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Professional> entities);

    /**
     * 修改数据
     *
     * @param professional 实例对象
     * @return 影响行数
     */
    int update(Professional professional);

    /**
     * 通过主键删除数据
     *
     * @param professionalId 主键
     * @return 影响行数
     */
    int deleteById(Integer professionalId);

}

