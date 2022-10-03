package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class Competencia
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private List<Factor> factores;
	private Funcion funcion;
	
	public Competencia()
	{
		factores = new ArrayList<Factor>();
	}
	
	public Funcion getFuncion()
	{
		return funcion;
	}

	public void setFuncion(Funcion funcion)
	{
		this.funcion = funcion;
	}

	public List<Factor> getFactores()
	{
		return factores;
	}

	public void setFactores(List<Factor> factores)
	{
		this.factores = factores;
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

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
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

}
