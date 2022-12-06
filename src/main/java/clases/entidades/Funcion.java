package clases.entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresFuncion;

public class Funcion
{
	private Integer id;
	private String nombre;
	private Integer codigo;
	private String descripcion;
	private Boolean eliminado;
	private Empresa empresa;
	private List<PuntajeNecesario> puntajeNecesarioPorCompetencia;
	private FuncionDAO dao = new PostgresFuncion();
	private Boolean puntajesCargados;

	public Funcion()
	{
		puntajeNecesarioPorCompetencia = new ArrayList<PuntajeNecesario>();
		eliminado = false;
		puntajesCargados = false;
	}

	public Boolean getEliminado()
	{
		return eliminado;
	}

	public void setEliminado(Boolean eliminado)
	{
		this.eliminado = eliminado;
	}

	public List<PuntajeNecesario> getPuntajeNecesarioPorCompetencia() throws SQLException
	{
		if(puntajesCargados)
			return puntajeNecesarioPorCompetencia;
		else
		{
			puntajeNecesarioPorCompetencia = dao.findPuntajes(this);
			puntajesCargados = true;
			return puntajeNecesarioPorCompetencia;
		}
	}

	public void setPuntajeNecesarioPorCompetencia(List<PuntajeNecesario> puntajeNecesarioPorCompetencia)
	{
		this.puntajeNecesarioPorCompetencia = puntajeNecesarioPorCompetencia;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
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

	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public void addCompetencia(PuntajeNecesario p) // En el diagrama de clases figura tambien se pasa el puntaje como
													// parametro, es innecesario ya que el puntaje necesario esta en la
													// clase PuntajeNecesario
	{
		puntajeNecesarioPorCompetencia.add(p);
	}
}
