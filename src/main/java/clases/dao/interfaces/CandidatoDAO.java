package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Candidato;

public interface CandidatoDAO extends CRUD<Candidato>
{
	public Candidato findCandidatoByDni(Integer dni) throws SQLException;
}
