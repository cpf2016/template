package com.alibaba.webx.tutorial1.service;

import java.util.Map;

public interface GenerateCodeService {
	String createProxyClass(Map<String, Object> params);

	String createProxyCreator(Map<String, Object> params);

	String createProxyExampler(Map<String, Object> params);

	String createDigest(Map<String, Object> params);

	String createJson(Map<String, Object> params);

	String createDate(Map<String, Object> params);

	String createJsInnerObject(Map<String, Object> params);

	String createJsDialog(Map<String, Object> params);

	String createJsNewWindow(Map<String, Object> params);

	String createJsTimer(Map<String, Object> params);
}
