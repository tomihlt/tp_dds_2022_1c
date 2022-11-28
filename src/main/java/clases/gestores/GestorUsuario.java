package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import clases.dao.interfaces.CandidatoDAO;
import clases.dao.interfaces.ConsultorDAO;
import clases.dao.postgres.PostgresCandidato;
import clases.dao.postgres.PostgresConsultor;
import clases.dto.ConsultorDTO;
import clases.entidades.Candidato;
import clases.entidades.Consultor;
import clases.dto.CandidatoBasicoDTO;
import clases.dto.CandidatoDTO;

public class GestorUsuario
{

	public ConsultorDTO findConsultorByNombreUsuario(String usuario) throws SQLException
	{
		Consultor consultor = null;
		ConsultorDTO consultorDto = null;
		
		ConsultorDAO cDao = new PostgresConsultor();
		
		try
		{
			consultor = cDao.findConsultorByNombreUsuario(usuario);
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

	public CandidatoDTO findCandidatoByDni(Integer dni) throws SQLException
	{
		Candidato candidato = null;
		CandidatoDTO candidatoDto = null;
		
		CandidatoDAO cDao = new PostgresCandidato();

		candidato = cDao.findCandidatoByDni(dni);
		if(candidato == null)
			return candidatoDto;
		
		candidatoDto = new CandidatoDTO();
		candidatoDto.setApellido(candidato.getApellido());
		candidatoDto.setDni(candidato.getDni());
		candidatoDto.setEliminado(candidato.getEliminado());
		candidatoDto.setEmail(candidato.getEmail());
		candidatoDto.setFechaNacimiento(candidato.getFechaNacimiento());
		candidatoDto.setId(candidato.getId());
		candidatoDto.setNacionalidad(candidato.getNacionalidad());
		candidatoDto.setNombre(candidato.getNombre());
		candidatoDto.setNumeroCandidato(candidato.getNumeroCandidato());
		candidatoDto.setTipoDni(candidato.getTipoDni());
		
		return candidatoDto;
	}

	public List<CandidatoBasicoDTO> findByFilters(String apellido, String nombre, Integer numeroDeCandidato) throws SQLException
	{
		List<CandidatoBasicoDTO> resultado = new ArrayList<CandidatoBasicoDTO>();
		
		CandidatoDAO cDao = new PostgresCandidato();
		
		List<Candidato> candidatos = cDao.findByFilters(apellido, nombre, numeroDeCandidato);
		
		for(Candidato c : candidatos)
		{
			CandidatoBasicoDTO cand = new CandidatoBasicoDTO();
			cand.setId(c.getId());
			cand.setApellido(c.getApellido());
			cand.setNombre(c.getNombre());
			cand.setNumeroDeCandidato(c.getNumeroCandidato());
			resultado.add(cand);
		}
		
		return resultado;
	}

}
