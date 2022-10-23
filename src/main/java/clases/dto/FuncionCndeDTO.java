package clases.dto;

public class FuncionCndeDTO
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private EmpresaDTO empresa;

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public EmpresaDTO getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa)
	{
		this.empresa = empresa;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
	
}
