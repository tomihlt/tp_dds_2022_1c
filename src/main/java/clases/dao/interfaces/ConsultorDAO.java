package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Consultor;

public interface ConsultorDAO extends CRUD<Consultor>
{
	public Consultor findByNombreUsuario(String nombre) throws SQLException;
}
