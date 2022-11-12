package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Funcion;

public interface FuncionDAO extends CRUD<Funcion>
{

	public List<Funcion> findByFilters(Integer codigo, String nombre, String empresa) throws SQLException;

	public void setEmpresa(Funcion f) throws SQLException;

	public Funcion findByCodigo(Integer codigo) throws SQLException;

}
