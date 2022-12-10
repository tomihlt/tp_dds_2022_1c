package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.OpcionDeRespuestaDAO;
import clases.dao.interfaces.PreguntaDAO;
import clases.dao.interfaces.RespuestaDAO;
import clases.entidades.OpcionDeRespuesta;
import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.Respuesta;

public class PostgresPregunta implements PreguntaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Pregunta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Pregunta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Pregunta find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pregunta t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Respuesta> findRespuestas(Pregunta p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> findRespuestas(Pregunta p, boolean b) throws SQLException
	{
		if (!b)
			return findRespuestas(p);

		List<Respuesta> respuestas = new ArrayList<Respuesta>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT r.id,r.nombre,r.descripcion,r.orden_visualizacion,p.ponderacion FROM dds.respuesta r, dds.pregunta_respuesta p WHERE p.pregunta = p.respuesta AND p.pregunta = ?;"))
		{
			pstm.setInt(1, p.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				Respuesta r = new Respuesta();
				r.setId(rs.getInt(1));
				r.setNombre(rs.getString(2));
				r.setDescripcion(rs.getString(3));
				r.setOrdenVisualizacion(rs.getInt(4));
				Ponderacion pond = new Ponderacion();
				pond.setPregunta(p);
				pond.setPonderacion(rs.getInt(5));
				r.setPonderacion(pond);
				respuestas.add(r);
			}
		}

		return respuestas;
	}

	@Override
	public OpcionDeRespuesta findOpcionDeRespuesta(Pregunta pregunta) throws SQLException
	{
		OpcionDeRespuestaDAO dao = new PostgresOpcionDeRespuesta();
		RespuestaDAO rDao = new PostgresRespuesta();
		OpcionDeRespuesta op = null;

		try (PreparedStatement pstm = conn.prepareStatement(
				"select o.id,o.nombre,o.descripcion,o.eliminado from dds.opcion_de_respuesta o, dds.pregunta p where p.opcion_de_respuesta = o.id and p.id = ? and o.eliminado = false;"))
		{
			pstm.setInt(1, pregunta.getId());
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				op = new OpcionDeRespuesta();
				op.setId(rs.getInt(1));
				op.setNombre(rs.getString(2));
				op.setDescripcion(rs.getString(3));
				op.setEliminado(rs.getBoolean(4));
				List<Respuesta> rtas = dao.findRespuestas(op);
				for(Respuesta r : rtas)
				{
					Ponderacion pond = rDao.findPonderacion(pregunta,r);
					r.setPonderacion(pond);
				}
				op.setRespuestas(rtas);
			}
		}

		return op;
	}

	@Override
	public Pregunta find(Integer id, Boolean modificacion) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
