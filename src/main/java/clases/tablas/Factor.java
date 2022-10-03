package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class Factor
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer codigo;
	private Integer nroOrden;
	private Competencia competencia;
	private List<Pregunta> preguntas;

	public Factor()
	{
		preguntas = new ArrayList<Pregunta>();
	}

	public Competencia getCompetencia()
	{
		return competencia;
	}

	public void setCompetencia(Competencia competencia)
	{
		this.competencia = competencia;
	}

	public List<Pregunta> getPreguntas()
	{
		return preguntas;
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

}
