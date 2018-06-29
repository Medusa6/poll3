package com.briup.apps.poll3.service;

import java.util.List;

import com.briup.apps.poll3.bean.Questionnaire;
import com.briup.apps.poll3.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {
	List<Questionnaire> findAll() throws Exception;
	
	QuestionnaireVM findById(long id) throws Exception;
	
	void saveOrupdateQuestonnaire(Questionnaire questionnaire, long[] questionIds) throws Exception;
	
	void deleteById(long id)throws Exception;

}
