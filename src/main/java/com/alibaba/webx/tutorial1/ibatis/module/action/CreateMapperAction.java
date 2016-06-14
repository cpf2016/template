package com.alibaba.webx.tutorial1.ibatis.module.action;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.webx.tutorial1.ibatis.dataobject.MapperInfo;
import com.alibaba.webx.tutorial1.ibatis.service.GenerateDAOService;
import com.alibaba.webx.tutorial1.ibatis.service.ParseParamService;

public class CreateMapperAction {
	@Autowired
	private ParseParamService parseParamService;
	
	@Autowired
	private GenerateDAOService generateDAOService;
	
	
    public void doCreate(@FormGroup(name="createIbatis") MapperInfo mapperInfo, Context context,
    		Navigator nav) throws IOException {
    	Map<String,Object> params = parseParamService.parseVelocityParams(mapperInfo);
    	
        String DAOInterfaceContent = generateDAOService.createDAOInterface(params);
        String DAOImplContent = generateDAOService.createDAOImpl(params);
        String DAOXmlContent = generateDAOService.createDAOXml(params);
        
        context.put("DAOInterfaceContent", DAOInterfaceContent);
        context.put("DAOImplContent", DAOImplContent);
        context.put("DAOXmlContent", DAOXmlContent);
    	
//    	nav.redirectTo("ibatisResultLink");
        nav.forwardTo("ibatisResult");
    }
}
