package com.alibaba.webx.tutorial1.css.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.css.service.GenerateCssService;
import com.alibaba.webx.tutorial1.service.VelocityService;

public class GenerateCssServiceImpl implements GenerateCssService {
	@Autowired
	private VelocityService velocityService;

	@Override
	public String createFontCss(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.FontCss, params);
	}

	@Override
	public String createTextCss(Map<String, Object> params) {
		return velocityService.getVmContent(VmTypeEnum.TextCss, params);
	}

}
