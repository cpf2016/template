package util;


import org.junit.Test;

import com.alibaba.citrus.util.Assert;
import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.utils.StringConvertUtil;

public class StringConvertTest {

	@Test
	public void testXmlFilePath() {
		String fileName = StringConvertUtil.getResultFilePath("mail",VmTypeEnum.DAOXmlMapper);
		System.out.println(fileName);
		Assert.assertTrue("result/ibatis/mail.xml".equals(fileName));
	}

	@Test
	public void testImplFilePath() {
		String fileName = StringConvertUtil.getResultFilePath("mail",VmTypeEnum.DAOImpl);
		System.out.println(fileName);
		Assert.assertTrue("result/ibatis/MailDAOImpl.java".equals(fileName));
	}
	
	@Test
	public void testInterfaceFilePath() {
		String fileName = StringConvertUtil.getResultFilePath("mail",VmTypeEnum.DAOInterface);
		System.out.println(fileName);
		Assert.assertTrue("result/ibatis/MailDAO.java".equals(fileName));
	}
	
	@Test
	public void testToInstanceName(){
		String className = "Bussiness";
		String instanceName = StringConvertUtil.toInstanceName(className);
		System.out.println(instanceName);
		Assert.assertTrue("bussiness".equals(instanceName));
	}
}
