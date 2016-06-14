package com.alibaba.webx.tutorial1.common.utils.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx.tutorial1.common.utils.dataobject.DateDO;
import com.alibaba.webx.tutorial1.service.GenerateCodeService;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;

public class CreateDateAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateDateAction.class);
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
    public void doCreate(@FormGroup(name="createDate") DateDO dateDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(dateDO);
    	logger.info("create date params is {}", params);
    	
    	String dateResult = generateCodeService.createDate(params);
    	logger.info("json result is {}", dateResult);
    	
    	context.put("dateResult", dateResult);
    }

	private Map<String, Object> getParams(DateDO dateDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("type", dateDO.getType());
		params.put("createType", dateDO.getCreateType());
		
		String[] methods = dateDO.getMethods();
		if (methods!=null && methods.length>0) {
			for (String m : methods) {
				params.put(m, m);
			}
		}
		params.put("dateUnit", dateDO.getDateUnit());
		params.put("operateType", dateDO.getOperateType());
		params.put("number", dateDO.getNumber());
		
		String dateBetween = dateDO.getDateBetween();
		if (!StringUtil.isBlank(dateBetween)) {
			params.put("dateBetween", dateBetween);
			params.put("methodPrefix", StringConvertUtil.toInstanceName(dateBetween));
			
		}
		
		params.put("dateCompare", dateDO.getDateCompare());
		
		params.put("fileName", "template");
		
		return params;
	}
	
}
