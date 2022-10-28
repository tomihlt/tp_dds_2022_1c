package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.dao.DBConnection;
import clases.dao.interfaces.CompetenciaDAO;
import clases.entidades.Competencia;

public class PostgresCompetencia implements CompetenciaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Competencia t) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.competencia (nombre,codigo,descripcion,eliminado) VALUES (?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setString(1, t.getNombre());
			pstm.setInt(2, t.getCodigo());
			pstm.setString(3, t.getDescripcion());
			pstm.setBoolean(4, t.getEliminado());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				t.setId(rs.getInt(1));
		} catch (SQLException e)
		{
			throw e;
		}
	}

	@Override
	public void remove(Competencia t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Competencia find(Integer id) throws SQLException
	{
		Competencia comp = new Competencia();

		try (PreparedStatement pstm = conn
				.prepareStatement("SELECT id,nombre,codigo,descripcion,eliminado FROM dds.competencia WHERE id = ?"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				comp.setId(rs.getInt(1));
				comp.setNombre(rs.getString(2));
				comp.setCodigo(rs.getInt(3));
				comp.setDescripcion(rs.getString(4));
				comp.setEliminado(rs.getBoolean(5));
			}
		} catch (SQLException e)
		{
			throw e;
		}
		
		return comp;
	}

	@Override
	public List<Competencia> getAll() throws SQLException
	{
		List<Competencia> resultados = new ArrayList<Competencia>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT id,nombre,codigo,descripcion,eliminado FROM dds.competencia WHERE eliminado = false"))
		{
			ResultSet rs = pstm.executeQuery();
			Competencia c;
			while (rs.next())
			{
				c = new Competencia();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCodigo(rs.getInt(3));
				c.setDescripcion(rs.getString(4));
				c.setEliminado(rs.getBoolean(5));
				resultados.add(c);
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return resultados;
	}

	@Override
	public List<Competencia> findByName(List<String> names) throws SQLException
	{
		List<Competencia> result = new ArrayList<Competencia>();

		for (String nombre : names)
		{
			try
			{
				result.add(findByName(nombre));
			} catch (SQLException e)
			{
				throw e;
			}
		}

		return result;
	}

	@Override
	public Competencia findByName(String name) throws SQLException
	{
		Competencia c = new Competencia();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT id,nombre,codigo,eliminado,descripcion FROM dds.competencia WHERE nombre = ?"))
		{
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCodigo(rs.getInt(3));
				c.setEliminado(rs.getBoolean(4));
				c.setDescripcion(rs.getString(5));
			}

		} catch (SQLException e)
		{
			throw e;
		}

		return c;

	}

	@Override
	public List<Competencia> find(List<Integer> id) throws SQLException
	{
		List<Competencia> comp = new ArrayList<Competencia>();
		
		try
		{
			for(Integer i : id)
			{
				comp.add(find(i));
			}
		}catch(SQLException e)
		{
			throw e;
		}
		
		return comp;
	}

}
