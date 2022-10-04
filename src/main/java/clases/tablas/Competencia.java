package clases.tablas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Competencia
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private Map<Funcion, PuntajeNecesario> puntajesNecesariosPorFuncion;
	private List<Factor> factores;
	private Funcion funcion;

	public Competencia()
	{
		factores = new ArrayList<Factor>();
		puntajesNecesariosPorFuncion = new HashMap<Funcion, PuntajeNecesario>();
	}

	public Map<Funcion, PuntajeNecesario> getPuntajesNecesariosPorFuncion()
	{
		return puntajesNecesariosPorFuncion;
	}

	public void setPuntajesNecesariosPorFuncion(Map<Funcion, PuntajeNecesario> puntajesNecesariosPorFuncion)
	{
		this.puntajesNecesariosPorFuncion = puntajesNecesariosPorFuncion;
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
