package clases.dto;

import java.util.Objects;

public class FactorBasicoDTO
{
	private Integer id;
	private String nombre;

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

	@Override
	public String toString()
	{
		return nombre;
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
		FactorBasicoDTO other = (FactorBasicoDTO) obj;
		return Objects.equals(id, other.id);
	}

}
