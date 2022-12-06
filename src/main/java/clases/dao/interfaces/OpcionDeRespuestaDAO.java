package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.OpcionDeRespuesta;
import clases.entidades.Respuesta;

public interface OpcionDeRespuestaDAO extends CRUD<OpcionDeRespuesta>
{

	List<Respuesta> findRespuestas(OpcionDeRespuesta opcionDeRespuesta) throws SQLException;

}
