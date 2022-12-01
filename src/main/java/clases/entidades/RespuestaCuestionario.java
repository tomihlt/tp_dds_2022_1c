package clases.entidades;

public class RespuestaCuestionario
{
	private Integer id;
	private String nombre; // La respuesta en si, cambiarla por respuesta despues
	private Boolean seleccionada;
	private Integer ponderacion;
	private String descripcion;

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

	public Boolean getSeleccionada()
	{
		return seleccionada;
	}

	public void setSeleccionada(Boolean seleccionada)
	{
		this.seleccionada = seleccionada;
	}

	public Integer getPonderacion()
	{
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion)
	{
		this.ponderacion = ponderacion;
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
