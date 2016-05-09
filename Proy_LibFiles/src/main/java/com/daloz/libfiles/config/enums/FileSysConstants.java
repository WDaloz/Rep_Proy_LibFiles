package com.daloz.libfiles.config.enums;

/**
 * Este tipo de clase especial representa
 * constantes utiles para los procesos
 * que se van a realizar en nuestra libreria.
 * 
 * @author Daloz
 * @version 1.0
 */
public enum FileSysConstants
{
	//Saltos de línea(Me devuelve la constante de SO, para el salto de linea)
	//para evitar versiones incompatibles.
	LINE_SEPARATOR(System.getProperty("line.separator"));
	
	private String value;
	
	private FileSysConstants(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	
}
