package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.CuestionarioDAO;
import clases.entidades.Cuestionario;
import clases.enums.EstadoCuestionario;

public class PostgresCuestionario implements CuestionarioDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Cuestionario t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Cuestionario t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Cuestionario find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuestionario> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuestionario> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cuestionario t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Cuestionario findByIdCandidato(Integer id) throws SQLException
	{
		Cuestionario c = null;

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT c.id, c.estado, c.fecha_inicio, c.fecha_fin, c.cantidad_accesos_maxima, c.cantidad_accesos, c.ultimo_ingreso, c.fecha_limite, c.tiempo_empleado, c.tiempo_maximo, c.clave, c.puntaje_obtenido FROM dds.cuestionario c, dds.candidato cand WHERE c.id_candidato = cand.id AND cand.id = ?;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				c = new Cuestionario();
				c.setId(rs.getInt(1));
				c.setEstado(estadoDelCuestionario(rs.getString(2)));
				c.setFechaInicio(rs.getTimestamp(3).toLocalDateTime());
				c.setFechaFin(rs.getTimestamp(4).toLocalDateTime());
				c.setCantidadAccessosMaxima(rs.getInt(5));
				c.setCantidadAccesos(rs.getInt(6));
				c.setUltimoIngreso(rs.getTimestamp(7).toLocalDateTime());
				c.setFechaLimite(rs.getTimestamp(8).toLocalDateTime());
				c.setTiempoEmpleado(rs.getBigDecimal(9).toBigInteger().longValue());
				c.setTiempoMaximo(rs.getBigDecimal(10).toBigInteger().longValue());
				c.setClave(rs.getString(11));
				c.setPuntajeObtenido(rs.getInt(12));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}

		return c;
	}

	private EstadoCuestionario estadoDelCuestionario(String string)
	{
		if(string.equals("Activo"))
			return EstadoCuestionario.Activo;
		else if(string.equals("SinContestar"))
			return EstadoCuestionario.SinContestar;
		else if(string.equals("EnProceso"))
			return EstadoCuestionario.EnProceso;
		else
			return EstadoCuestionario.Completo;
	}

}
