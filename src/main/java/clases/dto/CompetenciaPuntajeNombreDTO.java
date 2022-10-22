package clases.dto;

public class CompetenciaPuntajeNombreDTO
{
	private Integer id;
	private String nombre;
	private Integer ponderacion;

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getPonderacion()
	{
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion)
	{
		this.ponderacion = ponderacion;
	}

	@Override
	public String toString()
	{
		return nombre + ", " + ponderacion.toString();
	}

}
