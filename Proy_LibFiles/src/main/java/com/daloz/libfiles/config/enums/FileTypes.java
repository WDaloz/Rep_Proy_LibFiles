package com.daloz.libfiles.config.enums;

/**
 * Este tipo de clase especial maneja las constantes
 * para los diferentes tipos de archivos que van a soportar
 * nuestra libreria.
 *
 * @author Daloz
 * @version 1.0
 */
public enum FileTypes
{
	XML_FILE("Archivo xml", ".xml"),
	TEXT_FILE("Archivo de texto plano", ".txt"),
	SERIAL_FILE("Archivo de secuencia de bytes", ".bser");
	
	private String description, extension;
	
	private FileTypes(String description, String extension)
	{
		this.description = description;
		this.extension = extension;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
	
}
