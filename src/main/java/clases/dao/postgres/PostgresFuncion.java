package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.FuncionDAO;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public class PostgresFuncion implements FuncionDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void add(Funcion t) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.funcion (id_empresa,nombre,codigo,descripcion,eliminado) VALUES (?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			conn.setAutoCommit(false);
			pstm.setInt(1, t.getEmpresa().getId());
			pstm.setString(2, t.getNombre());
			pstm.setInt(3, t.getCodigo());
			pstm.setString(4, t.getDescripcion());
			pstm.setBoolean(5, t.getEliminado());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				t.setId(rs.getInt(1));

			addPuntajeCompetencia(t.getPuntajeNecesarioPorCompetencia());
			conn.commit();
		} catch (SQLException e)
		{
			conn.rollback();
			throw e;
		} finally
		{
			conn.setAutoCommit(true);
		}
	}

	private void addPuntajeCompetencia(List<PuntajeNecesario> puntajeNecesarioPorCompetencia) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.funcion_competencias (funcion,competencia,puntaje_necesario) VALUES (?,?,?)"))
		{
			for (PuntajeNecesario p : puntajeNecesarioPorCompetencia)
			{
				pstm.setInt(1, p.getFuncion().getId());
				pstm.setInt(2, p.getCompetencia().getId());
				pstm.setInt(3, p.getPuntaje());
				pstm.executeUpdate();
			}
		} catch (SQLException e)
		{
			throw e;
		}
	}

	@Override
	public void remove(Funcion t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Funcion find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcion> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcion> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
