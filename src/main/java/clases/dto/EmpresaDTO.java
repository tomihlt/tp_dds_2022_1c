package clases.dto;

import java.util.Objects;

public class EmpresaDTO
{
	private Integer id;
	private String nombre;

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

	@Override
	public String toString()
	{
		return nombre;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, nombre);
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
		EmpresaDTO other = (EmpresaDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

}
