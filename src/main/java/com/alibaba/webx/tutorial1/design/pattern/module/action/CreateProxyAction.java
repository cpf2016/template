package com.alibaba.webx.tutorial1.design.pattern.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.design.pattern.dataobject.ProxyDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;

public class CreateProxyAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateProxyAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createProxy") ProxyDO proxyDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(proxyDO);
    	logger.info("create proxy params is {}", params);
    	
    	String classResult = generateCodeService.createProxyClass(params);
    	String creatorResult = generateCodeService.createProxyCreator(params);
    	String exampleResult = generateCodeService.createProxyExampler(params);
    	logger.info("proxy class result is {}", classResult);
    	logger.info("proxy creator result is {}", creatorResult);
    	logger.info("proxy example result is {}", exampleResult);
    	
    	context.put("classResult", classResult);
    	context.put("creatorResult", creatorResult);
    	context.put("exampleResult", exampleResult);
    }

	private Map<String, Object> getParams(ProxyDO proxyDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		String className = proxyDO.getClassName();
		String instanceName = StringConvertUtil.toInstanceName(className);
		params.put("className", className);
		params.put("instanceName", instanceName);
		params.put("type", proxyDO.getType());
		params.put("interfaceName", proxyDO.getInterfaceName());
		params.put("fileName", "template");
		
		return params;
	}
	
}
