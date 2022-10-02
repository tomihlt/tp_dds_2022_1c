package clases.tablas;

import java.time.Instant;
import java.time.LocalDate;

import clases.enums.EstadoCuestionario;

public class Cuestionario
{
	private Integer id;
	private EstadoCuestionario estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer cantidadAccessosMaxima;
	private Integer cantidadAccesos;
	private LocalDate ultimoIngreso;
	private LocalDate fechaLimite;
	private Instant tiempoEmpleado;
	private Instant tiempoMaximo;
	private String clave;
	private Integer puntajeObtenido;
	// TODO atributos del mapeo

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

	public LocalDate getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin)
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

	public LocalDate getUltimoIngreso()
	{
		return ultimoIngreso;
	}

	public void setUltimoIngreso(LocalDate ultimoIngreso)
	{
		this.ultimoIngreso = ultimoIngreso;
	}

	public LocalDate getFechaLimite()
	{
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite)
	{
		this.fechaLimite = fechaLimite;
	}

	public Instant getTiempoEmpleado()
	{
		return tiempoEmpleado;
	}

	public void setTiempoEmpleado(Instant tiempoEmpleado)
	{
		this.tiempoEmpleado = tiempoEmpleado;
	}

	public Instant getTiempoMaximo()
	{
		return tiempoMaximo;
	}

	public void setTiempoMaximo(Instant tiempoMaximo)
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

}
