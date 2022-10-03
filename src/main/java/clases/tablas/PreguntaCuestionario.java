package clases.tablas;

import java.util.ArrayList;
import java.util.List;

public class PreguntaCuestionario
{
	private Integer id;
	private String nombre;
	private String pregunta;
	private String descripcion;
	private FactorCuestionario factor;
	private Bloque bloque;
	private List<RespuestaCuestionario> respuestas;

	public PreguntaCuestionario()
	{
		respuestas = new ArrayList<RespuestaCuestionario>();
	}

	public FactorCuestionario getFactor()
	{
		return factor;
	}

	public void setFactor(FactorCuestionario factor)
	{
		this.factor = factor;
	}

	public Bloque getBloque()
	{
		return bloque;
	}

	public void setBloque(Bloque bloque)
	{
		this.bloque = bloque;
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

	public String getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(String pregunta)
	{
		this.pregunta = pregunta;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

}
