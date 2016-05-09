package com.test.libfiles.core.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;
import com.daloz.libfiles.factoryservices.FileManagerFactory;
import com.test.dataobjects.MockDataObject;

import static com.daloz.libfiles.util.Log4jU.*;
import static com.daloz.libfiles.config.enums.FileTypes.*;

public class TestXmlFileManager
{

	static IFileManager iFileManager = null;
	MockDataObject mock = null;
	String path;
	WriterEntity writerEntity;
	ReaderEntity readerEntity;

	@BeforeClass
	public static void setUpClass()
	{
		iFileManager = FileManagerFactory.getFileManager(XML_FILE);
		setLogger(TestXmlFileManager.class);
	}

	@Ignore
	@Test
	public void testWriterFile()
	{
		path = "data/output/Mock.xml";

		mock = new MockDataObject(01, "Comestible", 2.30, true, 'E');

		writerEntity = new WriterEntity();
		writerEntity.setObjective(mock);
		writerEntity.setObjectiveClass(mock.getClass());
		writerEntity.setPath(path);
		
		FileProcessResponse objResponse = iFileManager.writeFile(writerEntity);
		
		assertNotNull(objResponse);
		
		logger.info(objResponse.getReport());
	}
	
	@Ignore
	@Test
	public void testReaderFile()
	{
		path = "data/output/Mock.xml";
		
		readerEntity = new ReaderEntity();
		readerEntity.setPath(path);
		readerEntity.setClassTarget(MockDataObject.class);
		
		FileProcessResponse objResponse = iFileManager.readFile(readerEntity);
		
		assertNotNull(objResponse);
		
		logger.info(objResponse.getReport());
		logger.info(((MockDataObject)objResponse.getData()).getStringFromMutableObject());
	}
	
	@Ignore
	@Test
	public void testWriteFiles()
	{
		path = "data/output/Mocks.xml";
		
		List<MockDataObject> listMocks = new ArrayList<>(Arrays.asList(
						new MockDataObject(2, "Bebida", 1.9, true, 'B'),
				        new MockDataObject(2, "Galleta", 0.40, true, 'G')
				                                                      )
				                                        );
		writerEntity = new WriterEntity();
		writerEntity.setObjective(listMocks);
		writerEntity.setObjectiveClass(MockDataObject.class);
		writerEntity.setPath(path);
		
		FileProcessResponse fResponse = iFileManager.writeFile(writerEntity);
		
		assertNotNull(fResponse);
		
		logger.info(fResponse.getReport());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testReadFiles()
	{
		path = "data/output/Mocks.xml";
		
		readerEntity = new ReaderEntity();
		readerEntity.setClassTarget(MockDataObject.class);
		readerEntity.setPath(path);
		
		FileProcessResponse fResponse = iFileManager.readFile(readerEntity);
		
		assertNotNull(fResponse);
		
		logger.info(fResponse.getReport());
		
		List<MockDataObject> listMocks =(List<MockDataObject>) fResponse.getData();
		
		for (int i = 0; i < listMocks.size(); i++)
		{
			logger.info(listMocks.get(i).getStringFromMutableObject());
		}
	}
}
