package com.briup.apps.poll3.dao.extend;

import java.util.List;

import com.briup.apps.poll3.bean.extend.QuestionVM;

public interface QuestionVMMapper {
	List<QuestionVM> selectAll();
	void saveOrupdateQuestionVM(QuestionVM questionVM);
	
	void deleteQuestionById(long id);
	
	List<QuestionVM> selectByQuestionnaireId();

}
