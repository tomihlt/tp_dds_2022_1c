package clases.dao.interfaces;

import java.sql.SQLException;

import clases.tablas.Empresa;

public interface EmpresaDAO extends CRUD<Empresa>
{
	public Empresa findByName(String name) throws SQLException;
}
