package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class Funcion
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private Empresa empresa;
	private List<PuntajeNecesario> puntajeNecesarioPorCompetencia;
	private List<Competencia> competencias;

	public Funcion()
	{
		competencias = new ArrayList<Competencia>();
		puntajeNecesarioPorCompetencia = new ArrayList<PuntajeNecesario>();
	}

	public List<PuntajeNecesario> getPuntajeNecesarioPorCompetencia()
	{
		return puntajeNecesarioPorCompetencia;
	}

	public void setPuntajeNecesarioPorCompetencia(List<PuntajeNecesario> puntajeNecesarioPorCompetencia)
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

	public List<Competencia> getCompetencias()
	{
		return competencias;
	}

	public void setCompetencias(List<Competencia> competencias)
	{
		this.competencias = competencias;
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
