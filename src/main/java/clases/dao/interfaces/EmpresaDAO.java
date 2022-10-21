package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Empresa;

public interface EmpresaDAO extends CRUD<Empresa>
{
	public Empresa findByName(String name) throws SQLException;
}
