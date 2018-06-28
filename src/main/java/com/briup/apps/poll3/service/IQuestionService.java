package com.briup.apps.poll3.service;

import java.util.List;

import com.briup.apps.poll3.bean.extend.QuestionVM;



public interface IQuestionService {
	List<QuestionVM> selectAll() throws Exception; 
	
	void saveOrupdateQuestionVM(QuestionVM questionVM) throws Exception; 
	
	void deleteQuestionById(long id) throws Exception; 

}
