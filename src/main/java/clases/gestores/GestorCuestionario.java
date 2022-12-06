package clases.gestores;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import clases.dao.interfaces.CuestionarioDAO;
import clases.dao.interfaces.FactorDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.interfaces.PreguntaDAO;
import clases.dao.postgres.PostgresCuestionario;
import clases.dao.postgres.PostgresFactor;
import clases.dao.postgres.PostgresFuncion;
import clases.dao.postgres.PostgresPregunta;
import clases.dto.CandidatoDTO;
import clases.dto.CuestionarioDTO;
import clases.entidades.Bloque;
import clases.entidades.Candidato;
import clases.entidades.Competencia;
import clases.entidades.CompetenciaCuestionario;
import clases.entidades.Cuestionario;
import clases.entidades.Factor;
import clases.entidades.FactorCuestionario;
import clases.entidades.Funcion;
import clases.entidades.Ponderacion;
import clases.entidades.Pregunta;
import clases.entidades.PreguntaCuestionario;
import clases.entidades.PuntajeNecesario;
import clases.entidades.Respuesta;
import clases.entidades.RespuestaCuestionario;
import clases.enums.EstadoCuestionario;

public class GestorCuestionario
{

	public CuestionarioDTO findByCandidato(CandidatoDTO candidato) throws SQLException
	{
		CuestionarioDTO estado = null;
		Cuestionario cuestionario = null;
		CuestionarioDAO cDao = new PostgresCuestionario();

		cuestionario = cDao.findByIdCandidato(candidato.getId());

		if (cuestionario == null)
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

	private List<Bloque> generarBloques(Cuestionario cuestionario)
	{
		// Genero 3 preguntas por bloque (eleccion arbitraria, cambiar el parametro de
		// esta funcion
		// para N preguntas por bloques
		final int $CANT_PREG_BLOQUE = 3;

		List<PreguntaCuestionario> allPreguntas = getAllPreguntas(cuestionario);
		Collections.shuffle(allPreguntas); // Mezclo todo

		Bloque b = null;
		List<Bloque> bloques = new ArrayList<Bloque>();
		Integer cantidadDeBloques = 0;

		while (allPreguntas.size() > 0)
		{
			List<PreguntaCuestionario> aux = new ArrayList<PreguntaCuestionario>();
			b = new Bloque();
			for (int i = 0; i < $CANT_PREG_BLOQUE && !allPreguntas.isEmpty(); i++)
			{
				aux.add(allPreguntas.get(0));
				allPreguntas.get(0).setNroOrden(i);
				allPreguntas.remove(0);
			}
			b.setPreguntas(aux);
			b.setNumeroBloque(cantidadDeBloques);
			cantidadDeBloques++;
			b.setVisitable(true);
			bloques.add(b);
		}

		return bloques;

	}

	private List<PreguntaCuestionario> getAllPreguntas(Cuestionario cuestionario)
	{
		List<PreguntaCuestionario> preguntas = new ArrayList<PreguntaCuestionario>();

		for (CompetenciaCuestionario c : cuestionario.getCompetencias())
		{
			for (FactorCuestionario f : c.getFactores())
			{
				preguntas.addAll(f.getPreguntas());
			}
		}

		return preguntas;
	}

}
