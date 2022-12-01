package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.Respuesta;

public interface PreguntaDAO extends CRUD<Pregunta>
{

	List<Respuesta> findRespuestas(Pregunta p) throws SQLException;

	Ponderacion findPonderacion(Pregunta p, Respuesta r) throws SQLException;

}
