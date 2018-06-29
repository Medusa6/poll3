package com.briup.apps.poll3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll3.bean.Questionnaire;
import com.briup.apps.poll3.bean.QuestionnaireExample;
import com.briup.apps.poll3.bean.QuestionnaireQuestion;
import com.briup.apps.poll3.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll3.bean.extend.QuestionnaireVM;
import com.briup.apps.poll3.dao.QuestionnaireMapper;
import com.briup.apps.poll3.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll3.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll3.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper qnMapper;
	@Autowired
	private QuestionnaireVMMapper qnVMMapper;
	@Autowired
	private QuestionnaireQuestionMapper qqMapper;
	
	
	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		return qnMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public QuestionnaireVM findById(long id) throws Exception {
		return qnVMMapper.selectById(id);
	}

	@Override
	public void saveOrupdateQuestonnaire(Questionnaire questionnaire, long[] questionIds) throws Exception {
		// TODO Auto-generated method stub
		//判断是保存还是更新
		
		if(questionnaire.getId()==null){
			
			/*
			 * 1.1保存
			 * 1.1.1保存问卷信息
			 */
			qnMapper.insert(questionnaire);
			
			long questionnaireId=questionnaire.getId();
			
			// 1.1.2维护问卷和问题的关系 qq
			for(long questionId : questionIds){
				QuestionnaireQuestion qq= new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
			
		}else{
			//1.2修改
			//1.2.1修好问卷信息
			qnMapper.updateByPrimaryKeySelective(questionnaire);
			long questionnaireId=questionnaire.getId();
			//1.2.2删除问卷下所有关系
			QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
			example.createCriteria().andQuestionIdEqualTo(questionnaireId);
			qqMapper.deleteByExample(example);
			//1.2.3保存新的问卷问题关系
			for(long questionId : questionIds){
				QuestionnaireQuestion qq= new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
			
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		qnMapper.deleteByPrimaryKey(id);
	}

}