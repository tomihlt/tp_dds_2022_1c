package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import clases.dao.DBConnection;
import clases.dao.interfaces.FuncionDAO;
import clases.entidades.Competencia;
import clases.entidades.Empresa;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public class PostgresFuncion implements FuncionDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Funcion t) throws SQLException
	{
		try(PreparedStatement pstm = conn.prepareStatement("SELECT nombre FROM dds.funcion WHERE codigo = ? AND eliminado = false;"))
		{
			pstm.setInt(1, t.getCodigo());
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				throw new SQLException("Ya hay una funcion con ese código");
			}
		}
		
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
	public Funcion find(Integer id) throws SQLException
	{
		Funcion f = new Funcion();

		try (PreparedStatement pstm = conn
				.prepareStatement("SELECT id,nombre,codigo,descripcion,eliminado FROM dds.funcion WHERE id = ?"))
		{
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				f.setId(rs.getInt(1));
				f.setNombre(rs.getString(2));
				f.setCodigo(rs.getInt(3));
				f.setDescripcion(rs.getString(4));
				f.setEliminado(rs.getBoolean(5));
			}
		} catch (SQLException e)
		{
			throw e;
		}

		return f;
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

		String query = "SELECT f.id,f.nombre,f.codigo,f.descripcion,f.eliminado FROM dds.funcion as f, dds.empresa as e WHERE f.id_empresa = e.id AND f.eliminado = false AND f.nombre ILIKE ? AND e.nombre ILIKE ?";

		if(codigo != null)
			query += " AND f.codigo = ? ORDER BY f.codigo;";
		else
			query += " ORDER BY f.codigo;";

		try (PreparedStatement pstm = conn.prepareStatement(query))
		{
			
			if(nombre == null)
				pstm.setString(1, "%");
			else
				pstm.setString(1, nombre+"%");
			
			if(empresa == null)
				pstm.setString(2, "%");
			else
				pstm.setString(2, empresa+"%");
			
			if(codigo != null)
				pstm.setInt(3, codigo);
				

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
			if (rs.next())
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

	@Override
	public Funcion findByCodigo(Integer codigo) throws SQLException
	{
		Funcion f = new Funcion();

		try (PreparedStatement pstm = conn
				.prepareStatement("SELECT id,nombre,codigo,descripcion,eliminado FROM dds.funcion WHERE codigo = ?;"))
		{
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				f.setId(rs.getInt(1));
				f.setNombre(rs.getString(2));
				f.setCodigo(rs.getInt(3));
				f.setDescripcion(rs.getString(4));
				f.setEliminado(rs.getBoolean(5));
			}
		}

		return f;
	}

	@Override
	public void update(Funcion t) throws SQLException
	{
		try (PreparedStatement pstm = conn
				.prepareStatement("UPDATE dds.funcion SET codigo = ?, descripcion = ?, eliminado = ?, nombre = ? WHERE id = ?;"))
		{
			pstm.setInt(1, t.getCodigo());
			pstm.setString(2, t.getDescripcion());
			pstm.setBoolean(3, t.getEliminado());
			pstm.setString(4, t.getNombre());
			pstm.setInt(5, t.getId());
			pstm.executeUpdate();
		}
	}

	@Override
	public List<PuntajeNecesario> findPuntajes(Funcion f) throws SQLException
	{
		List<PuntajeNecesario> puntajes = new ArrayList<PuntajeNecesario>();
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT c.id,c.nombre,c.codigo,c.descripcion,p.puntaje_necesario FROM dds.funcion_competencias as p, dds.competencia as c WHERE p.competencia = c.id AND p.funcion = ? AND c.eliminado = false;"))
		{
			pstm.setInt(1, f.getId());
			ResultSet rs = pstm.executeQuery();
			PuntajeNecesario p = null;
			Competencia c = null;
			while(rs.next())
			{
				c = new Competencia();
				p = new PuntajeNecesario();
				
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCodigo(rs.getInt(3));
				c.setDescripcion(rs.getString(4));
				c.setEliminado(false);
				
				p.setFuncion(f);
				p.setCompetencia(c);
				p.setPuntaje(rs.getInt(5));
				
				puntajes.add(p);
			}
		}catch(PSQLException e)
		{
			throw e;
		}
		
		return puntajes;
	}

	@Override
	public void updateFuncionConPuntajesYEmpresa(Funcion f) throws SQLException
	{
		conn.setAutoCommit(false);
		
		try 
		{
		update(f);
		updateEmpresa(f);
		removePuntajes(f);
		addPuntajeCompetencia(f.getPuntajeNecesarioPorCompetencia());
		}catch(SQLException e)
		{
			conn.rollback();
			conn.setAutoCommit(true);
			throw e;
		}
		
		conn.commit();
		conn.setAutoCommit(true);
		
	}
	
	@Override
	public void updateEmpresa(Funcion f) throws SQLException
	{
		try(PreparedStatement pstm = conn.prepareStatement("UPDATE dds.funcion SET id_empresa = ? WHERE id = ?;"))
		{
			pstm.setInt(1, f.getEmpresa().getId());
			pstm.setInt(2, f.getId());
			pstm.executeUpdate();
		}
	}
	
	@Override
	public void removePuntajes(Funcion f) throws SQLException
	{
		try(PreparedStatement pstm = conn.prepareStatement("DELETE FROM dds.funcion_competencias WHERE funcion = ?;"))
		{
			pstm.setInt(1, f.getId());
			pstm.executeUpdate();
		}
	}

}
