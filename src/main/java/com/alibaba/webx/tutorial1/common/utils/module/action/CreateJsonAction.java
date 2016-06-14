package com.alibaba.webx.tutorial1.common.utils.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.common.utils.dataobject.JsonDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;

public class CreateJsonAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateJsonAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createJson") JsonDO jsonDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(jsonDO);
    	logger.info("create json params is {}", params);
    	
    	String jsonResult = generateCodeService.createJson(params);
    	logger.info("json result is {}", jsonResult);
    	
    	context.put("jsonResult", jsonResult);
    }

	private Map<String, Object> getParams(JsonDO jsonDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		String className = jsonDO.getClassName();
		String instanceName = StringConvertUtil.toInstanceName(className);
		params.put("className", className);
		params.put("instanceName", instanceName);
		params.put("type", jsonDO.getType());
		params.put("fileName", "template");
		
		return params;
	}
	
}
