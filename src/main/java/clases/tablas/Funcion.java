package clases.tablas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcion
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private Empresa empresa;
	private Map<Competencia, PuntajeNecesario> puntajeNecesarioPorCompetencia;

	public Funcion()
	{
		puntajeNecesarioPorCompetencia = new HashMap<Competencia, PuntajeNecesario>();
	}

	public Map<Competencia, PuntajeNecesario> getPuntajeNecesarioPorCompetencia()
	{
		return puntajeNecesarioPorCompetencia;
	}

	public void setPuntajeNecesarioPorCompetencia(Map<Competencia, PuntajeNecesario> puntajeNecesarioPorCompetencia)
	{
		this.puntajeNecesarioPorCompetencia = puntajeNecesarioPorCompetencia;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
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
