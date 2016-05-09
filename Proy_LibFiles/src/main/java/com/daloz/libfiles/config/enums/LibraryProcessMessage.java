package com.daloz.libfiles.config.enums;

/**
 *
 *
 * @author Daloz
 * @version 1.0
 */
public enum LibraryProcessMessage
{
	FILE_NOT_FOUND_EXCEPTION_MSG
	("No se encuentra o no se puede acceder al archivo de origen que ha especificado, por favor, verifique que la ruta sea correcta"),
	
	INVALID_FILE_INPUT_EXCEPTION
	("El archivo de entrada especificado no es el esperado para el proceso, verifique si necesita una carpeta o un archivo simple"),
	
	READ_FILE_SUCCESS_MSG
	("La lectura del archivo se realizó con éxito"),
	
	
	
	WRITE_FILE_SUCCESS_MSG
	("El archivo se creó con el contenido enviado"),
	
	INVALID_TARGET_CONTENT_EXCEPTION_MSG
	("El contenido que quiere guardar en el archivo no es válido, asegúrese de estar implementando las interfaces correctas y enviar el formato adecuado"),
	
	INVALID_FILE_MANAGER_EXCEPTION_MSG
	("El tipo de gestor de archivos seleccionado es desconocido");

	private String mesagge;

	private LibraryProcessMessage(String mesagge)
	{
		this.mesagge = mesagge;
	}

	public String getMesagge()
	{
		return mesagge;
	}


	public void setMesagge(String mesagge)
	{
		this.mesagge = mesagge;
	}
	
	
}
