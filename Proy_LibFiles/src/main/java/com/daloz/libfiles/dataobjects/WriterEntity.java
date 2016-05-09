package com.daloz.libfiles.dataobjects;

/**
 * Esta entidad permite definir las propiedades
 * para el proceso de escritura de archivos.
 * 
 * @author Daloz
 * @version 1.0
 */
public class WriterEntity
{
	//Ruta donde se va a escribir el archivo.
	private String path;
	
	//Objeto que se va a escribir.
	private Object objective;
	
	//Clase del objeto que se va a escribir.
	private Class<?> objectiveClass;

	
	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Object getObjective()
	{
		return objective;
	}

	public void setObjective(Object objective)
	{
		this.objective = objective;
	}

	public Class<?> getObjectiveClass()
	{
		return objectiveClass;
	}

	public void setObjectiveClass(Class<?> objectiveClass)
	{
		this.objectiveClass = objectiveClass;
	}

}
