package com.briup.apps.poll3.service;

import java.util.List;

import com.briup.apps.poll3.bean.Question;

public interface IQuestionService {
	List<Question> findAll() throws Exception; 

}
