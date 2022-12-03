package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import clases.dao.interfaces.EvaluacionDAO;
import clases.dao.interfaces.FactorDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresEvaluacion;
import clases.dao.postgres.PostgresFactor;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.CandidatoNormalDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.FactorBasicoDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.entidades.Candidato;
import clases.entidades.Competencia;
import clases.entidades.Cuestionario;
import clases.entidades.Evaluacion;
import clases.entidades.Factor;
import clases.entidades.Funcion;
import clases.entidades.Pregunta;

public class GestorEvaluacion
{

	public void generarEvaluacion(FuncionNombreIdDTO obtenerFuncionAEvaluar,
			List<CompetenciaPuntajeNombreDTO> competenciasEvaluables,
			Map<CandidatoNormalDTO, String> usuariosConClaves) throws SQLException
	{

//		List<Competencia> competencias = cargarCompetenciaConFactores(competenciasEvaluables);
//		Map<Candidato, String> candidatos = obtenerCandidatos(usuariosConClaves);
		
//		FuncionDAO dao = new PostgresFuncion();
//		Funcion f = dao.find(obtenerFuncionAEvaluar.getId());
		
//		generarEvaluacion(f,competencias, candidatos);
//
	}
//
//	private Map<Candidato, String> obtenerCandidatos(Map<CandidatoNormalDTO, String> lista) throws SQLException
//	{
//		GestorUsuario gestor = new GestorUsuario();
//		Map<Candidato, String> candidatos = new HashMap<Candidato, String>();
//
//		for (CandidatoNormalDTO c : lista.keySet())
//		{
//			Candidato cand = gestor.findCandidatoById(c.getId());
//			candidatos.put(cand, lista.get(c));
//		}
//
//		return candidatos;
//	}
//
//	public List<Competencia> cargarCompetenciaConFactores(
//			Map<CompetenciaPuntajeNombreDTO, List<FactorBasicoDTO>> competenciasEvaluables) throws SQLException
//	{
//
//		List<Competencia> competencias = new ArrayList<Competencia>();
//
//		for (CompetenciaPuntajeNombreDTO c : competenciasEvaluables.keySet())
//		{
//			GestorCompetencia gestorC = new GestorCompetencia();
//			GestorFactor gestorF = new GestorFactor();
//
//			Competencia comp = gestorC.findById(c.getId());
//
//			List<FactorBasicoDTO> factoresDto = competenciasEvaluables.get(c);
//			List<Factor> factores = gestorF.findById(factoresDto);
//			comp.setFactores(factores);
//
//			competencias.add(comp);
//
//		}
//
//		return competencias;
//	}
	
	private void generarEvaluacion(Funcion f, List<Competencia> competencias, Map<Candidato, String> candidatos) throws SQLException
	{
		// Funcion f: funcion en si
		// Competencias: Aquellas que se pueden evaluar, en su lista de factores, dichos factores son evaluables
		// los factores no tienen seteadas las preguntas
		Evaluacion evaluacion = new Evaluacion();
		List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
		
		GestorCuestionario gestor = new GestorCuestionario();
		
		for(Candidato c : candidatos.keySet())
		{
			Cuestionario cuestionario = gestor.crearCuestionario(f,competencias,c,candidatos.get(c));
			cuestionarios.add(cuestionario);
		}
		
		evaluacion.setFuncion(f);
		evaluacion.setCuestionarios(cuestionarios);
		// Una vez generada todas los cuestionarios se carga todo en la bdd como una transaccion
		
		EvaluacionDAO eDao = new PostgresEvaluacion();
		eDao.save(evaluacion);
		
	}

}
