package com.daloz.libfiles.core.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;

public class TextFileManager implements IFileManager
{
	private static TextFileManager textFileManager = null;
	
	private TextFileManager()
	{
		
	}
	
	public static TextFileManager getInstance()
	{
		if(textFileManager == null)
		{
			textFileManager = new TextFileManager();
		}
		
		return textFileManager;
	}
	
	@Override
	public FileProcessResponse readFile(ReaderEntity readerEntity)
	{
		FileProcessResponse objResponse = new FileProcessResponse();
		
		long starTime = System.nanoTime();
		
		File file = new File(readerEntity.getPath());
		
		return null;
	}

	@Override
	public FileProcessResponse writeFile(WriterEntity writerEntity)
	{
		FileProcessResponse objResponse = new FileProcessResponse();
		
		long starTime = System.nanoTime();
		
		File file = new File(writerEntity.getPath());
		
		try
		(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file)))
		{
			
		}
		catch (Exception e)
		{
			
		}
		
		return null;
	}

}
