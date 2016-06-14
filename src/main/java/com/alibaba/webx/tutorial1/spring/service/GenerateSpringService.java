package com.alibaba.webx.tutorial1.spring.service;

import java.util.Map;

public interface GenerateSpringService {
	public String createTx(Map<String, Object> params);

	public String createAopConfig(Map<String, Object> params);

	public String createAopAdvice(Map<String, Object> params);

}
