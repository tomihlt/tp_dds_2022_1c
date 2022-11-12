package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.EvaluacionDAO;
import clases.entidades.Evaluacion;
import clases.entidades.Funcion;

public class PostgresEvaluacion implements EvaluacionDAO
{
	
	private Connection conn = DBConnection.get();

	@Override
	public void save(Evaluacion t)
	{
		// TODO Auto-generated method stub
		
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
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT id,fecha FROM dds.evaluacion WHERE id_funcion = ?"))
		{
			pstm.setInt(1, f.getId());
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				evaluacion = new Evaluacion();
				evaluacion.setId(rs.getInt(1));
				evaluacion.setFecha(rs.getDate(3).toLocalDate());
				evaluaciones.add(evaluacion);
			}
		}catch(SQLException e)
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


}
