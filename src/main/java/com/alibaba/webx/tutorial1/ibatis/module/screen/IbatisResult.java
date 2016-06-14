package com.alibaba.webx.tutorial1.ibatis.module.screen;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;

public class IbatisResult {

	@Autowired
	private HttpSession session;
	
    public void execute(Context context) throws Exception {
    }
}
