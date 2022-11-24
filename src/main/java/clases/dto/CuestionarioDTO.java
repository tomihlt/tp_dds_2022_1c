package clases.dto;

import java.time.LocalDateTime;

import clases.enums.EstadoCuestionario;

public class CuestionarioDTO
{
	private Integer id;
	private LocalDateTime fechaFin;
	private EstadoCuestionario estado;
	private Long tiempoEmpleado;
	private Integer cantidadAccesos;
	private Integer cantidadAccesosMaxima;
	private String clave;

	public Integer getId()
	{
		return id;
	}

	public LocalDateTime getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public Long getTiempoEmpleado()
	{
		return tiempoEmpleado;
	}

	public void setTiempoEmpleado(Long tiempoEmpleado)
	{
		this.tiempoEmpleado = tiempoEmpleado;
	}

	public Integer getCantidadAccesos()
	{
		return cantidadAccesos;
	}

	public void setCantidadAccesos(Integer cantidadAccesos)
	{
		this.cantidadAccesos = cantidadAccesos;
	}

	public Integer getCantidadAccesosMaxima()
	{
		return cantidadAccesosMaxima;
	}

	public void setCantidadAccesosMaxima(Integer cantidadAccesosMaxima)
	{
		this.cantidadAccesosMaxima = cantidadAccesosMaxima;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
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

}
