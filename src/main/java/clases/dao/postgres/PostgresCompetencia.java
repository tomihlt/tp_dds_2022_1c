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
import clases.dao.interfaces.FactorDAO;
import clases.entidades.Competencia;
import clases.entidades.Factor;
import clases.entidades.Pregunta;

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
			if (rs.next())
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
				"SELECT id,nombre,codigo,eliminado,descripcion FROM dds.competencia WHERE nombre = ? AND eliminado = false;"))
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
			for (Integer i : id)
			{
				comp.add(find(i));
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return comp;
	}

	@Override
	public void update(Competencia t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Factor> findFactoresByIdCompetencia(Integer id) throws SQLException
	{
		List<Factor> factores = new ArrayList<Factor>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT f.id,f.nombre,f.descripcion,f.codigo,f.nro_orden FROM dds.factor f, dds.competencia c WHERE f.id_competencia = c.id AND c.id = ? AND f.eliminado = false;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Factor f = null;
			while (rs.next())
			{
				f = new Factor();
				f.setId(rs.getInt(1));
				f.setNombre(rs.getString(2));
				f.setDescripcion(rs.getString(3));
				f.setCodigo(rs.getInt(4));
				f.setNroOrden(rs.getInt(5));
				factores.add(f);
			}
		}

		return factores;
	}

	@Override
	public List<Integer> getCantidadPreguntasPorFactor(Competencia aux) throws SQLException
	{
		List<Integer> cantidadDePreguntas = new ArrayList<Integer>();

		try (PreparedStatement pstm = conn.prepareStatement(
				"select count(p.id) as cant_preguntas from dds.competencia c, dds.factor f, dds.pregunta p where f.id_competencia = c.id and p.id_factor = f.id and c.id = ? group by c.id,f.id;"))
		{
			pstm.setInt(1, aux.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				cantidadDePreguntas.add(rs.getInt(1));
			}
		}

		return cantidadDePreguntas;
	}

	@Override
	public Competencia find(Integer id, boolean b) throws SQLException
	{
		if (!b)
			return find(id);

		List<Factor> factores = null;
		Competencia c = null;

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT c.id,c.nombre,c.codigo,c.eliminado,c.descripcion,f.id,f.nombre,f.descripcion,f.codigo,f.nro_orden,f.eliminado FROM dds.competencia c, dds.factor f WHERE f.id_competencia = c.id AND c.id = ? AND f.eliminado = false;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			c = new Competencia();
			factores = new ArrayList<Factor>();
			while (rs.next())
			{
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCodigo(rs.getInt(3));
				c.setEliminado(rs.getBoolean(4));
				c.setDescripcion(rs.getString(5));

				Factor f = new Factor();
				f.setId(rs.getInt(6));
				f.setNombre(rs.getString(7));
				f.setDescripcion(rs.getString(8));
				f.setCodigo(rs.getInt(9));
				f.setNroOrden(rs.getInt(10));
				f.setEliminado(rs.getBoolean(11));

				factores.add(f);
			}
			c.setFactores(factores);
		}

		return c;

	}

	@Override
	public Competencia find(Integer id, boolean b, boolean c) throws SQLException
	{

		if (!c)
			return find(id, b);

		Competencia comp = new Competencia();

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT id,nombre,codigo,eliminado,descripcion FROM dds.competencia WHERE id = ?;"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				comp.setId(rs.getInt(1));
				comp.setNombre(rs.getString(2));
				comp.setCodigo(rs.getInt(3));
				comp.setEliminado(rs.getBoolean(4));
				comp.setDescripcion(rs.getString(5));
				comp.setFactores(findFactoresByIdCompetencia(comp.getId()));
				for(Factor f : comp.getFactores())
				{
					FactorDAO dao = new PostgresFactor();
					List<Pregunta> preguntas = dao.findPreguntasByFactor(f);
					f.setPreguntas(preguntas);
				}
			}
			
		}

		return comp;
	}

}
