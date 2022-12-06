package clases.entidades;

import clases.dao.interfaces.RespuestaDAO;
import clases.dao.postgres.PostgresRespuesta;

public class Respuesta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer ordenVisualizacion;
	private Ponderacion ponderacion;
	private RespuestaDAO dao = new PostgresRespuesta();

	public Ponderacion getPonderacion()
	{
		return ponderacion;
	}

	public void setPonderacion(Ponderacion ponderacion)
	{
		this.ponderacion = ponderacion;
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

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public Integer getOrdenVisualizacion()
	{
		return ordenVisualizacion;
	}

	public void setOrdenVisualizacion(Integer ordenVisualizacion)
	{
		this.ordenVisualizacion = ordenVisualizacion;
	}

}
