package clases.entidades;

import java.sql.SQLException;

import clases.dao.interfaces.PreguntaDAO;
import clases.dao.postgres.PostgresPregunta;

public class Pregunta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Boolean eliminado;
	private OpcionDeRespuesta opcionDeRespuesta;
	private PreguntaDAO dao = new PostgresPregunta();
	private Boolean opcionDeRespuestaCargada;
	
	public Pregunta()
	{
		opcionDeRespuestaCargada = false;
	}
	
	public OpcionDeRespuesta getOpcionDeRespuesta() throws SQLException
	{
		if(opcionDeRespuestaCargada)
			return opcionDeRespuesta;
		else
		{
			opcionDeRespuesta = dao.findOpcionDeRespuesta(this);
			opcionDeRespuestaCargada = true;
			return opcionDeRespuesta;
		}
	}

	public void setOpcionDeRespuesta(OpcionDeRespuesta opcionDeRespuesta)
	{
		this.opcionDeRespuesta = opcionDeRespuesta;
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

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

}
