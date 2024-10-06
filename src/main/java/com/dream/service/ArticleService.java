package com.dream.service;

import com.dream.pojo.Article;
import com.dream.pojo.PageBean;

/**
 * @Auther: huzejun
 * @Date: 2024/10/6 01:16
 */
public interface ArticleService {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
