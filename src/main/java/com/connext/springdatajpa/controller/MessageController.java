package com.connext.springdatajpa.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.connext.springdatajpa.annotation.AopAnnotation;
import com.connext.springdatajpa.model.Article;
import com.connext.springdatajpa.model.User;
import com.connext.springdatajpa.service.MessageService;
import com.connext.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("messagecontroller")
public class MessageController {
    @Resource
    private MessageService messageservice;
    @Resource
    private UserService userService;

    @Value("${image.store-path}")
    private String imagePath;

    @RequestMapping("tomessageadd")
    public String toMessageAdd() {
        return "message_add";
    }


    @RequestMapping("/querymessage")
    public String querymessage(Model model, HttpSession session) {
        model.addAttribute("messagelist", this.messageservice.queryMessageByUserId(((User) session.getAttribute("loginUserInfo")).getId()));
        return "message_list";
    }

    @RequestMapping("deleteone")
    @AopAnnotation(value = "用户删除消息")
    public String deleteone(Integer messageid) {
        this.messageservice.deleteone(messageid);
        return "redirect:querymessage";
    }

    @RequestMapping("see")
    public String see(Integer messageid, Model model) {
        model.addAttribute("messagedetail", this.messageservice.editone(messageid));
        return "message_detail";
    }

    @RequestMapping("indeleteone")
    public String indeleteone(Integer messageid) {
        this.messageservice.deleteone(messageid);
        return "redirect:querymessage";
    }

    @RequestMapping("preupdate")
    public String preupdate(Integer messageid, Model model) {
        model.addAttribute("messagedetail", this.messageservice.editone(messageid));
        return "message_update";
    }

    @RequestMapping("update")
    @AopAnnotation(value = "用户修改消息")
    public String updatemessage(Article article,String date,HttpSession session) {
        article.setUser(((User) session.getAttribute("loginUserInfo")));
        this.messageservice.updatemessage(article);
        return "redirect:querymessage";
    }


    @RequestMapping(value = "/addmessage")
    public String addmessage(Article article, HttpSession session){
        article.setUser(((User) session.getAttribute("loginUserInfo")));
        this.messageservice.addmessage(article);
        return "redirect:querymessage";
    }
}
