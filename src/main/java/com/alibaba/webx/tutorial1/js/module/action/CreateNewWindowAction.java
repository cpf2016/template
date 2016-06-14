package com.alibaba.webx.tutorial1.js.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx.tutorial1.js.dataobject.NewWindowDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;

public class CreateNewWindowAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateNewWindowAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createNewWindow") NewWindowDO newWindowDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(newWindowDO);
    	logger.info("create js new window params is {}", params);
    	
    	String newWindowResult = generateCodeService.createJsNewWindow(params);
    	logger.info("js new window is {}", newWindowResult);
    	
    	context.put("newWindowResult", newWindowResult);
    }

	private Map<String, Object> getParams(NewWindowDO newWindowDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("type", newWindowDO.getType());
		params.put("url", newWindowDO.getUrl());
		
		String[] allFeatures = newWindowDO.getFeatures();
		String features = StringUtil.join(allFeatures, "=,");
		params.put("features", features);
		
		params.put("fileName", "template");
		
		return params;
	}
	
}
