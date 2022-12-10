package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.RespuestaDAO;
import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.Respuesta;

public class PostgresRespuesta implements RespuestaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Respuesta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Respuesta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Respuesta find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Respuesta t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Ponderacion findPonderacion(Pregunta pregunta, Respuesta r) throws SQLException
	{
		Ponderacion pond = new Ponderacion();

		try (PreparedStatement pstm = conn.prepareStatement(
				"select p.ponderacion from dds.pregunta_respuesta p where p.pregunta = ? and p.respuesta = ?;"))
		{
			pstm.setInt(1, pregunta.getId());
			pstm.setInt(2, r.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				pond.setPregunta(pregunta);
				pond.setPonderacion(rs.getInt(1));
			}
		}

		return pond;
	}

	@Override
	public Respuesta find(Integer id, Boolean modificacion) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
