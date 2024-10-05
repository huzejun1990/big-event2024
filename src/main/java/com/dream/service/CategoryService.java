package com.dream.service;

import com.dream.pojo.Category;

import java.util.List;

/**
 * @Auther: huzejun
 * @Date: 2024/10/4 19:01
 */
public interface CategoryService {
    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();
}
