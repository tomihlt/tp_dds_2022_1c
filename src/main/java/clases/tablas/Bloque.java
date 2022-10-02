package clases.tablas;

public class Bloque
{
	private Integer id;
	private Integer numeroBloque;
	private Boolean visitable;
	//TODO atributos del mapeo

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getNumeroBloque()
	{
		return numeroBloque;
	}

	public void setNumeroBloque(Integer numeroBloque)
	{
		this.numeroBloque = numeroBloque;
	}

	public Boolean getVisitable()
	{
		return visitable;
	}

	public void setVisitable(Boolean visitable)
	{
		this.visitable = visitable;
	}

}
