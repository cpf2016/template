package com.alibaba.webx.tutorial1.common.utils.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.common.utils.dataobject.DigestDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;

public class CreateDigestAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateDigestAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createDigest") DigestDO digestDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(digestDO);
    	logger.info("create proxy params is {}", params);
    	
    	String digestResult = generateCodeService.createDigest(params);
    	logger.info("digest result is {}", digestResult);
    	
    	context.put("digestResult", digestResult);
    }

	private Map<String, Object> getParams(DigestDO digestDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("type", digestDO.getType());
		params.put("fileName", "template");
		
		return params;
	}
	
}
