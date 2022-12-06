package clases.entidades;

import java.util.ArrayList;
import java.util.List;

public class PreguntaCuestionario
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private FactorCuestionario factor;
	private Integer nroOrden; // Lo setea el creador de Bloque
	private List<RespuestaCuestionario> respuestas;

	public PreguntaCuestionario()
	{
		respuestas = new ArrayList<RespuestaCuestionario>();
	}

	public List<RespuestaCuestionario> getRespuestas()
	{
		return respuestas;
	}

	public void setRespuestas(List<RespuestaCuestionario> respuestas)
	{
		this.respuestas = respuestas;
	}

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

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public Integer getNroOrden()
	{
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden)
	{
		this.nroOrden = nroOrden;
	}

	public FactorCuestionario getFactor()
	{
		return factor;
	}

	public void setFactor(FactorCuestionario factor)
	{
		this.factor = factor;
	}

}
