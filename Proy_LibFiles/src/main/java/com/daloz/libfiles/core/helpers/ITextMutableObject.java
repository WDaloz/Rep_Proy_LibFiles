package com.daloz.libfiles.core.helpers;

import java.lang.reflect.Field;

/**
 *
 *
 * @author Daloz
 * @version 1.0
 */
public interface ITextMutableObject
{
	String getStringFromMutableObject();

	default String getStringInformation(Object object)
	{
		// Obtenemos la lista de campos del tipo de clase del objeto.
		Field[] fields = object.getClass().getDeclaredFields();

		// Obtenemos el nombre de la clase del objeto instanciado
		// Solo nombre simple concatenada con una abertura de llave.
		String textStart = object.getClass().getSimpleName() + " [ ";

		// cerradura de llave.
		String textEnd = " ]";

		// Va a contener el nombre e información de los atributos.
		String information = "";

		// Recorremos la lista de campos.
		for (int i = 0; i < fields.length; i++)
		{
			try
			{
				// Obtenemos el primer elemento de la lista.
				Field f = fields[i];

				// Activamos la suprecion de comprobación de acceso a los
				// atributos en el lenguaje (private)
				f.setAccessible(true);

				// Obtenemos el nombre del atributo y su informacion. Por ultimo
				// concatenamos.
				information = information + f.getName() + " : " + f.get(object) + "; ";
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}

		}
		return textStart + information + textEnd;
	}
}
