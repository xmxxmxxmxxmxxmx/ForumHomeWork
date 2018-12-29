package com.connext.springdatajpa.controller;


import com.connext.springdatajpa.service.ArticleService;
import com.connext.springdatajpa.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/articleController")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;

    //进入文章乐园
    @RequestMapping("/toArticlePark")
    public String toArticlePark(Model model){
        model.addAttribute("article",this.articleService.queryAllArticle());
        return "article_park";
    }

    //从文章乐园进入文章详细界面
    @RequestMapping("/articleDetail")
    public String articleDetail(String articleId, Model model, HttpSession session){
        session.setAttribute("articleId",articleId);
        model.addAttribute("comment",this.commentService.queryCommentByArticleId(Integer.parseInt(articleId)));
        model.addAttribute("article",this.articleService.queryOneArticleDetail(Integer.parseInt(articleId)));
        return "article_detail";
    }


}
