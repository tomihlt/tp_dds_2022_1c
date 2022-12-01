package clases.entidades;

public class Pregunta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Factor factor;
	private Boolean eliminado;
	private OpcionDeRespuesta opcionDeRespuesta;

	public Factor getFactor()
	{
		return factor;
	}

	public void setFactor(Factor factor)
	{
		this.factor = factor;
	}

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

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

}
