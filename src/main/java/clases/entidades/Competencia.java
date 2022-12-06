package clases.entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clases.dao.interfaces.CompetenciaDAO;
import clases.dao.postgres.PostgresCompetencia;

public class Competencia
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private Boolean eliminado;
	private List<Factor> factores;
	private CompetenciaDAO dao = new PostgresCompetencia();
	private Boolean factoresCargados;

	public Competencia()
	{
		factores = new ArrayList<Factor>();
		factoresCargados = false;
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

	public List<Factor> getFactores() throws SQLException
	{
		if (factoresCargados)
			return factores;
		else
		{
			factores = dao.findFactores(this);
			factoresCargados = true;
			return factores;
		}
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
