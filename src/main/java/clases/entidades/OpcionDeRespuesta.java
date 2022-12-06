package clases.entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.OpcionDeRespuestaDAO;
import clases.dao.postgres.PostgresOpcionDeRespuesta;

public class OpcionDeRespuesta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Boolean eliminado;
	private List<Respuesta> respuestas;

	public OpcionDeRespuesta()
	{
		respuestas = new ArrayList<Respuesta>();
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

	public List<Respuesta> getRespuestas() throws SQLException
	{
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas)
	{
		this.respuestas = respuestas;
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

}
