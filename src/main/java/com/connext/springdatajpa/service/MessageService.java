package com.connext.springdatajpa.service;


import com.connext.springdatajpa.model.Article;

import java.util.List;

public interface MessageService {
    //���ݵ�¼���ֻ��Ž��в�ѯ������ص���Ϣ
	public List<Article> queryMessageByUserId(Integer userId);
	
	//ɾ��ĳһ����Ϣ 
	public void deleteone(Integer messageid);
	
	//�༭ĳһ����Ϣ
	public Article editone(Integer messageid);
	
	//�޸�ĳһ����¼
	public void updatemessage(Article article);
	
	//������Ϣ
	public void addmessage(Article article);
}
