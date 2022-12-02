package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.CompetenciaCuestionario;
import clases.entidades.Cuestionario;
import clases.entidades.Evaluacion;

public interface CuestionarioDAO extends CRUD<Cuestionario>
{

	public Cuestionario findByIdCandidato(Integer id) throws SQLException;

	void save(Cuestionario t, Evaluacion e) throws SQLException;
	
	void saveCompetencias(Cuestionario t) throws SQLException;
	
	void saveCompetencia(CompetenciaCuestionario t, Cuestionario c) throws SQLException;
	
}
