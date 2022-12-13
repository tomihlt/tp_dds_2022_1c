package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Competencia;
import clases.entidades.Empresa;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public interface FuncionDAO extends CRUD<Funcion>
{

	public List<Funcion> findByFilters(Integer codigo, String nombre, String empresa) throws SQLException;

	public Empresa getEmpresa(Funcion f) throws SQLException;
	
	public List<PuntajeNecesario> findPuntajes(Funcion f) throws SQLException; // La instancia tiene los atributos de las relaciones
	
	public void updateFuncionConPuntajesYEmpresa(Funcion f) throws SQLException;
	
	public void updateEmpresa(Funcion f) throws SQLException;
	
	public void removePuntajes(Funcion f) throws SQLException;
	
	public List<Funcion> findFuncionesByIdEmpresa(Integer id) throws SQLException;

	public PuntajeNecesario findPuntaje(Funcion f, Competencia c) throws SQLException;

	public Funcion findByCodigo(Integer codigo, boolean puntajes, boolean empresa) throws SQLException;

	Funcion find(Integer id, boolean puntajes, boolean empresa) throws SQLException;

}
