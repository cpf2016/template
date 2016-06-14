package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

import com.alibaba.citrus.util.Assert;
import com.alibaba.webx.tutorial1.constant.VmTypeEnum;
import com.alibaba.webx.tutorial1.utils.PersistUtil;

public class PersistUtilTest {

	@Test
	public void testFilePath() throws IOException{
//		String content = "123"; 
//		File file = new File("result/xx.txt");
//		OutputStream out = new FileOutputStream(file);
//		byte[] buffer = content.getBytes();
//		out.write(buffer);
//		out.flush();
//		out.close();
	}
	
//	@Test
	public void testImplSaveToFile() {
		boolean result = PersistUtil.saveToFile(VmTypeEnum.DAOImpl, "mail", "123");
		Assert.assertTrue(result);
	}
	
//	@Test
	public void testInterfaceSaveToFile() {
		boolean result = PersistUtil.saveToFile(VmTypeEnum.DAOInterface, "mail", "123");
		Assert.assertTrue(result);
	}
	
//	@Test
	public void testXmlSaveToFile() {
		boolean result = PersistUtil.saveToFile(VmTypeEnum.DAOXmlMapper, "mail", "123");
		Assert.assertTrue(result);
	}

}
