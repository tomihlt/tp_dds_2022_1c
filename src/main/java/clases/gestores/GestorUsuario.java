package clases.gestores;

import java.sql.SQLException;

import clases.dao.interfaces.ConsultorDAO;
import clases.dao.postgres.PostgresConsultor;
import clases.dto.ConsultorDTO;
import clases.entidades.Consultor;

public class GestorUsuario
{

	public ConsultorDTO findByNombreUsuario(String usuario) throws SQLException
	{
		Consultor consultor = null;
		ConsultorDTO consultorDto = null;
		
		ConsultorDAO cDao = new PostgresConsultor();
		
		try
		{
			consultor = cDao.findByNombreUsuario(usuario);
			consultorDto = new ConsultorDTO();
			consultorDto.setId(consultor.getId());
			consultorDto.setNombre(consultor.getNombre());
			consultorDto.setApellido(consultor.getApellido());
			consultorDto.setUsuario(consultor.getUsuario());
			consultorDto.setContraseña(consultor.getContraseña());
		} catch (SQLException e)
		{
			throw e;
		}
		
		return consultorDto;
	}

}
