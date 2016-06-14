package com.alibaba.webx.tutorial1.ibatis.module.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

public class DownloadAction {
	@Autowired
	private HttpServletResponse response;
	
	public void doDownload(@Param(name="daoFiles") String[] daoFiles, Context context) {
		if (daoFiles==null || daoFiles.length==0) {
			System.out.println("不能为空");
		}
		
		
		
		
	}
	
	
}
