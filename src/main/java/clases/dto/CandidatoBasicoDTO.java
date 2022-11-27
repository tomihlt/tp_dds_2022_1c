package clases.dto;

public class CandidatoBasicoDTO
{
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer numeroDeCandidato;

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

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public Integer getNumeroDeCandidato()
	{
		return numeroDeCandidato;
	}

	public void setNumeroDeCandidato(Integer numeroDeCandidato)
	{
		this.numeroDeCandidato = numeroDeCandidato;
	}

}
