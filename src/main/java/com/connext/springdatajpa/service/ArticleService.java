package com.connext.springdatajpa.service;

import com.connext.springdatajpa.model.Article;

import java.util.List;

public interface ArticleService {
    //��ѯ���е����·����б���
    List<Article> queryAllArticle();
    //��ѯ���¾������ݣ��������µ�����
    Article queryOneArticleDetail(Integer articleId);

}
