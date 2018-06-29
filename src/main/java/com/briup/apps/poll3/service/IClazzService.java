package com.briup.apps.poll3.service;

import java.util.List;

import com.briup.apps.poll3.bean.Clazz;
import com.briup.apps.poll3.bean.extend.ClazzVM;

public interface IClazzService {
	List<ClazzVM> selectAll() throws Exception;
	
	
	void saveOrupdateClazz(Clazz clazz) throws Exception;

}
