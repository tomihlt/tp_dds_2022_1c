package clases.entidades;

import java.util.ArrayList;
import java.util.List;

public class CompetenciaCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer puntajeNecesario;
	private Integer codigo;
	private Integer puntajeObtenido;
	private List<FactorCuestionario> factores;

	public CompetenciaCuestionario()
	{
		factores = new ArrayList<FactorCuestionario>();
	}

	public Integer getPuntajeObtenido()
	{
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Integer puntajeObtenido)
	{
		this.puntajeObtenido = puntajeObtenido;
	}

	public List<FactorCuestionario> getFactores()
	{
		return factores;
	}

	public void setFactores(List<FactorCuestionario> factores)
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

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public Integer getPuntajeNecesario()
	{
		return puntajeNecesario;
	}

	public void setPuntajeNecesario(Integer puntajeNecesario)
	{
		this.puntajeNecesario = puntajeNecesario;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	@Override
	public String toString()
	{
		return "CompetenciaCuestionario [nombre=" + nombre + "]";
	}

}
