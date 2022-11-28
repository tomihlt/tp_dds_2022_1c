package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.CandidatoDAO;
import clases.dto.CandidatoBasicoDTO;
import clases.entidades.Candidato;
import clases.enums.TipoDNI;

public class PostgresCandidato implements CandidatoDAO
{

	private Connection conn = DBConnection.get();

	@Override
	public void save(Candidato t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Candidato t)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Candidato find(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> find(List<Integer> id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Candidato t) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Candidato findCandidatoByDni(Integer dni) throws SQLException
	{
		Candidato candidato = null;

		try (PreparedStatement pstm = conn.prepareStatement(
				"SELECT u.id, u.nombre, u.apellido, c.numero_candidato, c.nacionalidad, c.eliminado, c.email, c.fecha_nacimiento, c.dni, c.tipo_dni FROM dds.candidato c, dds.usuario u WHERE u.id = c.id AND c.dni = ? AND c.eliminado = false;"))
		{
			pstm.setInt(1, dni);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				candidato = new Candidato();
				candidato.setId(rs.getInt(1));
				candidato.setNombre(rs.getString(2));
				candidato.setApellido(rs.getString(3));
				candidato.setNumeroCandidato(rs.getInt(4));
				candidato.setNacionalidad(rs.getString(5));
				candidato.setEliminado(rs.getBoolean(6)); // debe ser false
				candidato.setEmail(rs.getString(7));
				candidato.setFechaNacimiento(rs.getDate(8).toLocalDate());
				candidato.setDni(rs.getInt(9));
				candidato.setTipoDni(tipoDeDniDelCandidato(rs.getString(10)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}

		return candidato;
	}

	private TipoDNI tipoDeDniDelCandidato(String string)
	{
		if(string == "DNI")
			return TipoDNI.DNI;
		else if(string == "LE")
			return TipoDNI.LE;
		else if(string == "LC")
			return TipoDNI.LC;
		else
			return TipoDNI.PP;
	}

	@Override
	public List<Candidato> findByFilters(String apellido, String nombre, Integer numeroDeCandidato)
			throws SQLException
	{
		List<Candidato> candidatos = new ArrayList<Candidato>();
		
		String query = "SELECT c.id,c.numero_candidato,c.nacionalidad,c.eliminado,c.email,c.fecha_nacimiento,c.dni,c.tipo_dni, u.apellido, u.nombre FROM dds.candidato c, dds.usuario u WHERE eliminado = false AND u.id = c.id AND u.apellido ILIKE ? AND u.nombre ILIKE ?";
		
		if(numeroDeCandidato != null)
			query += " AND numero_candidato = ? ORDER BY numero_candidato;";
		else
			query += " ORDER BY numero_candidato";
		
		try(PreparedStatement pstm = conn.prepareStatement(query))
		{
			if(apellido != null)
				pstm.setString(1, apellido + "%");
			else
				pstm.setString(1, "%");
			
			if(nombre != null)
				pstm.setString(2, nombre + "%");
			else
				pstm.setString(2, "%");
			
			if(numeroDeCandidato != null)
				pstm.setInt(3, numeroDeCandidato);
			
			ResultSet rs = pstm.executeQuery();
			
			Candidato c = null;
			
			while(rs.next())
			{
				c = new Candidato();
				c.setId(rs.getInt(1));
				c.setNumeroCandidato(rs.getInt(2));
				c.setNacionalidad(rs.getString(3));
				c.setEliminado(rs.getBoolean(4));
				c.setEmail(rs.getString(5));
				c.setFechaNacimiento(rs.getDate(6).toLocalDate());
				c.setDni(rs.getInt(7));
				c.setTipoDni(tipoDeDniDelCandidato(rs.getString(8)));
				c.setApellido(rs.getString(9));
				c.setNombre(rs.getString(10));
				candidatos.add(c);
			}
		}
		
		return candidatos;
	}

}
