package com.daloz.libfiles.dataobjects;

/**
 * Esta entidad permite definir propiedades útiles para informar sobre el
 * proceso lectura/escritura de archivos.
 *
 * @author Daloz
 * @version 1.0
 */
public class FileProcessResponse
{
	//Boolean que define el exito.
	private Boolean success;
	
	//Mensaje del proceso.
	private String message;
	
	//Tiempo de duración del proceso.
	private Double durationProcess;
	
	//Dato usado para el proceso.
	private Object data;
	
	public Object getData()
	{
		return data;
	}

	/**
	 * Método que genera un mapeo automatico cuando el proceso ha sido exitoso.
	 * 
	 * @param data
	 *            : Es la data como respuesta.
	 * @param starTime
	 *            : Es el tiempo de inicio del proceso expresado en
	 *            nanosegundos.
	 * @param endTime
	 *            : Es el tiempo de fin del proceso expresado en nanosegundos
	 * @param message
	 *            : Es el mensaje a mostrar como respuesta.
	 */
	public void generatingMappingSatisfactory(Object data, long starTime, long endTime, String message)
	{
		this.data = data;
		this.durationProcess = (endTime - starTime) / 1000000000.0;
		this.message = message;
		this.success = true;
	}

	/**
	 * Método que genera un mapeao automatico cuando se produce un error como
	 * respuesta de una excepción.
	 * 
	 * @param e : Es la excepción generada.
	 */
	public void generatingMappingErrors(Exception e)
	{
		this.success = false;
		this.durationProcess = 0.0;
		this.message = e.getMessage();
	}

	public String getReport()
	{
		StringBuilder report = new StringBuilder();

		report.append("Proceso exitoso -> ")
		      .append(this.success)
		      .append(", duración: ")
		      .append(this.durationProcess)
			  .append(", mensaje: ")
			  .append(this.message);

		return report.toString();
	}

}
