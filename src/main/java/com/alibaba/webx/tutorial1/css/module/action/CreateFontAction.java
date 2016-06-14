package com.alibaba.webx.tutorial1.css.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.css.dataobject.FontCssDO;
import com.alibaba.webx.tutorial1.css.service.GenerateCssService;

public class CreateFontAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateFontAction.class);
	
	@Autowired
	private GenerateCssService generateCssService;
	
    public void doCreate(@FormGroup(name="createFontCss") FontCssDO fontCssDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(fontCssDO);
    	logger.info("create font css params are {}", params);
    	
    	String fontCssResult = generateCssService.createFontCss(params);
    	logger.info("font css result is {}", fontCssResult);
    	context.put("fontCssResult", fontCssResult);
    }

	private Map<String, Object> getParams(FontCssDO fontCssDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("selector", fontCssDO.getSelector());
		params.put("style", fontCssDO.getStyle());
		params.put("weight", fontCssDO.getWeight());
		params.put("size", fontCssDO.getSize());
		params.put("sizeUnit", fontCssDO.getSizeUnit());
		params.put("family", fontCssDO.getFamily());
		params.put("textDecoration", fontCssDO.getTextDecoration());
		params.put("color", fontCssDO.getColor());
		params.put("fileName", "template");
		
		return params;
	}
}
