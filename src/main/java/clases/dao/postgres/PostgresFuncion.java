package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.FuncionDAO;
import clases.entidades.Empresa;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public class PostgresFuncion implements FuncionDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Funcion t) throws SQLException
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

	@Override
	public List<Funcion> findByFilters(Integer codigo, String nombre, String empresa) throws SQLException
	{
		List<Funcion> funciones = new ArrayList<Funcion>();

		Boolean cod = false;
		Boolean nom = false;
		Boolean emp = false;

		String query = "SELECT f.id,f.nombre,f.codigo,f.descripcion,f.eliminado FROM dds.funcion as f, dds.empresa as e WHERE f.id_empresa = e.id AND f.eliminado = false";
		String q_start = " AND(";
		String q_end1 = ") ORDER BY f.codigo;";
		String q_end2 = " ORDER BY f.codigo;";
		String q_or_condition = " OR ";

		if (codigo != null || nombre != null || empresa != null)
			query += q_start;

		if (codigo != null)
		{
			query += "f.codigo = ?";
			cod = true;
		}
		if (nombre != null)
		{
			if(cod)
				query += q_or_condition;
			query += "f.nombre = ?";
			nom = true;
		}
		if (empresa != null)
		{
			if(cod || nom)
				query += q_or_condition;
			query += "e.nombre = ?";
			emp = true;
		}

		if (codigo != null || nombre != null || empresa != null)
			query += q_end1;
		else
			query += q_end2;

		try (PreparedStatement pstm = conn.prepareStatement(query))
		{
			// Codigo
			if (cod)
				pstm.setInt(1, codigo);
			
			// Nombre
			if(cod && nom)
				pstm.setString(2, nombre);
			else if(nom)
				pstm.setString(1, nombre);
			
			// Empresa
			if(cod && nom && emp)
				pstm.setString(3, empresa);
			else if(emp && (cod || nom))
				pstm.setString(2, empresa);
			else if(emp)
				pstm.setString(1, empresa);
			
			ResultSet rs = pstm.executeQuery();
			Funcion funcion = null;
			while (rs.next())
			{
				funcion = new Funcion();
				funcion.setId(rs.getInt(1));
				funcion.setNombre(rs.getString(2));
				funcion.setCodigo(rs.getInt(3));
				funcion.setDescripcion(rs.getString(4));
				funcion.setEliminado(rs.getBoolean(5));
				funciones.add(funcion);
			}

		} catch (SQLException e)
		{
			throw e;
		}

		return funciones;
	}

	@Override
	public void setEmpresa(Funcion f) throws SQLException
	{
		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT e.id,e.nombre FROM dds.funcion as f, dds.empresa as e WHERE f.id = ? AND f.id_empresa = e.id;"))
		{
			pstm.setInt(1, f.getId());
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				Empresa e = new Empresa();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				f.setEmpresa(e);
			}
		} catch (SQLException e)
		{
			throw e;
		}
	}

}
