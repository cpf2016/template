package com.alibaba.webx.tutorial1.service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.webx.tutorial1.constant.Constant;
import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.utils.PersistUtil;

public class VelocityService {

	private static final Logger logger = LoggerFactory.getLogger(VelocityService.class);
	
	private static VelocityEngine engine;
	private static VelocityContext velocityContext = new VelocityContext();

	static {
		// 指定所有vm文件所在的文件夹路径，此处即为classpath
		String vmPath = VelocityService.class.getClassLoader()
				.getResource("").getPath();

		Properties p = new Properties();
		p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, vmPath);
		p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

		engine = new VelocityEngine(p);
	}

	/**
	 * 根据vm生成结果string，并且将结果保存在文件中
	 * @param vmName
	 * @param params
	 * @return
	 */
	public  String getVmContent(VmTypeEnum vmType, Map<String, Object> params) {
		//参数放入velocity
		String vmName = vmType.getVmName();
		Template template = engine.getTemplate(vmName);
		for (Entry<String, Object> entry: params.entrySet()) {
			velocityContext.put(entry.getKey(), entry.getValue());
		}
		
		//完成模板替换
		Writer writer = new StringWriter();
		template.merge(velocityContext, writer);
		try {
			writer.flush();
		} catch (IOException e) {
			logger.error("fail to generate velocity result file");
		}
		String result = writer.toString();
		try {
			writer.close();
		} catch (IOException e) {
			logger.error("fail to close Writer");
		}
		
		String fileName = (String) params.get("fileName");
		PersistUtil.saveToFile(vmType, fileName, result);
		
		return result;
		
	}
}
