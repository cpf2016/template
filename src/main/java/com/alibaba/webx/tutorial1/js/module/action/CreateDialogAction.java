package com.alibaba.webx.tutorial1.js.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.js.dataobject.DialogDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;

public class CreateDialogAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateDialogAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createDialog") DialogDO windowDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(windowDO);
    	logger.info("create js dialog params is {}", params);
    	
    	String dialogResult = generateCodeService.createJsDialog(params);
    	logger.info("js dialog is {}", dialogResult);
    	
    	context.put("dialogResult", dialogResult);
    }

	private Map<String, Object> getParams(DialogDO windowDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		String[] dialogMethods = windowDO.getDialogMethods(); 
		for (String method : dialogMethods) {
			params.put(method, method);
		}
		
		params.put("fileName", "template");
		
		return params;
	}
	
}
