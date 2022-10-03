package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class Empresa
{
	private Integer id;
	private String nombre;
	private List<Funcion> funciones;
	
	public Empresa()
	{
		funciones = new ArrayList<Funcion>();
	}
	
	public List<Funcion> getFunciones()
	{
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones)
	{
		this.funciones = funciones;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

}
