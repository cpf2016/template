package com.alibaba.webx.tutorial1.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.webx.tutorial1.constant.VmTypeEnum;


public final class PersistUtil {
	private static final Logger logger = LoggerFactory.getLogger(PersistUtil.class);
	
	/**
	 * 将结果保存在文件中
	 * @param vmType
	 * @param name
	 * @param content
	 * @return
	 */
	public static boolean saveToFile(VmTypeEnum vmType, String name, String content) {
		String filePath = StringConvertUtil.getResultFilePath(name,vmType); 
		File file = new File(filePath);
		
		boolean isSuccess = false;
		try {
			FileUtils.writeStringToFile(file, content);
			isSuccess = true;
		} catch (IOException e) {
			logger.error("fail to save result to file {}",filePath);
		}
		
		return isSuccess;
	}
}
