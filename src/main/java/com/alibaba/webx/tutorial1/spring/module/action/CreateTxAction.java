package com.alibaba.webx.tutorial1.spring.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.spring.dataobject.TxDO;
import com.alibaba.webx.tutorial1.spring.service.GenerateSpringService;

public class CreateTxAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateTxAction.class);
	
	@Autowired
	private GenerateSpringService generateSpringService;
	
    public void doCreate(@FormGroup(name="createTx") TxDO txDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(txDO);
    	logger.info("create transaction params is {}", params);
    	
    	String txResult = generateSpringService.createTx(params);
    	logger.info("transaction result is {}", txResult);
    	context.put("txResult", txResult);
    }

	private Map<String, Object> getParams(TxDO txDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("type", txDO.getType());
		params.put("fileName", "template");
		
		return params;
	}
}
