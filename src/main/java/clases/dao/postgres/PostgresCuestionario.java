package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.CuestionarioDAO;
import clases.entidades.Bloque;
import clases.entidades.CompetenciaCuestionario;
import clases.entidades.Cuestionario;
import clases.entidades.Evaluacion;
import clases.entidades.FactorCuestionario;
import clases.entidades.PreguntaCuestionario;
import clases.entidades.RespuestaCuestionario;
import clases.enums.EstadoCuestionario;

public class PostgresCuestionario implements CuestionarioDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Cuestionario t, Evaluacion e) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.cuestionario (id_candidato, id_evaluacion, estado, fecha_inicio, fecha_fin, cantidad_accesos_maxima,cantidad_accesos, ultimo_ingreso,fecha_limite, tiempo_maximo, clave, puntaje_obtenido) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, t.getCandidato().getId());
			pstm.setInt(2, e.getId());
			pstm.setString(3, t.getEstado().toString());
			pstm.setTimestamp(4, Timestamp.valueOf(t.getFechaInicio()));
			pstm.setTimestamp(5, Timestamp.valueOf(t.getFechaFin()));
			pstm.setInt(6, t.getCantidadAccessosMaxima());
			pstm.setInt(7, t.getCantidadAccesos());
			pstm.setTimestamp(8, Timestamp.valueOf(t.getUltimoIngreso()));
			pstm.setTimestamp(9, Timestamp.valueOf(t.getFechaLimite()));
			pstm.setLong(10, t.getTiempoMaximo());
			pstm.setString(11, t.getClave());
			pstm.setInt(12, t.getPuntajeObtenido());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				t.setId(rs.getInt(1));
			saveCompetencias(t); // Guarda CompetenciaCuestionario, FactorCuestionario, PreguntaCuestionario y RespuestaCuestionario
			saveBloques(t); // Guarda los bloques y setea el id_bloque a las preguntas
		}
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
				"SELECT c.id, c.estado, c.fecha_inicio, c.fecha_fin, c.cantidad_accesos_maxima, c.cantidad_accesos, c.ultimo_ingreso, c.fecha_limite, c.tiempo_maximo, c.clave, c.puntaje_obtenido FROM dds.cuestionario c, dds.candidato cand WHERE c.id_candidato = cand.id AND cand.id = ?;"))
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
//				c.setTiempoEmpleado(rs.getBigDecimal(9).toBigInteger().longValue());
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
		if (string.equals("Activo"))
			return EstadoCuestionario.Activo;
		else if (string.equals("SinContestar"))
			return EstadoCuestionario.SinContestar;
		else if (string.equals("EnProceso"))
			return EstadoCuestionario.EnProceso;
		else
			return EstadoCuestionario.Completo;
	}

	@Override
	public void save(Cuestionario t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCompetencias(Cuestionario t) throws SQLException
	{
		List<CompetenciaCuestionario> competencias = t.getCompetencias();

		for (CompetenciaCuestionario c : competencias)
		{
			saveCompetencia(c, t);
		}

	}

	@Override
	public void saveCompetencia(CompetenciaCuestionario t, Cuestionario c) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.competencia_cuestionario (id_cuestionario, nombre,descripcion,puntaje_necesario,codigo,puntaje_obtenido) VALUES (?,?,?,?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, c.getId());
			pstm.setString(2, t.getNombre());
			pstm.setString(3, t.getDescripcion());
			pstm.setInt(4, t.getPuntajeNecesario());
			pstm.setInt(5, t.getCodigo());
			pstm.setInt(6, t.getPuntajeObtenido());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				t.setId(rs.getInt(1));
			saveFactoresCompetencia(t.getFactores(), t);
		}
	}

	private void saveFactoresCompetencia(List<FactorCuestionario> factores, CompetenciaCuestionario t)
			throws SQLException
	{
		// TODO
		for (FactorCuestionario f : factores)
		{
			saveFactoresCompetencia(f, t);
		}
	}

	private void saveFactoresCompetencia(FactorCuestionario f, CompetenciaCuestionario t) throws SQLException
	{
		// TODO Auto-generated method stub

		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.factor_cuestionario (id_competencia,nombre,descripcion,codigo,nro_orden,puntaje_obtenido) VALUES (?,?,?,?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, t.getId());
			pstm.setString(2, f.getNombre());
			pstm.setString(3, f.getDescripcion());
			pstm.setInt(4, f.getCodigo());
			pstm.setInt(5, f.getNroOrden());
			pstm.setInt(6, t.getPuntajeObtenido());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
			{
				f.setId(rs.getInt(1));
			}
			savePreguntas(f.getPreguntas(), f);
		}

	}

	private void saveBloques(Cuestionario t) throws SQLException
	{
		// TODO
		List<Bloque> bloques = t.getBloques();

		for (Bloque b : bloques)
			saveBloque(b, t);

	}

	private void saveBloque(Bloque b, Cuestionario t) throws SQLException
	{
		// TODO Auto-generated method stub

		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.bloque (id_cuestionario,numero,visitable) VALUES (?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, t.getId());
			pstm.setInt(2, b.getNumeroBloque());
			pstm.setBoolean(3, b.getVisitable());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				b.setId(rs.getInt(1));
			setIdBloquePreguntas(b.getPreguntas(), b);
		}

	}

	private void setIdBloquePreguntas(List<PreguntaCuestionario> preguntas, Bloque b) throws SQLException
	{
		// TODO Auto-generated method stub
		for(PreguntaCuestionario p : preguntas)
		{
			setIdBloquePregunta(p,b);
		}
	}

	private void setIdBloquePregunta(PreguntaCuestionario p, Bloque b) throws SQLException
	{
		// TODO Auto-generated method stub
		try(PreparedStatement pstm = conn.prepareStatement("UPDATE dds.pregunta_cuestionario SET id_bloque = ? WHERE id = ?;"))
		{
			pstm.setInt(1, b.getId());
			pstm.setInt(2, p.getId());
			pstm.executeUpdate();
		}
	}

	private void savePreguntas(List<PreguntaCuestionario> preguntas, FactorCuestionario f) throws SQLException
	{
		// TODO Auto-generated method stub
		for (PreguntaCuestionario p : preguntas)
		{
			savePregunta(p, f);
		}
	}

	private void savePregunta(PreguntaCuestionario p, FactorCuestionario f) throws SQLException
	{
		// TODO Auto-generated method stub
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.pregunta_cuestionario (id_factor,nombre,descripcion,nro_orden) VALUES (?,?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, f.getId());
			pstm.setString(2, p.getNombre());
			pstm.setString(3, p.getDescripcion());
			pstm.setInt(4, p.getNroOrden());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next())
				p.setId(rs.getInt(1));
			saveRespuestas(p.getRespuestas(), p);
		}
	}

	private void saveRespuestas(List<RespuestaCuestionario> respuestas, PreguntaCuestionario p) throws SQLException
	{
		// TODO Auto-generated method stub
		for (RespuestaCuestionario r : respuestas)
		{
			saveRespuesta(r, p);
		}
	}

	private void saveRespuesta(RespuestaCuestionario r, PreguntaCuestionario p) throws SQLException
	{
		// TODO Auto-generated method stub
		try (PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO dds.respuesta_cuestionario (id_pregunta,nombre,seleccionada,ponderacion,descripcion,orden_visualizacion) VALUES (?,?,?,?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS))
		{
			pstm.setInt(1, p.getId());
			pstm.setString(2, r.getNombre());
			pstm.setBoolean(3, r.getSeleccionada());
			pstm.setInt(4, r.getPonderacion());
			pstm.setString(5, r.getDescripcion());
			pstm.setInt(6, r.getOrdenVisualizacion());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			if(rs.next())
				r.setId(rs.getInt(1));
		}
	}

}
