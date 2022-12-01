package clases.gestores;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import clases.dao.interfaces.FactorDAO;
import clases.dao.postgres.PostgresFactor;
import clases.dto.CandidatoNormalDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.FactorBasicoDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.entidades.Factor;
import clases.entidades.Pregunta;

public class GestorEvaluacion
{

	public void generarEvaluacion(FuncionNombreIdDTO obtenerFuncionAEvaluar,
			Map<CompetenciaPuntajeNombreDTO, List<FactorBasicoDTO>> competenciasEvaluables,
			Map<CandidatoNormalDTO, String> usuariosConClaves) throws SQLException
	{
		Set<FactorBasicoDTO> factoresEvaluablesDto = new HashSet<FactorBasicoDTO>();
		for(CompetenciaPuntajeNombreDTO c : competenciasEvaluables.keySet())
		{
			List<FactorBasicoDTO> factores = competenciasEvaluables.get(c);
			factores.stream().map(f -> factoresEvaluablesDto.add(f));
		}
		
		GestorFactor gestorF = new GestorFactor();
		List<Factor> factores = gestorF.findById(factoresEvaluablesDto.stream().map(f -> f.getId()).collect(Collectors.toSet()));
		
		FactorDAO fDao = new PostgresFactor();
		for(Factor f : factores)
		{
			List<Pregunta> preguntasDelFactor = fDao.findPreguntasByFactor(f);
			f.setPreguntas(preguntasDelFactor);
		}
	}

}
