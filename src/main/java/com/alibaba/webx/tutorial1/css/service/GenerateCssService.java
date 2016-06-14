package com.alibaba.webx.tutorial1.css.service;

import java.util.Map;

public interface GenerateCssService {
	public String createFontCss(Map<String, Object> params);

	public String createTextCss(Map<String, Object> params);
}
