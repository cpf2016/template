package com.alibaba.webx.tutorial1.ibatis.service;

import java.util.Map;


public interface GenerateDAOService {
	public String createDAOInterface(Map<String, Object> params);
	
	public String createDAOXml(Map<String, Object> params);

	public String createDAOImpl(Map<String, Object> params);
}
