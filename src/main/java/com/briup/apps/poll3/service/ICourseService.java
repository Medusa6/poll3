package com.briup.apps.poll3.service;

import java.util.List;

import com.briup.apps.poll3.bean.Course;

public interface ICourseService {
	List<Course> findAllCourse() throws Exception;
	
	Course findById(long id) throws Exception;
	
	List<Course> query(String keywords) throws Exception;
	
	void saveOrupdate(Course course) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(List<Long> ids) throws Exception;

}