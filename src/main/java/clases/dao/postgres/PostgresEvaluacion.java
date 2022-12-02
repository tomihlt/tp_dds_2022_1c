package clases.dao.postgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.CuestionarioDAO;
import clases.dao.interfaces.EvaluacionDAO;
import clases.entidades.Cuestionario;
import clases.entidades.Evaluacion;
import clases.entidades.Funcion;
import clases.utiles.DateUtils;

public class PostgresEvaluacion implements EvaluacionDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Evaluacion t) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.evaluacion (id_funcion,fecha) VALUES (?,?);", PreparedStatement.RETURN_GENERATED_KEYS))
		{
			conn.setAutoCommit(false);
			pstm.setInt(1, t.getFuncion().getId());
			pstm.setDate(2, Date.valueOf(t.getFecha()));
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if(rs.next())
			{
				t.setId(rs.getInt(1));
			}
			saveCuestionarios(t.getCuestionarios(),t);
			conn.commit();
		}finally
		{
			conn.setAutoCommit(true);
		}
	}

	@Override
	public void remove(Evaluacion t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Evaluacion find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluacion> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluacion> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluacion> findEvaluacionesByFuncion(Funcion f) throws SQLException
	{
		List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		Evaluacion evaluacion;

		try (PreparedStatement pstm = conn.prepareStatement("SELECT id,fecha FROM dds.evaluacion WHERE id_funcion = ?"))
		{
			pstm.setInt(1, f.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				evaluacion = new Evaluacion();
				evaluacion.setId(rs.getInt(1));
				evaluacion.setFecha(rs.getDate(2).toLocalDate());
				evaluaciones.add(evaluacion);
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return evaluaciones;

	}

	@Override
	public void update(Evaluacion t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCuestionarios(List<Cuestionario> cuestionarios, Evaluacion e) throws SQLException
	{
		CuestionarioDAO dao = new PostgresCuestionario();
		
		for(Cuestionario c : cuestionarios)
			dao.save(c,e);
		
	}

}
