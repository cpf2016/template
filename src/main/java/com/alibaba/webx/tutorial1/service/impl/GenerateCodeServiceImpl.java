package com.alibaba.webx.tutorial1.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;
import com.alibaba.webx.tutorial1.service.VelocityService;

public class GenerateCodeServiceImpl implements GenerateCodeService {
	@Autowired
	private VelocityService velocityService;
	

	@Override
	public String createProxyClass(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.ProxyClass, params);
	}

	@Override
	public String createProxyCreator(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.ProxyCreator, params);
	}

	@Override
	public String createProxyExampler(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.ProxyExample, params);
	}

	@Override
	public String createDigest(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Digest, params);
	}

	@Override
	public String createJson(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Json, params);
	}

	@Override
	public String createDate(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Date, params);
	}

	@Override
	public String createJsInnerObject(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.InnerObject, params);
	}

	@Override
	public String createJsDialog(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Dialog, params);
	}

	@Override
	public String createJsNewWindow(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.NewWindow, params);
	}

	@Override
	public String createJsTimer(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.Timer, params);
	}

}
