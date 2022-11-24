package clases.entidades;

import java.util.ArrayList;
import java.util.List;

public class OpcionDeRespuesta
{
	private Integer id;
	private String nombre;
	private String descripcion;
	private List<Respuesta> respuestas;

	public OpcionDeRespuesta()
	{
		respuestas = new ArrayList<Respuesta>();
	}

	public List<Respuesta> getRespuestas()
	{
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas)
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

}
