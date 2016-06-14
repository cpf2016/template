package com.alibaba.webx.tutorial1.js.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.js.dataobject.InnerObjectDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;

public class CreateInnerObjectAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateInnerObjectAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createInnerObject") InnerObjectDO innerObjectDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(innerObjectDO);
    	logger.info("create js inner object params is {}", params);
    	
    	String innerObjectResult = generateCodeService.createJsInnerObject(params);
    	logger.info("js inner object is {}", innerObjectResult);
    	
    	context.put("innerObjectResult", innerObjectResult);
    }

	private Map<String, Object> getParams(InnerObjectDO innerObjectDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		String[] arrayMethods = innerObjectDO.getArrayMethods(); 
		for (String method : arrayMethods) {
			params.put(method, method);
		}
		String[] dateMethods = innerObjectDO.getDateMethods(); 
		for (String method : dateMethods) {
			params.put(method, method);
		}
		String[] stringMethods = innerObjectDO.getStringMethods(); 
		for (String method : stringMethods) {
			params.put(method, method);
		}
		
		params.put("fileName", "template");
		
		return params;
	}
	
}
