package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Factor;
import clases.entidades.Pregunta;

public interface FactorDAO extends CRUD<Factor>
{

	List<Pregunta> findPreguntasByIdFactor(Integer id) throws SQLException;

	List<Pregunta> findPreguntasByFactor(List<Factor> factores) throws SQLException;
	
	List<Pregunta> findPreguntasByFactor(Factor factor) throws SQLException;

	List<Pregunta> findPreguntasByCodigoFactor(Integer codigo) throws SQLException;

}
