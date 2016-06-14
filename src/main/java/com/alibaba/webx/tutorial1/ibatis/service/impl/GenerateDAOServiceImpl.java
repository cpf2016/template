package com.alibaba.webx.tutorial1.ibatis.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.ibatis.service.GenerateDAOService;
import com.alibaba.webx.tutorial1.service.VelocityService;

public class GenerateDAOServiceImpl implements GenerateDAOService {
	@Autowired
	private VelocityService velocityService;
	
	public String createDAOInterface(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.DAOInterface, params);
	}
	
	public String createDAOXml(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.DAOXmlMapper, params);
	}

	/**
	 * <p>创建DAOImpl文件，如果其中需要生成insertBatch，</p>
	 * <p>那么就一起把serviceImpl中的切分操作也一起生成</p>
	 */
	public String createDAOImpl(Map<String, Object> params) {
		if(containsInsertBatch(params)){
			velocityService.getVmContent(VmTypeEnum.ServiceImpl, params);
		}
		return velocityService.getVmContent(VmTypeEnum.DAOImpl, params);
	}


	private boolean containsInsertBatch(Map<String, Object> params) {
		return params.get("insertBatch")!=null;
	}
}
