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

	public void generarEvaluacion(FuncionNombreIdDTO funcionDto, Map<CandidatoNormalDTO, String> usuariosConClaves)
			throws SQLException
	{
		FuncionDAO fDao = new PostgresFuncion();
		Funcion funcion = fDao.find(funcionDto.getId());

		GestorUsuario gestorUsuario = new GestorUsuario();
		Map<Candidato, String> candidatosConClave = new HashMap<Candidato, String>();

		for (CandidatoNormalDTO c : usuariosConClaves.keySet())
		{
			Candidato cand = gestorUsuario.findCandidatoById(c.getId());
			candidatosConClave.put(cand, usuariosConClaves.get(c));
		}

		generarEvaluacion(funcion, candidatosConClave);

	}

	private void generarEvaluacion(Funcion funcion, Map<Candidato, String> candidatosConClave) throws SQLException
	{
		Evaluacion evaluacion = new Evaluacion();
		List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();

		GestorCuestionario gestor = new GestorCuestionario();
		
		for (Candidato c : candidatosConClave.keySet())
		{
			Cuestionario cuestionario = gestor.crearCuestionario(funcion,c,candidatosConClave.get(c));
			cuestionarios.add(cuestionario);
		}
		
		evaluacion.setFuncion(funcion);
		evaluacion.setCuestionarios(cuestionarios);
		
		EvaluacionDAO eDao = new PostgresEvaluacion();
		eDao.save(evaluacion);
	}

}
