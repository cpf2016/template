package com.alibaba.webx.tutorial1.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx.tutorial1.ibatis.dataobject.ColumnInfo;

public final class SqlUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SqlUtil.class);
	/**
	 * 将列的所有信息存储在传入的columnsInfo中，并且返回表名
	 * @param ddl
	 * @param columnsInfo
	 * @return
	 */
	public static String getTableInfo(String ddl, List<ColumnInfo> columnsInfo) {
		Table table = null;
		try {
			Statement stmt = CCJSqlParserUtil.parse(ddl);
			CreateTable createTable = (CreateTable) stmt;
			table = createTable.getTable();
			
			List<ColumnDefinition> columnDefinitions = createTable.getColumnDefinitions();
			for (ColumnDefinition definition : columnDefinitions) {
				ColumnInfo columnInfo = new ColumnInfo();
				columnInfo.setColumnName(definition.getColumnName().toUpperCase());
				columnInfo.setColumnType(definition.getColDataType().getDataType().toUpperCase());
				columnInfo.setPropertyName(StringUtil.toCamelCase(definition.getColumnName()));
				
				columnsInfo.add(columnInfo);
			}
		} catch (JSQLParserException e) {
			logger.error("fail to parse ddl:{}",ddl);
		}
		return table.getName();
	}
}
