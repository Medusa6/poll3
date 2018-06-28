package com.briup.apps.poll3.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll3.bean.extend.QuestionVM;
import com.briup.apps.poll3.service.IQuestionService;
import com.briup.apps.poll3.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrupdateQuestion(QuestionVM questionVM){
		
		try {
			questionService.saveOrupdateQuestionVM(questionVM);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		 
	}
	
	@GetMapping("selectAll")
	public MsgResponse selectAll(){
		try {
			List<QuestionVM> list=questionService.selectAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation("删除选项及题目")
	@GetMapping("deleteQuestionOptions")
	public MsgResponse deleteQuestionOptions(@RequestParam long id){
		try {
			questionService.deleteQuestionById(id);;
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
