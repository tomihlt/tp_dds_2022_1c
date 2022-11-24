package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Consultor;

public interface ConsultorDAO extends CRUD<Consultor>
{
	public Consultor findConsultorByNombreUsuario(String nombre) throws SQLException;
}
