package com.daloz.libfiles.core.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;
import com.daloz.libfiles.exceptions.InvalidFileInputException;
import com.daloz.libfiles.exceptions.InvalidTargetContentException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import static com.daloz.libfiles.config.enums.LibraryProcessMessage.*;
/**
 * Clase que permite gestionar la lectura/escritura 
 * de archivos en formato XML.
 *
 * @author Daloz
 * @version 1.0
 */
public class XmlFileManager implements IFileManager
{
	//Objeto para definir la instancia Singlenton.
	private static XmlFileManager xmlFileManager;
	
	//Objeto que se va a encargar gestionar los archivos XML.
	private static XStream xmlHelper;
	
	// Privatizamos el constructor para evitar su instancia de 
	// de manera normal.
	private XmlFileManager()
	{
		
	}
	
	/**
	 * Función que se encarga de gestionar la
	 * instancia.
	 * 
	 * @return el objeto instanciado.
	 */
	public static XmlFileManager getInstance()
	{
		//Si el objeto no ha sido instanciado.
		if(xmlFileManager == null)
		{
			//Instanciamos el objeto.
			xmlFileManager = new XmlFileManager();
			xmlHelper = new XStream(new StaxDriver());
		}
		
		return xmlFileManager;
	}

	@Override
	public FileProcessResponse readFile(ReaderEntity readerEntity)
	{
		//1. Definimos el objeto de respuesta.
		FileProcessResponse objResponse = new FileProcessResponse();
		
		//2. Capturamos el tiempo de inicio del proceso.
		long starTime = System.nanoTime();
		
		//3. obtenemos la ruta donde se va a escribir el archivo en un
		//   objeto File.
		File fileXml = new File(readerEntity.getPath());
		
		try
		{
			//4. Validamos que solo sean un archivo y NO una carpeta.
			if(fileXml.isDirectory())
			{
				//Generamos una excepción, si es un directorio.
				throw new InvalidFileInputException(INVALID_FILE_INPUT_EXCEPTION.getMesagge());
			}
			
			//5. Obtenemos la clase para registrar al archivo XML.
			Class<?> clazz = readerEntity.getClassTarget();
			
			//6. Registramos el alias al XML
			xmlHelper.alias(clazz.getSimpleName(), clazz);
			
			//7. Obtenemos el contenido del xmlHelper.
			Object object = xmlHelper.fromXML(fileXml);
			
			//8. Capturamos el tiempo de fin del proceso.
			long endTime = System.nanoTime();
			
			//9. Agregamos los datos del proceso finalizado.
			objResponse.generatingMappingSatisfactory(object, starTime, endTime, READ_FILE_SUCCESS_MSG.getMesagge());
		}
		catch (InvalidFileInputException e)
		{
			// Generamos un mapeo de error con la excepción.
			objResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}
		
		return objResponse;
	}

	@Override
	public FileProcessResponse writeFile(WriterEntity writerEntity)
	{
		//1. Definimos el objeto de respuesta.
		FileProcessResponse objResponse = new FileProcessResponse();
		
		//2. Capturamos el tiempo de inicio del proceso.
		long starTime = System.nanoTime();
		
		//3. Obtenemos el objeto a escribir.
		Object objetive = writerEntity.getObjective();
		
		try
		{
			//4. Verificamos si el contenido es valido
			if(objetive instanceof Serializable)
			{
				//5. Obtenemos el registro de la clase del objeto.
				Class<?> clazz = writerEntity.getObjectiveClass();
				
				//6. Si la clase es diferente a nulo.
				if(clazz != null)
				{
					// Obtenemos el nombre corto de la clase, nombre completo de la clase,
					// para registrar el alias.
					xmlHelper.alias(clazz.getSimpleName(), clazz);
				}
				
				//7. Procedemos a escribir el archivo XML, incluimos el objetivo,
				//   mas el flujo de salida del archivo(la ruta).
				xmlHelper.toXML(objetive, new FileOutputStream(writerEntity.getPath()));
			}
			else
			{
				//Si el contenido no es valido se procede a lanzar una excepción.
				throw new InvalidTargetContentException(INVALID_TARGET_CONTENT_EXCEPTION_MSG.getMesagge());
			}
			
			//8. Capturamos el tiempo de fin del proceso.
			long endTime = System.nanoTime();
			
			//9. Generamos el mapeo satisfactorio para el objeto de respuesta.
			objResponse.generatingMappingSatisfactory(null, starTime, endTime, WRITE_FILE_SUCCESS_MSG.getMesagge());
		}
		catch (InvalidTargetContentException | FileNotFoundException e)
		{
			objResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}
		
		//10. Se retorna el objeto de respuesta.
		return objResponse;
	}

}
