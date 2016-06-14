package com.alibaba.webx.tutorial1.constant;

public enum VmTypeEnum {
	DAOInterface("ibatis","DAOinterface","ibatis/DAOInterface.vm","*DAO.java"),
	DAOImpl("ibatis","DAOimpl","ibatis/DAOImpl.vm","*DAOImpl.java"),
	DAOXmlMapper("ibatis","xmlMapper","ibatis/DAOXmlMapper.vm","*.xml"),
	ServiceImpl("ibatis","ServiceImpl","ibatis/ServiceImpl.vm","*ServiceImpl.java"),
	
	FontCss("css","FontCss","css/FontCss.vm","*.css"),
	TextCss("css","TextCss","css/TextCss.vm","*.css"),
	
	Tx("spring","tx","spring/Tx.vm","*.xml"),
	
	AopConfig("spring","AopConfig","spring/AopConfig.vm","application.xml"),
	AopAdvice("spring","AopAdvice","spring/AopAdvice.vm","*.java"), 
	
	ProxyClass("designPattern","proxyClass","designPattern/ProxyClass.vm","*Proxy.java"), 
	ProxyCreator("designPattern","proxyCreator","designPattern/ProxyCreator.vm","ProxyCreator.java"),
	ProxyExample("designPattern","proxyExample","designPattern/ProxyExample.vm","ProxyExample.java"),
	
	Digest("commonUtils","degist","commonUtils/DigestUtils.vm","DigestUtils.java"),
	Json("commonUtils","json","commonUtils/JsonUtils.vm","JsonUtils.java"),
	Date("commonUtils","date","commonUtils/DateUtils.vm","DateUtils.java"),
	
	InnerObject("js","innerObject","js/InnerObject.vm","InnerObject.js"), 
	Dialog("js","dialog","js/Dialog.vm","Dialog.js"), 
	NewWindow("js","newWindow","js/NewWindow.vm","NewWindow.js"), 
	Timer("js","timer","js/Timer.vm","Timer.js");
	
	private String component;
	private String type;
	private String vmName;
	private String resultFileName;
	
	VmTypeEnum(String component, String type, String vmName,String resultFileName){
		this.component = component;
		this.type = type;
		this.vmName = vmName;
		this.resultFileName = resultFileName;
	}

	
	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getResultFileName() {
		return resultFileName;
	}

	public void setResultFileName(String resultFileName) {
		this.resultFileName = resultFileName;
	}
}
