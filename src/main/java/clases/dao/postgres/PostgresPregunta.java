package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.PreguntaDAO;
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
	public List<Respuesta> findRespuestas(Pregunta p) throws SQLException
	{
		List<Respuesta> respuestas = new ArrayList<Respuesta>();
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT r.id, r.nombre,r.descripcion,r.orden_visualizacion FROM dds.respuesta r, dds.pregunta p, dds.opcion_de_respuesta op WHERE p.eliminado = false AND op.eliminado = false AND p.opcion_de_respuesta = op.id AND r.id_opcion = op.id AND p.id = ?;"))
		{
			pstm.setInt(1, p.getId());
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
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

	@Override
	public Ponderacion findPonderacion(Pregunta p, Respuesta r) throws SQLException
	{
		Ponderacion pond = new Ponderacion();
		
		try(PreparedStatement pstm = conn .prepareStatement("SELECT p.ponderacion FROM dds.pregunta_respuesta p WHERE p.pregunta = ? AND p.respuesta = ? AND p.eliminado = false;"))
		{
			pstm.setInt(1, p.getId());
			pstm.setInt(2, r.getId());
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				pond.setPregunta(p);
				pond.setRespuesta(r);
				pond.setPonderacion(rs.getInt(1));
			}
		}
		
		return pond;
	}

}
