package clases.entidades;

import java.sql.SQLException;
import java.time.LocalDate;

import clases.dao.interfaces.CandidatoDAO;
import clases.dao.postgres.PostgresCandidato;
import clases.enums.TipoDNI;

public class Candidato extends Usuario
{
	private Integer numeroCandidato;
	private TipoDNI tipoDni;
	private Integer dni;
	private LocalDate fechaNacimiento;
	private String email;
	// private Escolaridad escolaridad;
	private Boolean eliminado;
	private String nacionalidad;
	private Cuestionario cuestionario;
	private CandidatoDAO dao = new PostgresCandidato();
	private Boolean cuestionarioCargado;
	
	public Candidato()
	{
		cuestionarioCargado = false;
	}
	
	public Candidato(Boolean b)
	{
		this();
		cuestionarioCargado = b;
	}
	
	public Cuestionario getCuestionario() throws SQLException
	{
		if(cuestionarioCargado)
			return cuestionario;
		else
		{
			cuestionario = dao.findCuestionario(this);
			cuestionarioCargado = true;
			return cuestionario;
		}
	}

	public void setCuestionario(Cuestionario cuestionario)
	{
		this.cuestionario = cuestionario;
	}

	public Integer getNumeroCandidato()
	{
		return numeroCandidato;
	}

	public void setNumeroCandidato(Integer numeroCandidato)
	{
		this.numeroCandidato = numeroCandidato;
	}

	public TipoDNI getTipoDni()
	{
		return tipoDni;
	}

	public void setTipoDni(TipoDNI tipoDni)
	{
		this.tipoDni = tipoDni;
	}

	public Integer getDni()
	{
		return dni;
	}

	public void setDni(Integer dni)
	{
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

	public String getNacionalidad()
	{
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}

}
