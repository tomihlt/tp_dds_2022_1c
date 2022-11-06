package clases.dto;

public class FuncionDTO
{

	private Integer id;
	private Integer codigo;
	private String nombre;
	private EmpresaDTO empresa;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public EmpresaDTO getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa)
	{
		this.empresa = empresa;
	}

}
