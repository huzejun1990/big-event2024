package com.dream.service;

import com.dream.pojo.User;

/**
 * @Auther: huzejun
 * @Date: 2024/9/30 14:28
 */
public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);

    //注册新用户
    void register(String username, String password);

    //更新
    void update(User user);

    //更新图像
    void updateAvatar(String avatarUrl);
}
