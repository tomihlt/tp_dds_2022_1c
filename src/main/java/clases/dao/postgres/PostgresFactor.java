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
	public Factor find(Integer id) throws SQLException
	{
		Factor f = new Factor();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT id, nombre, descripcion, codigo, nro_orden, eliminado FROM dds.factor WHERE eliminado = false AND id = ?;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				f.setId(rs.getInt(1));
				f.setNombre(rs.getString(2));
				f.setDescripcion(rs.getString(3));
				f.setCodigo(rs.getInt(4));
				f.setNroOrden(rs.getInt(5));
				f.setEliminado(rs.getBoolean(6));
			}
		}

		return f;
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

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT p.id,p.nombre,p.descripcion,p.eliminado FROM dds.factor f, dds.pregunta p WHERE f.id = p.id_factor AND f.id = ? AND f.eliminado = false AND p.eliminado = false;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Pregunta p = null;
			while (rs.next())
			{
				p = new Pregunta();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setEliminado(rs.getBoolean(4));
				preguntas.add(p);
			}
		}

		return preguntas;
	}

	@Override
	public List<Pregunta> findPreguntasByFactor(List<Factor> factores) throws SQLException
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		for(Factor f : factores)
		{
			preguntas.addAll(findPreguntasByFactor(f));
		}
		
		return preguntas;
	}

	@Override
	public List<Pregunta> findPreguntasByFactor(Factor factor) throws SQLException
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT p.id,p.nombre,p.descripcion, p.eliminado FROM dds.pregunta p, dds.factor f WHERE f.id = p.id_factor AND f.id = ? AND f.eliminado = false AND p.eliminado = false;"))
		{
			pstm.setInt(1, factor.getId());
			Pregunta p = null;
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				p = new Pregunta();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setEliminado(rs.getBoolean(4));
				preguntas.add(p);
			}
		}

		return preguntas;
	}

	@Override
	public List<Pregunta> findPreguntasByCodigoFactor(Integer codigo) throws SQLException
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT p.id,p.nombre,p.descripcion, p.eliminado FROM dds.pregunta p, dds.factor f WHERE f.id = p.id_factor AND f.codigo = ? AND f.eliminado = false AND p.eliminado = false;"))
		{
			pstm.setInt(1, codigo);
			Pregunta p = null;
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				p = new Pregunta();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setEliminado(rs.getBoolean(4));
				preguntas.add(p);
			}
		}

		return preguntas;
	}

	@Override
	public Integer getCantidadPreguntas(Factor f) throws SQLException
	{
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT count(p.id) FROM dds.factor f, dds.pregunta p WHERE p.id_factor = ?;"))
		{
			pstm.setInt(1, f.getId());
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		}
		
		return null;
	}

}
