package clases.entidades;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import clases.enums.EstadoCuestionario;

public class Cuestionario
{
	private Integer id;
	private EstadoCuestionario estado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Integer cantidadAccessosMaxima;
	private Integer cantidadAccesos;
	private LocalDateTime ultimoIngreso;
	private LocalDateTime fechaLimite;
	private Long tiempoEmpleado;
	private Long tiempoMaximo;
	private String clave;
	private Integer puntajeObtenido;
	private Candidato candidato;
	private List<Bloque> bloques;

	public Cuestionario()
	{
		bloques = new ArrayList<Bloque>();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public EstadoCuestionario getEstado()
	{
		return estado;
	}

	public void setEstado(EstadoCuestionario estado)
	{
		this.estado = estado;
	}

	public LocalDateTime getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public Integer getCantidadAccessosMaxima()
	{
		return cantidadAccessosMaxima;
	}

	public void setCantidadAccessosMaxima(Integer cantidadAccessosMaxima)
	{
		this.cantidadAccessosMaxima = cantidadAccessosMaxima;
	}

	public Integer getCantidadAccesos()
	{
		return cantidadAccesos;
	}

	public void setCantidadAccesos(Integer cantidadAccesos)
	{
		this.cantidadAccesos = cantidadAccesos;
	}

	public LocalDateTime getUltimoIngreso()
	{
		return ultimoIngreso;
	}

	public void setUltimoIngreso(LocalDateTime ultimoIngreso)
	{
		this.ultimoIngreso = ultimoIngreso;
	}

	public LocalDateTime getFechaLimite()
	{
		return fechaLimite;
	}

	public void setFechaLimite(LocalDateTime fechaLimite)
	{
		this.fechaLimite = fechaLimite;
	}

	public Long getTiempoEmpleado()
	{
		return tiempoEmpleado;
	}

	public void setTiempoEmpleado(Long tiempoEmpleado)
	{
		this.tiempoEmpleado = tiempoEmpleado;
	}

	public Long getTiempoMaximo()
	{
		return tiempoMaximo;
	}

	public void setTiempoMaximo(Long tiempoMaximo)
	{
		this.tiempoMaximo = tiempoMaximo;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public Integer getPuntajeObtenido()
	{
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Integer puntajeObtenido)
	{
		this.puntajeObtenido = puntajeObtenido;
	}

	public Candidato getCandidato()
	{
		return candidato;
	}

	public void setCandidato(Candidato candidato)
	{
		this.candidato = candidato;
	}

	public List<Bloque> getBloques()
	{
		return bloques;
	}

	public void setBloques(List<Bloque> bloques)
	{
		this.bloques = bloques;
	}

}
