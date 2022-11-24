package clases.gestores;

import java.sql.SQLException;

import clases.dao.interfaces.CuestionarioDAO;
import clases.dao.postgres.PostgresCuestionario;
import clases.dto.CandidatoDTO;
import clases.dto.CuestionarioDTO;
import clases.entidades.Cuestionario;

public class GestorCuestionario
{

	public CuestionarioDTO findByCandidato(CandidatoDTO candidato) throws SQLException
	{
		CuestionarioDTO estado = null;
		Cuestionario cuestionario = null;
		CuestionarioDAO cDao = new PostgresCuestionario();
		
		cuestionario = cDao.findByIdCandidato(candidato.getId());
		
		return estado;
		
	}

}
