package com.briup.apps.poll3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll3.bean.extend.ClazzVM;
import com.briup.apps.poll3.dao.extend.ClazzVMMapper;
import com.briup.apps.poll3.service.IClazzService;

@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzVMMapper clazzvmmapper;

	@Override
	public List<ClazzVM> selectAll() throws Exception {
		// TODO Auto-generated method stub
		
		return clazzvmmapper.selectAll();
	}

}
