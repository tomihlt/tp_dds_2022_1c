package clases.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.dao.DBConnection;
import clases.dao.interfaces.CandidatoDAO;
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

}
