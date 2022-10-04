package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class CompetenciaCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer ponderacion;
	private Integer codigo;
	private Integer puntajeObtenido;
	private Cuestionario cuestionario;
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

	public Cuestionario getCuestionario()
	{
		return cuestionario;
	}

	public void setCuestionario(Cuestionario cuestionario)
	{
		this.cuestionario = cuestionario;
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

	public Integer getPonderacion()
	{
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion)
	{
		this.ponderacion = ponderacion;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

}
