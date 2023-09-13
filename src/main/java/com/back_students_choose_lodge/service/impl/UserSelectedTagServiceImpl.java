package com.back_students_choose_lodge.service.impl;

import com.back_students_choose_lodge.dao.UserInfoDao;
import com.back_students_choose_lodge.entity.UserSelectedTag;
import com.back_students_choose_lodge.dao.UserSelectedTagDao;
import com.back_students_choose_lodge.service.UserSelectedTagService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (UserSelectedTag)表服务实现类
 *
 * @author makejava
 * @since 2023-04-26 17:10:33
 */
@Service("userSelectedTagService")
public class UserSelectedTagServiceImpl implements UserSelectedTagService {
    @Resource
    private UserSelectedTagDao userSelectedTagDao;
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 新增
     *
     * @return
     */
    @Override
    public int insert(Integer[] tagIds, Integer uid) {
        int num = 0;
        for (Integer tagId : tagIds) {
            UserSelectedTag userSelectedTag = new UserSelectedTag();
            userSelectedTag.setTagId(tagId);
            userSelectedTag.setUid(uid);
            num += this.userSelectedTagDao.insert(userSelectedTag);
        }
        userInfoDao.confirmIsUpdateTag(uid);
        return num;
    }

    /**
     * 统计总行数
     *
     * @param uid 查询条件
     * @return 总行数
     */
    @Override
    public long count(Integer uid) {
        return this.userSelectedTagDao.count(uid);
    }

    /**
     * 修改标签
     *
     * @return
     */
    @Override
    public int updateTag(Integer[] tagIds, Integer uid) {
        int num = 0;
        List<Integer> listA = this.userSelectedTagDao.queryTagId(uid);
        List<Integer> listB = Arrays.asList(tagIds);
        List<Integer> difference = new ArrayList<>(listA);
        difference.removeAll(listB);
        List<Integer> insertList = new ArrayList<>(listB);
        insertList.removeAll(listA);
        for (Integer integer : difference) {//删除
            num += this.userSelectedTagDao.deleteByUidAndTagId(integer, uid);
        }
        for (Integer integer : insertList) {//新增
            UserSelectedTag userSelectedTag = new UserSelectedTag();
            userSelectedTag.setTagId(integer);
            userSelectedTag.setUid(uid);
            num += this.userSelectedTagDao.insert(userSelectedTag);
        }
        userInfoDao.confirmIsUpdateTag(uid);
        return num;
    }

    //是否可以修改tag(0可以修改，1不可以修改)
    @Override
    public Boolean isUpdateSelectedTags(Integer uid) {
        return userInfoDao.queryById(uid).getIsUpdateTag() != 1;
    }

    /**
     * 获取用户的所有标签
     * @param uid
     * @return
     */
    @Override
    public List<String> queryTag(Integer uid) {
        return this.userSelectedTagDao.queryTag(uid);
    }

}
