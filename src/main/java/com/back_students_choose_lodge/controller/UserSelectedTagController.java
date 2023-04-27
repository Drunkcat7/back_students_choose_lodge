package com.back_students_choose_lodge.controller;

import com.back_students_choose_lodge.entity.UserSelectedTag;
import com.back_students_choose_lodge.my_interceptor.CurrentUser;
import com.back_students_choose_lodge.my_interceptor.CurrentUserInfo;
import com.back_students_choose_lodge.my_interceptor.Role;
import com.back_students_choose_lodge.service.UserSelectedTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserSelectedTag)表控制层
 *
 * @author makejava
 * @since 2023-04-26 17:10:32
 */
@RestController
@RequestMapping("userSelectedTag")
public class UserSelectedTagController {
    /**
     * 服务对象
     */
    @Resource
    private UserSelectedTagService userSelectedTagService;

    /**
     * 新增标签
     *
     * @return 新增的数量
     */
    @PostMapping("/addTag")
    @Role(roles = {"user"})
    public ResponseEntity<Integer> addTag(Integer[] tagIds, @CurrentUser CurrentUserInfo user) {
        return ResponseEntity.ok(this.userSelectedTagService.insert(tagIds, user.getUid()));
    }

    /**
     * 修改标签
     * @param tagIds
     * @param user
     * @return
     */
    @PostMapping("/updateTag")
    @Role(roles = {"user"})
    public ResponseEntity<Integer> updateTag(Integer[] tagIds, @CurrentUser CurrentUserInfo user) {
        return ResponseEntity.ok(this.userSelectedTagService.updateTag(tagIds, user.getUid()));
    }

    /**
     * 更改选择标签
     * @param userInfo
     * @return
     */
    @GetMapping("/isUpdateSelectedTags")
    @Role(roles = {"user"})
    public Boolean isUpdateSelectedTags(@CurrentUser CurrentUserInfo userInfo) {
        long count = this.userSelectedTagService.count(userInfo.getUid());
        return count != 0;
    }

    /**
     * 更改选择标签
     * @param userInfo
     * @return
     */
    @GetMapping("/queryUserTag")
    @Role(roles = {"user"})
    public List<String> queryUserTag(@CurrentUser CurrentUserInfo userInfo) {
        return this.userSelectedTagService.queryTag(userInfo.getUid());
    }
}

