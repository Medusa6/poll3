package com.briup.apps.poll3.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll3.bean.Questionnaire;
import com.briup.apps.poll3.bean.extend.QuestionnaireVM;
import com.briup.apps.poll3.service.IQuestionnaireService;
import com.briup.apps.poll3.util.MsgResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireService qnService;
	
	@GetMapping("deleteQustionnaireById")
	public MsgResponse deleteQustionnaireById(long id){
		try {
			qnService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="保存或修改问卷信息")
	@PostMapping("saveOrupdateQuestonnaire")
	public MsgResponse saveOrupdateQuestonnaire(Questionnaire questionnaire, long[] questionIds){
		try {
			qnService.saveOrupdateQuestonnaire(questionnaire, questionIds);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID查询问卷",notes="问卷下具有问题信息")
	@GetMapping("findQuestionnaireVMById")
	public MsgResponse findQuestionnaireVMById(long id){
		try {
			QuestionnaireVM qnVM = qnService.findById(id);
			// 返回成功信息
			return MsgResponse.success("success", qnVM);
		} catch (Exception e) {
			e.printStackTrace();
			// 返回失败信息
			return MsgResponse.error(e.getMessage()) ;
		}
	}
	
	@ApiOperation(value="查询所有问卷",notes="单表")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = qnService.findAll();
			// 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			// 返回失败信息
			return MsgResponse.error(e.getMessage()) ;
		}
}

}
