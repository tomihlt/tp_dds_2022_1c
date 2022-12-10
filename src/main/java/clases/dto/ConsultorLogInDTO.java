package clases.dto;

public class ConsultorLogInDTO
{
	private Integer id;
	private String usuario;
	private char[] pw;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public char[] getPw()
	{
		return pw;
	}

	public void setPw(char[] pw)
	{
		this.pw = pw;
	}

}
