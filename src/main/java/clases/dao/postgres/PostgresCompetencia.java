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
import clases.tablas.Competencia;

public class PostgresCompetencia implements CompetenciaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void add(Competencia t) throws SQLException
	{
		// TODO Auto-generated method stub
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.competencia (nombre,codigo,descripcion) VALUES (?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setString(1, t.getNombre());
			pstm.setInt(2, t.getCodigo());
			pstm.setString(3, t.getDescripcion());
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
	public Competencia find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competencia> getAll() throws SQLException
	{
		List<Competencia> resultados = new ArrayList<Competencia>();
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT id,nombre,codigo,descripcion from dds.competencia"))
		{
			ResultSet rs = pstm.executeQuery();
			Competencia c;
			while(rs.next())
			{
				c = new Competencia();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCodigo(rs.getInt(3));
				c.setDescripcion(rs.getString(4));
				resultados.add(c);
			}
		} catch (SQLException e)
		{
			throw e;
		}
		
		return resultados;
	}

}
