package clases.dto;

import java.util.Objects;

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

	@Override
	public String toString()
	{
		return numeroDeCandidato.toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatoBasicoDTO other = (CandidatoBasicoDTO) obj;
		return Objects.equals(id, other.id);
	}

}
