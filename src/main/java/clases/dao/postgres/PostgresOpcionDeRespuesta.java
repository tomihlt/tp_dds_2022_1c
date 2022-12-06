package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.OpcionDeRespuestaDAO;
import clases.entidades.OpcionDeRespuesta;
import clases.entidades.Respuesta;

public class PostgresOpcionDeRespuesta implements OpcionDeRespuestaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(OpcionDeRespuesta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(OpcionDeRespuesta t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public OpcionDeRespuesta find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpcionDeRespuesta> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpcionDeRespuesta> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OpcionDeRespuesta t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Respuesta> findRespuestas(OpcionDeRespuesta opcionDeRespuesta) throws SQLException
	{
		List<Respuesta> respuestas = new ArrayList<Respuesta>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"select r.id,r.nombre,r.descripcion,r.orden_visualizacion from dds.respuesta r, dds.opcion_de_respuesta o where r.id_opcion = o.id and o.id = ?;"))
		{
			pstm.setInt(1, opcionDeRespuesta.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				Respuesta r = new Respuesta();
				r.setId(rs.getInt(1));
				r.setNombre(rs.getString(2));
				r.setDescripcion(rs.getString(3));
				r.setOrdenVisualizacion(rs.getInt(4));
				respuestas.add(r);
			}
		}

		return respuestas;
	}

}
