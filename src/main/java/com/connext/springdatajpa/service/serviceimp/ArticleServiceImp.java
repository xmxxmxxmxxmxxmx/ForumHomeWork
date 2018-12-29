package com.connext.springdatajpa.service.serviceimp;

import com.connext.springdatajpa.repository.ArticleRepository;
import com.connext.springdatajpa.model.Article;
import com.connext.springdatajpa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> queryAllArticle() {
        return this.articleRepository.findList();
    }
    @Override
    public Article queryOneArticleDetail(Integer articleId) {
        return articleRepository.getOne(articleId);
    }
}
