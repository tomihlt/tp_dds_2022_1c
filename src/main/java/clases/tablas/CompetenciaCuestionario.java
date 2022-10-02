package clases.tablas;

public class CompetenciaCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer ponderacion;
	private Integer codigo;

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
