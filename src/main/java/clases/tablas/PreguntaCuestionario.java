package clases.tablas;

public class PreguntaCuestionario
{
	private Integer id;
	private String nombre;
	private String pregunta;
	private String descripcion;
	// TODO atributos del mapeo

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

	public String getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(String pregunta)
	{
		this.pregunta = pregunta;
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
