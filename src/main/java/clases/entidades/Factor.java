package clases.entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.FactorDAO;
import clases.dao.postgres.PostgresFactor;

public class Factor
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer codigo;
	private Integer nroOrden;
	private List<Pregunta> preguntas;
	private Boolean eliminado;
	private FactorDAO dao = new PostgresFactor();
	private Boolean preguntasCargadas;

	public Factor()
	{
		preguntas = new ArrayList<Pregunta>();
		preguntasCargadas = false;
	}
	
	public Factor(Boolean dao)
	{
		this();
		preguntasCargadas = dao;
	}

	public List<Pregunta> getPreguntas() throws SQLException
	{
		if(preguntasCargadas)
			return preguntas;
		else
		{
			preguntas = dao.findPreguntas(this);
			preguntasCargadas = true;
			return preguntas;
		}
	}

	public void setPreguntas(List<Pregunta> preguntas)
	{
		this.preguntas = preguntas;
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

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public Integer getNroOrden()
	{
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden)
	{
		this.nroOrden = nroOrden;
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
