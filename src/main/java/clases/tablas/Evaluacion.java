package clases.tablas;

import java.time.LocalDate;

public class Evaluacion
{
	private Integer id;
	private LocalDate fecha;

	// TODO atributos del mapeo
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public LocalDate getFecha()
	{
		return fecha;
	}

	public void setFecha(LocalDate fecha)
	{
		this.fecha = fecha;
	}

}
