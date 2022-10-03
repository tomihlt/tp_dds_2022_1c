package clases.tablas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evaluacion
{
	private Integer id;
	private LocalDate fecha;
	private List<Cuestionario> cuestionarios;

	public Evaluacion()
	{
		cuestionarios = new ArrayList<Cuestionario>();
	}

	public List<Cuestionario> getCuestionarios()
	{
		return cuestionarios;
	}

	public void setCuestionarios(List<Cuestionario> cuestionarios)
	{
		this.cuestionarios = cuestionarios;
	}

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
