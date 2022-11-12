package clases.entidades;

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
	private Boolean eliminado;
	private PuntajeNecesario puntajesNecesarios;
	private List<Factor> factores;

	public PuntajeNecesario getPuntajesNecesarios()
	{
		return puntajesNecesarios;
	}

	public void setPuntajesNecesarios(PuntajeNecesario puntajesNecesarios)
	{
		this.puntajesNecesarios = puntajesNecesarios;
	}

	public Competencia()
	{
		factores = new ArrayList<Factor>();
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
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
