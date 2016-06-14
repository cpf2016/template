package com.alibaba.webx.tutorial1.ibatis.dataobject;

public class MapperInfo {
	private String ddl;
	
	private	String[] insertMethods;
	private	String[] updateMethods;
	private	String[] deleteMethods;
	private	String[] queryMethods;

	private String namespace;

	public String getDdl() {
		return ddl;
	}

	public void setDdl(String ddl) {
		this.ddl = ddl;
	}

	public String[] getInsertMethods() {
		return insertMethods;
	}

	public void setInsertMethods(String[] insertMethods) {
		this.insertMethods = insertMethods;
	}

	public String[] getUpdateMethods() {
		return updateMethods;
	}

	public void setUpdateMethods(String[] updateMethods) {
		this.updateMethods = updateMethods;
	}

	public String[] getDeleteMethods() {
		return deleteMethods;
	}

	public void setDeleteMethods(String[] deleteMethods) {
		this.deleteMethods = deleteMethods;
	}

	public String[] getQueryMethods() {
		return queryMethods;
	}

	public void setQueryMethods(String[] queryMethods) {
		this.queryMethods = queryMethods;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
}
