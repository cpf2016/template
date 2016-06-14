package com.alibaba.webx.tutorial1.spring.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.service.VelocityService;
import com.alibaba.webx.tutorial1.spring.service.GenerateSpringService;

public class GenerateSpringServiceImpl implements GenerateSpringService {
	@Autowired
	private VelocityService velocityService;
	
	@Override
	public String createTx(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Tx, params);
	}

	@Override
	public String createAopConfig(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.AopConfig, params);
	}

	@Override
	public String createAopAdvice(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.AopAdvice, params);
	}

}
