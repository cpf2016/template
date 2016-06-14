package com.alibaba.webx.tutorial1.js.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.js.dataobject.TimerDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;

public class CreateTimerAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateTimerAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createTimer") TimerDO timerDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(timerDO);
    	logger.info("create timer params is {}", params);
    	
    	String timerResult = generateCodeService.createJsTimer(params);
    	logger.info("js timer is {}", timerResult);
    	
    	context.put("timerResult", timerResult);
    }

	private Map<String, Object> getParams(TimerDO timerDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("type", timerDO.getType());
		params.put("interval", timerDO.getInterval());
		
		params.put("fileName", "template");
		
		return params;
	}
	
}
