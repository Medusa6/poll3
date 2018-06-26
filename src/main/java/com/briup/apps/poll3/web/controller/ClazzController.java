package com.briup.apps.poll3.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll3.bean.extend.ClazzVM;
import com.briup.apps.poll3.service.IClazzService;
import com.briup.apps.poll3.util.MsgResponse;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@GetMapping("selectAll")
	public MsgResponse selectAll(){
		try {
			List<ClazzVM> list =clazzService.selectAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
