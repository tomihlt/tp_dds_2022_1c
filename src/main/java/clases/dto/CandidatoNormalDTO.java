package clases.dto;

import clases.enums.TipoDNI;

public class CandidatoNormalDTO
{
	private Integer id;
	private String apellido;
	private String nombre;
	private TipoDNI tipoDNI;
	private Integer dni;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public TipoDNI getTipoDNI()
	{
		return tipoDNI;
	}

	public void setTipoDNI(TipoDNI tipoDNI)
	{
		this.tipoDNI = tipoDNI;
	}

	public Integer getDni()
	{
		return dni;
	}

	public void setDni(Integer dni)
	{
		this.dni = dni;
	}

	@Override
	public String toString()
	{
		return apellido;
	}

}
