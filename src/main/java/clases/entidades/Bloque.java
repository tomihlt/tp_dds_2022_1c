package clases.entidades;

import java.util.ArrayList;
import java.util.List;

public class Bloque
{
	private Integer id;
	private Integer numeroBloque;
	private Boolean visitable;
	private List<PreguntaCuestionario> preguntas;
	
	public Bloque()
	{
		preguntas = new ArrayList<PreguntaCuestionario>();
	}

	public List<PreguntaCuestionario> getPreguntas()
	{
		return preguntas;
	}

	public void setPreguntas(List<PreguntaCuestionario> preguntas)
	{
		this.preguntas = preguntas;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getNumeroBloque()
	{
		return numeroBloque;
	}

	public void setNumeroBloque(Integer numeroBloque)
	{
		this.numeroBloque = numeroBloque;
	}

	public Boolean getVisitable()
	{
		return visitable;
	}

	public void setVisitable(Boolean visitable)
	{
		this.visitable = visitable;
	}

}
