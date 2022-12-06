package clases.dao.interfaces;

import java.sql.SQLException;

import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.Respuesta;

public interface RespuestaDAO extends CRUD<Respuesta>
{

	Ponderacion findPonderacion(Pregunta pregunta, Respuesta r) throws SQLException;

}
