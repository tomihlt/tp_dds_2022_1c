package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.Respuesta;

public interface PreguntaDAO extends CRUD<Pregunta>
{

	List<Respuesta> findRespuestas(Pregunta p);
	
	List<Respuesta> findRespuestas(Pregunta p, boolean b) throws SQLException;

}
