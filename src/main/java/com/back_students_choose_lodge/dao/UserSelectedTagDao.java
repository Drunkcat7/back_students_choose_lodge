package com.back_students_choose_lodge.dao;

import com.back_students_choose_lodge.entity.UserSelectedTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (UserSelectedTag)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-26 17:10:32
 */
public interface UserSelectedTagDao {


    /**
     * 新增数据
     *
     * @param userSelectedTag 实例对象
     * @return 影响行数
     */
    int insert(UserSelectedTag userSelectedTag);

    /**
     * 统计总行数
     *
     * @param uid 查询条件
     * @return 总行数
     */
    long count(Integer uid);

    /**
     * 查询所有的key
     *
     * @param uid
     * @return
     */
    List<Integer> queryTagId(Integer uid);


    /**
     * 通过tag_id和uid删除
     *
     * @return 影响行数
     */
    int deleteByUidAndTagId(@Param("tagId") Integer tagId, @Param("uid") Integer uid);

    /**
     * 获取用户的所有标签
     * @param uid
     * @return
     */
    List<String> queryTag(Integer uid);
    /*====================line=================================*/

    /**
     * 通过ID查询单条数据
     *
     * @param userSelectedTagId 主键
     * @return 实例对象
     */
    UserSelectedTag queryById(Integer userSelectedTagId);

    /**
     * 查询指定行数据
     *
     * @param userSelectedTag 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<UserSelectedTag> queryAllByLimit(UserSelectedTag userSelectedTag, @Param("pageable") Pageable pageable);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserSelectedTag> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserSelectedTag> entities);

    /**
     * 修改数据
     *
     * @param userSelectedTag 实例对象
     * @return 影响行数
     */
    int update(UserSelectedTag userSelectedTag);


}

