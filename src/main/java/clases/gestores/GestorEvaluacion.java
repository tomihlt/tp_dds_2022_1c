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

	public void generarEvaluacion(FuncionNombreIdDTO funcionDto,
			List<CompetenciaPuntajeNombreDTO> competenciasDto, Map<CandidatoNormalDTO, String> usuariosConClaves)
	{
		
	}

	
}
