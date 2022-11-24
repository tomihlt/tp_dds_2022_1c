package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Cuestionario;

public interface CuestionarioDAO extends CRUD<Cuestionario>
{

	public Cuestionario findByIdCandidato(Integer id) throws SQLException;

}
