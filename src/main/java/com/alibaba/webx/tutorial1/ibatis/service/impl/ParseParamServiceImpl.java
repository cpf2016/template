package com.alibaba.webx.tutorial1.ibatis.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.citrus.util.CollectionUtil;
import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx.tutorial1.ibatis.dataobject.ColumnInfo;
import com.alibaba.webx.tutorial1.ibatis.dataobject.MapperInfo;
import com.alibaba.webx.tutorial1.ibatis.service.ParseParamService;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;
import com.alibaba.webx.tutorial1.utils.SqlUtil;

public class ParseParamServiceImpl implements ParseParamService {
	private static Logger logger = LoggerFactory.getLogger(ParseParamServiceImpl.class);
	
	@Override
	public Map<String, Object> parseVelocityParams(MapperInfo mapperInfo) {
		Map<String,Object> params = CollectionUtil.createHashMap();
		
		getNamespaceParam(mapperInfo, params);
        getTypeParams(mapperInfo, params);
        getMethodParams(mapperInfo, params);
		
        return params;
	}
	
	/**
	 * 将namespace作为变量存储在velocity中
	 * @param mapperInfo
	 * @param params
	 */
	private void getNamespaceParam(MapperInfo mapperInfo,
			Map<String, Object> params) {
		logger.info("namesapce is {}","ali_template");
		params.put("namespace", "ali_template");
	}
	
	/**
	 * 存储有关类型的一些信息在velocity中
	 * 以传入的表名为msg_info为例
	 * typeName = MsgInfo
	 * instanceName = msgInfoDO
	 * pojoName = MsgInfoDO
	 * daoName = MsgInfoDAO
	 * daobeanName = msgInfoDAO
	 * @param mapperInfo
	 * @param params
	 */
	private void getTypeParams(MapperInfo mapperInfo,Map<String,Object> params){
		String ddl = mapperInfo.getDdl();
		
		List<ColumnInfo> columnInfos = CollectionUtil.createArrayList();
		String tableName = SqlUtil.getTableInfo(ddl,columnInfos);
		String instanceName = StringUtil.join(new Object[]{StringUtil.toCamelCase(tableName),"DO"}, "");
		String typeName = StringConvertUtil.toClassName(StringUtil.toCamelCase(tableName));
		String daoName = StringUtil.join(new String[]{typeName,"DAO"}, "");
		String daobeanName = StringUtil.join(new Object[]{StringUtil.toCamelCase(tableName),"DAO"}, "");
        String pojoName = StringConvertUtil.toClassName(instanceName);
        
        params.put("tableName", tableName);
        params.put("typeName", typeName);
        params.put("daoName", daoName);
        params.put("daobeanName", daobeanName);
        params.put("instanceName", instanceName);
        params.put("pojoName", pojoName);
        params.put("columnInfos", columnInfos);
        params.put("fileName", tableName);
        
        logger.info("table name is {}",tableName);
        logger.info("columns are {}",StringUtil.join(columnInfos, ";"));
	}
	
	/**
	 * 将选择的
	 * @param mapperInfo
	 * @param params
	 */
	private void getMethodParams(MapperInfo mapperInfo,Map<String,Object> params){
		String[] insertMethods = mapperInfo.getInsertMethods();
        String[] updateMethods = mapperInfo.getUpdateMethods();
        String[] deleteMethods = mapperInfo.getDeleteMethods();
        String[] queryMethods = mapperInfo.getQueryMethods();
        
        fillParams(insertMethods, params);
        fillParams(updateMethods, params);
        fillParams(deleteMethods, params);
        fillParams(queryMethods, params);
        
        logger.info("insert method is {}",StringUtil.join(insertMethods, "-"));
        logger.info("update method is {}",StringUtil.join(updateMethods, "-"));
        logger.info("delete method is {}",StringUtil.join(deleteMethods, "-"));
        logger.info("query method is {}",StringUtil.join(queryMethods, "-"));
	}
	
	private void fillParams(String[] methodNames,Map<String,Object> params){
		if (methodNames!=null) {
        	for (String method : methodNames) {
        		params.put(method, method);
        	}
		}
	}
}
