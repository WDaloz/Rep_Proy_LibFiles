package com.test.config.enums;

import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.libfiles.config.enums.FileSysConstants;
import com.daloz.libfiles.config.enums.FileTypes;
import static com.daloz.libfiles.util.Log4jU.*;

import java.util.ArrayList;

/**
 *
 *
 * @author Daloz
 * @version 1.0
 */
public class TestFilesTypes
{
	FileTypes fileTypes;
	
	@BeforeClass
	public static void setUpClass()
	{
		setLogger(TestFilesTypes.class);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testXml()
	{
		Object x = new ArrayList<String>();
		
		System.out.println(x.getClass());
		
		logger.info(FileSysConstants.LINE_SEPARATOR.getValue());
		
		logger.info(fileTypes.SERIAL_FILE.getDescription());
		logger.info(fileTypes.TEXT_FILE.getDescription());
		logger.info(fileTypes.XML_FILE.getDescription());
	}
	
	
}
