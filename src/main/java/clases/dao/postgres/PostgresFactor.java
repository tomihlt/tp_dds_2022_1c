package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.FactorDAO;
import clases.entidades.Factor;
import clases.entidades.Pregunta;

public class PostgresFactor implements FactorDAO
{
	
	private Connection conn = DBConnection.get();
	
	@Override
	public void save(Factor t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Factor t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Factor find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factor> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factor> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Factor t) throws SQLException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pregunta> findPreguntasByIdFactor(Integer id) throws SQLException
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT p.id,p.nombre,p.descripcion FROM dds.factor f, dds.pregunta p WHERE f.id = p.id_factor AND f.id = ?;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Pregunta p = null;
			while(rs.next())
			{
				p = new Pregunta();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				preguntas.add(p);
			}
		}
		
		return preguntas;
	}

}
