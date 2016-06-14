package com.alibaba.webx.tutorial1.css.module.action;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.webx.tutorial1.css.dataobject.TextCssDO;
import com.alibaba.webx.tutorial1.css.service.GenerateCssService;

public class CreateTextAction {
	
	private static Logger logger = LoggerFactory.getLogger(CreateTextAction.class);
	
	@Autowired
	private GenerateCssService generateCssService;
	
    public void doCreate(@FormGroup(name="createTextCss") TextCssDO textCssDO, Context context,
    		Navigator nav)  {
    	Map<String, Object> params = getParams(textCssDO);
    	logger.info("create text css params are {}", params);
    	
    	String textCssResult = generateCssService.createTextCss(params);
    	logger.info("text css result is {}", textCssResult);
    	context.put("textCssResult", textCssResult);
    }

	private Map<String, Object> getParams(TextCssDO textCssDO) {
		Map<String, Object> params = CollectionUtil.createHashMap();
		
		params.put("selector", textCssDO.getSelector());
		params.put("lineHeight", textCssDO.getLineHeight());
		params.put("lineHeightUnit", textCssDO.getLineHeightUnit());
		params.put("textIndent", textCssDO.getTextIndent());
		params.put("textIndentUnit", textCssDO.getTextIndentUnit());
		params.put("textAlign", textCssDO.getTextAlign());
		params.put("fileName", "template");
		
		return params;
	}
}
