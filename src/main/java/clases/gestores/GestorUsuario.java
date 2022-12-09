package clases.gestores;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import javax.swing.JTextField;

import clases.dao.interfaces.CandidatoDAO;
import clases.dao.interfaces.ConsultorDAO;
import clases.dao.postgres.PostgresCandidato;
import clases.dao.postgres.PostgresConsultor;
import clases.dto.ConsultorDTO;
import clases.entidades.Candidato;
import clases.entidades.Consultor;
import clases.entidades.Cuestionario;
import clases.enums.EstadoCuestionario;
import clases.dto.CandidatoBasicoDTO;
import clases.dto.CandidatoDTO;
import clases.dto.CandidatoNormalDTO;

public class GestorUsuario
{

	public Boolean contraseñaCorrecta(ConsultorDTO consultor, char[] contraseña)
	{

		if (contraseña.length > consultor.getContraseña().length())
			return false;

		for (int i = 0; i < contraseña.length; i++)
		{
			if (!(contraseña[i] == consultor.getContraseña().charAt(i)))
				return false;
		}
		return true;
	}

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
		if (candidato == null)
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

	public List<CandidatoBasicoDTO> findByFilters(String apellido, String nombre, Integer numeroDeCandidato)
			throws SQLException
	{
		List<CandidatoBasicoDTO> resultado = new ArrayList<CandidatoBasicoDTO>();

		CandidatoDAO cDao = new PostgresCandidato();

		List<Candidato> candidatos = cDao.findByFilters(apellido, nombre, numeroDeCandidato);

		for (Candidato c : candidatos)
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

	public Boolean tieneCuestionario(CandidatoBasicoDTO c) throws SQLException
	{
		CandidatoDAO cDao = new PostgresCandidato();

		return cDao.tieneCuestionarioById(c.getId());
	}

	public List<CandidatoNormalDTO> getCandidatosDto(List<CandidatoBasicoDTO> candidatosAEvaluar) throws SQLException
	{
		List<CandidatoNormalDTO> candidatos = new ArrayList<CandidatoNormalDTO>();

		for (CandidatoBasicoDTO c : candidatosAEvaluar)
		{
			CandidatoNormalDTO cand = findCandidatoNormalById(c.getId());
			candidatos.add(cand);
		}

		return candidatos;
	}

	public CandidatoNormalDTO findCandidatoNormalById(Integer id) throws SQLException
	{
		Candidato candidato = null;
		CandidatoNormalDTO candidatoDto = null;

		CandidatoDAO cDao = new PostgresCandidato();

		candidato = cDao.find(id);
		if (candidato == null)
			return candidatoDto;

		candidatoDto = new CandidatoNormalDTO();
		candidatoDto.setApellido(candidato.getApellido());
		candidatoDto.setDni(candidato.getDni());
		candidatoDto.setId(candidato.getId());
		candidatoDto.setNombre(candidato.getNombre());
		candidatoDto.setTipoDNI(candidato.getTipoDni());

		return candidatoDto;
	}

	public Map<CandidatoNormalDTO, String> generarClaves(List<CandidatoNormalDTO> candidatos)
	{
		Map<CandidatoNormalDTO, String> claves = new HashMap<CandidatoNormalDTO, String>();

		for (CandidatoNormalDTO c : candidatos)
		{
			String aux = cadenaAleatoria(10);

			claves.put(c, aux);
		}

		return claves;
	}

	private String cadenaAleatoria(int longitud)
	{ // Metodo sacado de internet
		// El banco de caracteres
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		// La cadena en donde iremos agregando un carácter aleatorio
		String cadena = "";
		for (int x = 0; x < longitud; x++)
		{
			int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
			char caracterAleatorio = banco.charAt(indiceAleatorio);
			cadena += caracterAleatorio;
		}
		return cadena;
	}

	private Integer numeroAleatorioEnRango(int minimo, int maximo)
	{
		// nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos
		// 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

	public List<Candidato> findCandidatoById(List<Integer> ids) throws SQLException
	{
		CandidatoDAO dao = new PostgresCandidato();
		return dao.find(ids);
	}

	public Candidato findCandidatoById(Integer id) throws SQLException
	{
		CandidatoDAO dao = new PostgresCandidato();
		return dao.find(id);
	}

	public Boolean cuestionarioAccesible(CandidatoDTO candidato) throws SQLException
	{
		CandidatoDAO dao = new PostgresCandidato();

		Candidato cand = dao.findCandidatoByDni(candidato.getDni());

		Cuestionario cuestionario = cand.getCuestionario();

		if (cuestionario.getEstado().equals(EstadoCuestionario.Completo)
				|| cuestionario.getEstado().equals(EstadoCuestionario.SinContestar)
				|| cuestionario.getFechaFin().isBefore(LocalDateTime.now()))
			return false;
		else
			return true;
	}

	public Boolean contraseñaCorrecta(CandidatoDTO candidato, char[] password) throws SQLException
	{
		CandidatoDAO dao = new PostgresCandidato();

		Candidato cand = dao.find(candidato.getId());
		
		Cuestionario cuest = cand.getCuestionario();
		
		return contraseñaCorrecta(cuest.getClave(), password);
		
	}
	
	public Boolean contraseñaCorrecta(String pw, char[] contraseña)
	{

		if (contraseña.length > pw.length())
			return false;

		for (int i = 0; i < contraseña.length; i++)
		{
			if (!(contraseña[i] == pw.charAt(i)))
				return false;
		}
		return true;
	}

}
