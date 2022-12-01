package clases.gestores;

import java.sql.SQLException;
import java.util.List;

import clases.dao.interfaces.CuestionarioDAO;
import clases.dao.postgres.PostgresCuestionario;
import clases.dto.CandidatoDTO;
import clases.dto.CuestionarioDTO;
import clases.entidades.Candidato;
import clases.entidades.Competencia;
import clases.entidades.Cuestionario;
import clases.enums.EstadoCuestionario;

public class GestorCuestionario
{

	public CuestionarioDTO findByCandidato(CandidatoDTO candidato) throws SQLException
	{
		CuestionarioDTO estado = null;
		Cuestionario cuestionario = null;
		CuestionarioDAO cDao = new PostgresCuestionario();
		
		cuestionario = cDao.findByIdCandidato(candidato.getId());
		
		if(cuestionario == null)
			return null;
		
		estado = new CuestionarioDTO();
		estado.setId(cuestionario.getId());
		estado.setFechaFin(cuestionario.getFechaFin());
		estado.setEstado(cuestionario.getEstado());
//		estado.setTiempoEmpleado(cuestionario.getTiempoEmpleado());
		estado.setCantidadAccesos(cuestionario.getCantidadAccesos());
		estado.setCantidadAccesosMaxima(cuestionario.getCantidadAccessosMaxima());
		estado.setClave(cuestionario.getClave());
		
		return estado;
		
	}

	public Cuestionario crearCuestionario(List<Competencia> competencias, Candidato c, String string)
	{
		Cuestionario cuestionario = new Cuestionario();
		
		cuestionario.setEstado(EstadoCuestionario.SinContestar);
		
		return cuestionario;
	}

}
