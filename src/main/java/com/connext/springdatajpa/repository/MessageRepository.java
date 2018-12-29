package com.connext.springdatajpa.repository;

import com.connext.springdatajpa.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Article,Integer> {
    Integer countById(Integer userId);

    List<Article> findAllByUser_IdOrderByDateDesc(Integer userId);

    Article findAllById(Integer id);
}
