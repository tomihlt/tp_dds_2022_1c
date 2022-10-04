package clases.tablas;

public class FactorCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer codigo;
	private Integer nroOrden;
	private Integer puntajeObtenido;
	private CompetenciaCuestionario competencia;
	private PreguntaCuestionario pregunta; // TODO

	public CompetenciaCuestionario getCompetencia()
	{
		return competencia;
	}

	public Integer getPuntajeObtenido()
	{
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Integer puntajeObtenido)
	{
		this.puntajeObtenido = puntajeObtenido;
	}

	public void setCompetencia(CompetenciaCuestionario competencia)
	{
		this.competencia = competencia;
	}

	public PreguntaCuestionario getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(PreguntaCuestionario pregunta)
	{
		this.pregunta = pregunta;
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
