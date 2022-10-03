package clases.tablas;

public class PuntajeNecesario
{
	private Integer puntaje;
	private Funcion funcion;
	private Competencia competencia;

	public Funcion getFuncion()
	{
		return funcion;
	}

	public void setFuncion(Funcion funcion)
	{
		this.funcion = funcion;
	}

	public Competencia getCompetencia()
	{
		return competencia;
	}

	public void setCompetencia(Competencia competencia)
	{
		this.competencia = competencia;
	}

	public Integer getPuntaje()
	{
		return puntaje;
	}

	public void setPuntaje(Integer puntaje)
	{
		this.puntaje = puntaje;
	}

}
