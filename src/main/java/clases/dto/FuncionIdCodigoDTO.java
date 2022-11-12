package clases.dto;

public class FuncionIdCodigoDTO
{

	private Integer id;
	private Integer codigo;

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

	@Override
	public String toString()
	{
		return codigo.toString();
	}

}
