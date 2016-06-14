package com.alibaba.webx.tutorial1.spring.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.spring.dataobject.AopDO;
import com.alibaba.webx.tutorial1.spring.service.GenerateSpringService;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;

public class CreateAopAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateAopAction.class);
	
	@Autowired
	private GenerateSpringService generateSpringService;
	
    public void doCreate(@FormGroup(name="createAop") AopDO aopDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(aopDO);
    	logger.info("create aop params is {}", params);
    	
    	String configResult = generateSpringService.createAopConfig(params);
    	String adviceResult = generateSpringService.createAopAdvice(params);
    	logger.info("aop config result is {}", configResult);
    	logger.info("aop advice result is {}", adviceResult);
    	context.put("configResult", configResult);
    	context.put("adviceResult", adviceResult);
    }

	private Map<String, Object> getParams(AopDO aopDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		String className = aopDO.getName();
		String instanceName = StringConvertUtil.toInstanceName(className);
		params.put("className", className);
		params.put("instanceName", instanceName);
		params.put("type", aopDO.getType());
		params.put("fileName", "template");
		
		return params;
	}
	
}
