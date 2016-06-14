package com.alibaba.webx.tutorial1.ibatis.service;

import java.util.Map;

import com.alibaba.webx.tutorial1.ibatis.dataobject.MapperInfo;

public interface ParseParamService {
	/**
	 * 根据传入的参数，解析出velocity中需要的变量参数
	 * @param mapperInfo
	 * @return
	 */
	Map<String,Object> parseVelocityParams(MapperInfo mapperInfo);
	
}
