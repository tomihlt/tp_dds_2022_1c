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

	public Cuestionario crearCuestionario(Funcion funcion, Candidato c, String clave) throws SQLException
	{
		Cuestionario cuestionario = new Cuestionario();

		cuestionario.setEstado(EstadoCuestionario.Activo);
		cuestionario.setFechaInicio(LocalDateTime.now());
		cuestionario.setFechaFin(LocalDateTime.now()); // Despues se sobreescribe al finalizar
		cuestionario.setCantidadAccessosMaxima(10);
		cuestionario.setCantidadAccesos(0);
		cuestionario.setUltimoIngreso(LocalDateTime.now());
		cuestionario.setFechaLimite(LocalDateTime.now().plusDays(7)); // 1 semana para completar
		cuestionario.setTiempoMaximo(3600L); // 3600 segundos = 1 hora
		cuestionario.setClave(clave);
		cuestionario.setCandidato(c);
		cuestionario.setPuntajeObtenido(0); // Despues se sobreescribe al finalizar

		List<CompetenciaCuestionario> competencias = generarCompetenciasCuestionario(
				funcion.getPuntajeNecesarioPorCompetencia());

		cuestionario.setCompetencias(competencias);

		List<Bloque> bloques = generarBloques(cuestionario);
		cuestionario.setBloques(bloques);

		return cuestionario;
	}

	private List<CompetenciaCuestionario> generarCompetenciasCuestionario(List<PuntajeNecesario> puntajes)
			throws SQLException
	{
		List<CompetenciaCuestionario> competencias = new ArrayList<CompetenciaCuestionario>();

		for (PuntajeNecesario p : puntajes)
		{
			CompetenciaCuestionario comp = new CompetenciaCuestionario();
			comp.setNombre(p.getCompetencia().getNombre());
			comp.setDescripcion(p.getCompetencia().getDescripcion());
			comp.setPuntajeNecesario(p.getPuntaje());
			comp.setCodigo(p.getCompetencia().getCodigo());
			comp.setPuntajeObtenido(0);
			List<FactorCuestionario> factoresCuestionarioDeLaCompetencia = generarFactoresCuestionario(
					p.getCompetencia().getFactores());
			if (factoresCuestionarioDeLaCompetencia.size() > 0)
			{
				comp.setFactores(factoresCuestionarioDeLaCompetencia);
				competencias.add(comp);
			}
		}

		return competencias;
	}

	private List<FactorCuestionario> generarFactoresCuestionario(List<Factor> factores) throws SQLException
	{
		List<FactorCuestionario> factoresCuestionario = new ArrayList<FactorCuestionario>();

		for (Factor f : factores)
		{
			if (f.getPreguntas().size() > 1)
			{
				FactorCuestionario fact = new FactorCuestionario();
				fact.setNombre(f.getNombre());
				fact.setDescripcion(f.getDescripcion());
				fact.setCodigo(f.getCodigo());
				fact.setNroOrden(f.getNroOrden());
				fact.setPuntajeObtenido(0);
				List<PreguntaCuestionario> preguntasCuestionarioDelFactor = generarPreguntaCuestionario(
						f.getPreguntas());
				fact.setPreguntas(preguntasCuestionarioDelFactor);
				factoresCuestionario.add(fact);
			}
		}

		return factoresCuestionario;
	}

	private List<PreguntaCuestionario> generarPreguntaCuestionario(List<Pregunta> preguntas) throws SQLException
	{
		List<PreguntaCuestionario> preguntasCuestionario = new ArrayList<PreguntaCuestionario>();

		Collections.shuffle(preguntas); // Mezclo las preguntas que voy a elegir
		List<Pregunta> preguntasElegidas = new ArrayList<Pregunta>();
		preguntasElegidas.add(preguntas.get(0)); // Si no tuviese al menos 2 preguntos no hubiese ingresado a este
													// método, no debería haber NullPointerException
		preguntasElegidas.add(preguntas.get(1));

		for (Pregunta p : preguntasElegidas)
		{
			PreguntaCuestionario preguntaAux = new PreguntaCuestionario();
			preguntaAux.setNombre(p.getNombre());
			preguntaAux.setDescripcion(p.getDescripcion());
//			preguntaAux.setNroOrden(null); Lo define el bloque
			List<RespuestaCuestionario> respuestas = generarRespuestaCuestionario(
					p.getOpcionDeRespuesta().getRespuestas());
			preguntaAux.setRespuestas(respuestas);
			preguntasCuestionario.add(preguntaAux);
		}

		return preguntasCuestionario;
	}

	private List<RespuestaCuestionario> generarRespuestaCuestionario(List<Respuesta> respuestas)
	{
		List<RespuestaCuestionario> rtas = new ArrayList<RespuestaCuestionario>();
		for (Respuesta r : respuestas)
		{
			RespuestaCuestionario rAux = new RespuestaCuestionario();
			rAux.setNombre(r.getNombre());
			rAux.setSeleccionada(false);
			rAux.setPonderacion(r.getPonderacion().getPonderacion());
			rAux.setDescripcion(r.getDescripcion());
			rAux.setOrdenVisualizacion(r.getOrdenVisualizacion());
			rtas.add(rAux);
		}

		return rtas;
	}

	private List<Bloque> generarBloques(Cuestionario cuestionario)
	{
		final int $CANT_PREG_BLOQUE = 3;

		List<PreguntaCuestionario> allPreguntas = getPreguntasCuestionario(cuestionario);
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

	private List<PreguntaCuestionario> getPreguntasCuestionario(Cuestionario cuestionario)
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

}
