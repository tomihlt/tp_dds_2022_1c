package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.ConsultorDAO;
import clases.entidades.Consultor;

public class PostgresConsultor implements ConsultorDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Consultor t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Consultor t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Consultor find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consultor> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consultor> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Consultor t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Consultor findByNombreUsuario(String nombre) throws SQLException
	{
		Consultor consultor = null;

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT u.id, u.nombre, u.apellido, c.usuario, c.contraseña FROM dds.usuario u, dds.consultor c WHERE c.id = u.id AND c.usuario = ?;"))
		{
			pstm.setString(1, nombre);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				consultor = new Consultor();
				consultor.setId(rs.getInt(1));
				consultor.setNombre(rs.getString(2));
				consultor.setApellido(rs.getString(3));
				consultor.setUsuario(rs.getString(4));
				consultor.setContraseña(rs.getString(5));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}

		return consultor;
	}

}
