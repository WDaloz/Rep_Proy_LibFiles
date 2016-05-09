package com.daloz.libfiles.core;

import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;

/**
 * Aplicamos el patron: Strategy.
 * 
 * Esta interfaz define el contrato de la estrategia que vamos a utilizar
 * en nuestra libreria de archivos.
 *
 * @author Daloz
 * @version 1.0
 */
public interface IFileManager
{
	/**
	 * Esta definici�n de funci�n indica los componentes
	 * necesarios para el proceso de lectura de un archivo.
	 * 
	 * @param readerEntity : Contiene la informacion para el proceso de
	 *                       lectura (ruta, clase, configuraci�n)
	 *                       
	 * @return : Un objeto de tipo FileProcessResponse con informaci�n 
	 *           del proceso realizado.
	 */
	FileProcessResponse readFile(ReaderEntity readerEntity);
	
	
	/**
	 * Esta definici�n de funci�n indica los componentes
	 * necesarios para el proceso de escritura de un archivo.
	 * 
	 * @param writerEntity : Contiene la informaci�n para el proceso de
	 *                        escritura de un archivo (ruta, objetivo, ect.)
	 *                        
	 * @return : Un objeto de tipo FileProcessResponse con informaci�n 
	 *           del proceso realizado.
	 */
	FileProcessResponse writeFile(WriterEntity writerEntity);
}
