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
import clases.entidades.PuntajeNecesario;

public class GestorEvaluacion
{

	public void generarEvaluacion(FuncionNombreIdDTO obtenerFuncionAEvaluar,
			List<CompetenciaPuntajeNombreDTO> competenciasParaEvaluar,
			Map<CandidatoNormalDTO, String> usuariosConClaves) throws SQLException
	{
		Map<Candidato, String> candidatos = obtenerCandidatos(usuariosConClaves);

		FuncionDAO dao = new PostgresFuncion();
		Funcion f = dao.find(obtenerFuncionAEvaluar.getId());

		GestorCompetencia gestorC = new GestorCompetencia();
		List<Competencia> competencias = gestorC.find(competenciasParaEvaluar, true, true);

		GestorFuncion gestor = new GestorFuncion();
		f = gestor.asociarPuntajes(f, competencias, competenciasParaEvaluar);
//		infoFuncion(f);

		List<PuntajeNecesario> compFactoresEvaluables = filtrarCompetenciasConFactoresEvaluables(
				f.getPuntajeNecesarioPorCompetencia());
		infoFuncion(f);

		f.setPuntajeNecesarioPorCompetencia(compFactoresEvaluables);

		generarEvaluacion(f, candidatos);

	}

	private void infoFuncion(Funcion fn)
	{
		System.out.println("Info funcion " + fn.getNombre());
		for (PuntajeNecesario p : fn.getPuntajeNecesarioPorCompetencia())
		{
			System.out.println(
					"\t Competencia: " + p.getCompetencia().getNombre() + " | Puntaje : " + p.getPuntaje().toString());
			for (Factor f : p.getCompetencia().getFactores())
			{
				System.out
						.println("\t\tFactor : " + f.getNombre() + " | Cantidad de preguntas: " + f.getPreguntas().size());
			}
		}

	}

	private void generarEvaluacion(Funcion f, Map<Candidato, String> candidatos) throws SQLException
	{
		// Funcion f: funcion en si
		// Competencias: Aquellas que se pueden evaluar, en su lista de factores, dichos
		// factores son evaluables
		// los factores tienen seteadas las preguntas
		Evaluacion evaluacion = new Evaluacion();
		List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();

		GestorCuestionario gestor = new GestorCuestionario();

		for (Candidato c : candidatos.keySet())
		{
			Cuestionario cuestionario = gestor.crearCuestionario(f, c, candidatos.get(c));
			cuestionarios.add(cuestionario);
		}

		evaluacion.setFuncion(f);
		evaluacion.setCuestionarios(cuestionarios);
		// Una vez generada todas los cuestionarios se carga todo en la bdd como una
		// transaccion

		EvaluacionDAO eDao = new PostgresEvaluacion();
		eDao.save(evaluacion);

	}

	private List<PuntajeNecesario> filtrarCompetenciasConFactoresEvaluables(List<PuntajeNecesario> competencias)
	{
		// Retorna una lista con las competencias para evaluar (porque son evaluables)
		// junto con los factores de esa competencia que son evaluables
		List<PuntajeNecesario> puntajes = new ArrayList<PuntajeNecesario>();

		for (PuntajeNecesario p : competencias)
		{
			for (Factor f : p.getCompetencia().getFactores())
			{
				if (f.getPreguntas().size() < 2)
					// No es evaluable por lo tanto elimino el factor de la competencia para evaluar
					p.getCompetencia().getFactores().remove(f);
			}
			if (p.getCompetencia().getFactores().size() > 0)
				// Es evaluable
				puntajes.add(p);
		}

		return puntajes;
	}

	private Map<Candidato, String> obtenerCandidatos(Map<CandidatoNormalDTO, String> lista) throws SQLException
	{
		GestorUsuario gestor = new GestorUsuario();
		Map<Candidato, String> candidatos = new HashMap<Candidato, String>();

		for (CandidatoNormalDTO c : lista.keySet())
		{
			Candidato cand = gestor.findCandidatoById(c.getId());
			candidatos.put(cand, lista.get(c));
		}

		return candidatos;
	}

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

//	private void generarEvaluacion(Funcion f, List<Competencia> competencias, Map<Candidato, String> candidatos)
//			throws SQLException
//	{
//		// Funcion f: funcion en si
//		// Competencias: Aquellas que se pueden evaluar, en su lista de factores, dichos
//		// factores son evaluables
//		// los factores tienen seteadas las preguntas
//		Evaluacion evaluacion = new Evaluacion();
//		List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
//
//		GestorCuestionario gestor = new GestorCuestionario();
//
//		for (Candidato c : candidatos.keySet())
//		{
//			Cuestionario cuestionario = gestor.crearCuestionario(f, competencias, c, candidatos.get(c));
//			cuestionarios.add(cuestionario);
//		}
//
//		evaluacion.setFuncion(f);
//		evaluacion.setCuestionarios(cuestionarios);
//		// Una vez generada todas los cuestionarios se carga todo en la bdd como una
//		// transaccion
//
//		EvaluacionDAO eDao = new PostgresEvaluacion();
//		eDao.save(evaluacion);
//
//	}

}
