package com.alibaba.webx.tutorial1.utils;

import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx.tutorial1.constant.Constant;
import com.alibaba.webx.tutorial1.constant.VmTypeEnum;

public final class StringConvertUtil {
	/**
	 * 将camel形式的字符串转换为ClassName类型的
	 * 实际上就是将首字母大写
	 * @param camelCaseString
	 * @return
	 */
	public static String toClassName(String camelCaseString) {
		StringBuilder sb = new StringBuilder(camelCaseString);
		char firstLetter = camelCaseString.charAt(0);
		sb.setCharAt(0, Character.toUpperCase(firstLetter));
		
		return sb.toString();
	}
	
	/**
	 * 将ClassName形式的字符串转换为InstanceName类型的
	 * 实际上就是将首字母小写
	 * @param className
	 * @return
	 */
	public static String toInstanceName(String className) {
		StringBuilder sb = new StringBuilder(className);
		char firstLetter = className.charAt(0);
		sb.setCharAt(0, Character.toLowerCase(firstLetter));
		
		return sb.toString();
	}
	
	

	/**
	 * 根据vm名称产生存储结果文件的名称
	 * @param name 
	 * @param vmType
	 * @return
	 */
	public static String getResultFilePath(String name, VmTypeEnum vmType) {
		String fileName = getResultFileName(name,vmType);
		
		String path;
		if ("ibatis".equals(vmType.getComponent())) {
			path = Constant.IBATIS__FILE_PATH;
		}else if ("css".equals(vmType.getComponent())) {
			path = Constant.CSS__FILE_PATH;
		}
		else if ("spring".equals(vmType.getComponent())) {
			path = Constant.SPRING__FILE_PATH;
		}else {
			path = "result/undefined";
		}
		String result = StringUtil.join(new String[]{
				path,
				vmType.getType(),
				fileName
		}, "/");
		return result;
	}

	/**
	 * 因为在VmTypeEnum中存储的结果文件都是“*DAO.java”或“*.xml”等形式
	 * 其中的*代表了表名，所以我们需要将*替换为具体的名称
	 * @param name
	 * @param vmType
	 * @return
	 */
	public static String getResultFileName(String name, VmTypeEnum vmType) {
		String fileName = null;
		
		String originName = vmType.getResultFileName();
		if (vmType.compareTo(VmTypeEnum.DAOXmlMapper)==0) {
			fileName = originName.replace("*", name);
		}else {
			String camelName = StringUtil.toCamelCase(name);
			String ClassName = StringConvertUtil.toClassName(camelName);
			fileName = originName.replace("*", ClassName);
		}
		
		return fileName;
	}
}
