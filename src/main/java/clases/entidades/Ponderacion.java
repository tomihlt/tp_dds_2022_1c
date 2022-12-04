package clases.entidades;

public class Ponderacion
{
	private Integer ponderacion;
	private Pregunta pregunta;

	public Pregunta getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta)
	{
		this.pregunta = pregunta;
	}

	public Integer getPonderacion()
	{
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion)
	{
		this.ponderacion = ponderacion;
	}

}
