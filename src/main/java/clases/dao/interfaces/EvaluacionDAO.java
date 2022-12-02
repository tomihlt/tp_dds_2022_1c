package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Cuestionario;
import clases.entidades.Evaluacion;
import clases.entidades.Funcion;

public interface EvaluacionDAO extends CRUD<Evaluacion>
{

	public List<Evaluacion> findEvaluacionesByFuncion(Funcion f) throws SQLException;
	
	public void saveCuestionarios(List<Cuestionario> cuestionarios, Evaluacion e) throws SQLException;
	
}
