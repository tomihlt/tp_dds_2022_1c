package clases.entidades;

public class Ponderacion
{
	private Integer ponderacion;
	private Pregunta pregunta;
	private Respuesta respuesta;

	public Pregunta getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta)
	{
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta()
	{
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta)
	{
		this.respuesta = respuesta;
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
