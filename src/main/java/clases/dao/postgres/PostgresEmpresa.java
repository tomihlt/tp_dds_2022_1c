package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.EmpresaDAO;
import clases.entidades.Empresa;

public class PostgresEmpresa implements EmpresaDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void add(Empresa t) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement("INSERT INTO dds.empresa (nombre) VALUES (?)",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setString(1, t.getNombre());
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
	public void remove(Empresa t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Empresa find(Integer id) throws SQLException
	{
		Empresa empresa = new Empresa();
		try (PreparedStatement pstm = conn.prepareStatement("SELECT id,nombre FROM dds.empresa"))
		{
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				empresa.setId(rs.getInt(1));
				empresa.setNombre(rs.getString(2));
			}
		} catch (SQLException e)
		{
			throw e;
		}
		return empresa;
	}

	@Override
	public List<Empresa> getAll() throws SQLException
	{
		List<Empresa> results = new ArrayList<Empresa>();
		try (PreparedStatement pstm = conn.prepareStatement("SELECT id,nombre FROM dds.empresa"))
		{
			ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				Empresa e = new Empresa();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				results.add(e);
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return results;
	}

	@Override
	public Empresa findByName(String name) throws SQLException
	{
		Empresa emp = new Empresa();
		try (PreparedStatement pstm = conn.prepareStatement("SELECT id,nombre FROM dds.empresa WHERE nombre = ?"))
		{
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				emp.setId(rs.getInt(1));
				emp.setNombre(rs.getString(2));
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return emp;
	}

	@Override
	public List<Empresa> find(List<Integer> id) throws SQLException
	{
		List<Empresa> empresas = new ArrayList<Empresa>();

		try
		{

			for (Integer i : id)
				empresas.add(find(i));

		} catch (SQLException e)
		{
			throw e;
		}

		return empresas;
	}

}
