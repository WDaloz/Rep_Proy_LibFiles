package com.daloz.libfiles.dataobjects;

/**
 * Esta entidad permite definir las propiedades para realizar el proceso de
 * lectura de un archivo.
 * 
 * @author Mandraque
 * @version 1.0
 */
public class ReaderEntity
{
	//Ruta del archivo a leer.
	private String path;
	
	//Clase para registrar al archivo.
	private Class<?> classTarget;

	public Class<?> getClassTarget()
	{
		return classTarget;
	}

	public void setClassTarget(Class<?> classTarget)
	{
		this.classTarget = classTarget;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

}
