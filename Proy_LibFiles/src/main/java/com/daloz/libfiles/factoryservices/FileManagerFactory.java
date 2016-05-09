package com.daloz.libfiles.factoryservices;

import com.daloz.libfiles.config.enums.FileTypes;
import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.core.impl.XmlFileManager;
import static com.daloz.libfiles.config.enums.LibraryProcessMessage.*;
public abstract class FileManagerFactory
{
	public static IFileManager getFileManager(FileTypes fileTypes)
	{
		switch (fileTypes)
		{
			case XML_FILE:
				return XmlFileManager.getInstance();
			default:
				throw new UnsupportedOperationException(INVALID_FILE_MANAGER_EXCEPTION_MSG.getMesagge());
		}
	}
}
