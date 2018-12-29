package com.connext.springdatajpa.service.serviceimp;


import com.connext.springdatajpa.repository.MessageRepository;
import com.connext.springdatajpa.model.Article;
import com.connext.springdatajpa.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public List<Article> queryMessageByUserId(Integer userId) {
		return this.messageRepository.findAllByUser_IdOrderByDateDesc(userId);
	}

	public void deleteone(Integer messageid) {
        this.messageRepository.deleteById(messageid);
	}

	public Article editone(Integer messageid) {
		return this.messageRepository.findAllById(messageid);
	}

	public void updatemessage(Article article) {
		System.out.println(article);
		this.messageRepository.save(article);
	}

	public void addmessage(Article article) {
		this.messageRepository.save(article);
		
	}

}
