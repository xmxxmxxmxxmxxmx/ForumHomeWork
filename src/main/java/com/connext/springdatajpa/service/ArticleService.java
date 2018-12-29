package com.connext.springdatajpa.service;

import com.connext.springdatajpa.model.Article;

import java.util.List;

public interface ArticleService {
    //查询所有的文章放在列表上
    List<Article> queryAllArticle();
    //查询文章具体内容，包括文章的评论
    Article queryOneArticleDetail(Integer articleId);

}
