package com.test.dataobjects;

import java.io.Serializable;

import com.daloz.libfiles.core.helpers.ITextMutableObject;


public class MockDataObject implements Serializable, ITextMutableObject
{

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String descripcion;
	private double precio;
	private boolean disponible;
	private char categoria;

	public MockDataObject()
	{

	}

	public MockDataObject(int codigo, String descripcion, double precio, boolean disponible, char categoria)
	{
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.disponible = disponible;
		this.categoria = categoria;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public double getPrecio()
	{
		return precio;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public boolean isDisponible()
	{
		return disponible;
	}

	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}

	public char getCategoria()
	{
		return categoria;
	}

	public void setCategoria(char categoria)
	{
		this.categoria = categoria;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

	

}
