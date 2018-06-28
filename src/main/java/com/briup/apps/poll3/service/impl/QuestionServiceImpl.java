package com.briup.apps.poll3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll3.bean.Options;
import com.briup.apps.poll3.bean.OptionsExample;
import com.briup.apps.poll3.bean.Question;
import com.briup.apps.poll3.bean.extend.QuestionVM;
import com.briup.apps.poll3.dao.OptionsMapper;
import com.briup.apps.poll3.dao.QuestionMapper;
import com.briup.apps.poll3.dao.extend.QuestionVMMapper;
import com.briup.apps.poll3.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionVMMapper qvmm;
	
	@Autowired 
	private OptionsMapper optionsmapper;
	@Autowired 
	private QuestionMapper questionmapper;

	@Override
	public List<QuestionVM> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return qvmm.selectAll();
	}
     
	
	
	//保存或修改问题
	//1、判断保存还是修改
	//2、判断是否是简答
	/*
	 * 分离questionVM  获取question options
	 * 保存
	 * 1.保存问题
	 * 2.保存选项
	 * 
	 * (non-Javadoc)
	 * @see com.briup.apps.poll3.service.IQuestionService#saveOrupdateQuestionVM(com.briup.apps.poll3.bean.Question)
	 */
	@Override
	public void saveOrupdateQuestionVM(QuestionVM questionVM) throws Exception {
		//1. 分离questionVM  获取question options
		List<Options> options=questionVM.getOptions();
		
		Question question=new Question();
		question.setId(questionVM.getId());
		
		question.setName(questionVM.getName());
		
		question.setQuestiontype(questionVM.getQuestionType());
		//2.判断保存还是修改
		if(question.getId()==null){
			//2.1保存
			if(question.getQuestiontype().equals("简答题")){
				//2.1.1保存简答题，保存题目相关信息
			   questionmapper.insert(question);
			}else{
				//2.1.2保存单选和多选，先保存题目在保存选项
			       questionmapper.insert(question);
			       
			       //System.out.println("============="+question.getId());
			       long questionId=question.getId();
			       if(options!=null){
			    	   for(Options option : options){
				    	   //为每个选项设置question_id
				    	   option.setQuestionId(questionId);
				    	   
				    	   //保存选项
				    	   optionsmapper.insert(option);
				       }
			       }
			       
			}
		}else{
			//2.2修改
			//2.2.1修改题目信息
			questionmapper.updateByPrimaryKey(question);
			//2.2.2修改选项信息、添加删除修改
			/*1.删除题目原有选项
			 *
			 */
			
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsmapper.deleteByExample(example);
			// 2.重新添加选项
			 long questionId=question.getId();
		       for(Options option : options){
		    	   //为每个选项设置question_id
		    	   option.setQuestionId(questionId);
		    	   
		    	   //保存选项
		    	   optionsmapper.insert(option);
		       }
			
		}
	}



	@Override
	public void deleteQuestionById( long id) throws Exception {
		// TODO Auto-generated method stub
		 questionmapper.deleteByPrimaryKey(id);
	}
	
}
			
		
	




	


	
	


