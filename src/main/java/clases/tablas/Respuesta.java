package clases.tablas;

public class Respuesta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer ordenVisualizacion;
	private OpcionDeRespuesta opcionDeRespuesta;

	public OpcionDeRespuesta getOpcionDeRespuesta()
	{
		return opcionDeRespuesta;
	}

	public void setOpcionDeRespuesta(OpcionDeRespuesta opcionDeRespuesta)
	{
		this.opcionDeRespuesta = opcionDeRespuesta;
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

	public Integer getOrdenVisualizacion()
	{
		return ordenVisualizacion;
	}

	public void setOrdenVisualizacion(Integer ordenVisualizacion)
	{
		this.ordenVisualizacion = ordenVisualizacion;
	}

}
