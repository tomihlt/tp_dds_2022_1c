package clases.dto;

import java.time.LocalDate;

import clases.enums.TipoDNI;

public class CandidatoDTO
{
	private Integer id;
	private String apellido;
	private String nombre;
	private Integer numeroCandidato;
	private String nacionalidad;
	private Boolean eliminado;
	private String email;
	private LocalDate fechaNacimiento;
	private Integer dni;
	private TipoDNI tipoDni;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getNumeroCandidato()
	{
		return numeroCandidato;
	}

	public void setNumeroCandidato(Integer nro_candidato)
	{
		this.numeroCandidato = nro_candidato;
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

	public String getNacionalidad()
	{
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDni()
	{
		return dni;
	}

	public void setDni(Integer dni)
	{
		this.dni = dni;
	}

	public TipoDNI getTipoDni()
	{
		return tipoDni;
	}

	public void setTipoDni(TipoDNI tipoDni)
	{
		this.tipoDni = tipoDni;
	}

}
