package clases.entidades;

import java.util.ArrayList;
import java.util.List;

public class FactorCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer codigo;
	private Integer nroOrden;
	private Integer puntajeObtenido;
	private List<PreguntaCuestionario> preguntas;

	public FactorCuestionario()
	{
		preguntas = new ArrayList<PreguntaCuestionario>();
	}

	public Integer getPuntajeObtenido()
	{
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Integer puntajeObtenido)
	{
		this.puntajeObtenido = puntajeObtenido;
	}

	public List<PreguntaCuestionario> getPreguntas()
	{
		return preguntas;
	}

	public void setPreguntas(List<PreguntaCuestionario> pregunta)
	{
		this.preguntas = pregunta;
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

	@Override
	public String toString()
	{
		return "FactorCuestionario [nombre=" + nombre + "]";
	}

}
