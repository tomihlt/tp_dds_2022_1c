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

//	public Cuestionario crearCuestionario(Funcion f, List<Competencia> competencias, Candidato c, String clave)
//			throws SQLException
//	{
//		Cuestionario cuestionario = new Cuestionario();
//
//		LocalDateTime fechaCreacion = LocalDateTime.now();
//
//		cuestionario.setEstado(EstadoCuestionario.Activo);
//		cuestionario.setFechaInicio(fechaCreacion); // Aca no importa porque se supone que cuando el candidato inicie
//													// por primera vez sta fecha se sobreescribe al igual que cuando finaliza
//		cuestionario.setFechaFin(fechaCreacion);
//		cuestionario.setCantidadAccessosMaxima(100);
//		cuestionario.setCantidadAccesos(0);
//		cuestionario.setUltimoIngreso(fechaCreacion);
//		cuestionario.setFechaLimite(fechaCreacion.plusDays(7)); // tiene 1 semana para completarlo
//		cuestionario.setTiempoMaximo(3600L); // 3600 segundos = 1 hora
//		cuestionario.setClave(clave);
//		cuestionario.setPuntajeObtenido(0); // Al finalizar cuestionario se sobreescribe
//		cuestionario.setCandidato(c);
//
//		List<CompetenciaCuestionario> competenciasCuestionario = generarCompetenciasYFactoresCuestionario(f,
//				cuestionario, competencias);
//		cuestionario.setCompetencias(competenciasCuestionario);
//		getAndSetPreguntasPorFactor(cuestionario); // Ya elige aleatoriamente las 2 preguntas y las setea dentro de cada
//													// clase
//		// ahora hay que generar los bloques
//		List<Bloque> bloques = generarBloques(cuestionario);
//		
//		cuestionario.setBloques(bloques);
//		
//		infoCuestionario(cuestionario);
//		
//		return cuestionario;
//	}

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

//	private void infoCuestionario(Cuestionario c)
//	{
//		c.getCompetencias().forEach(x -> System.out.println(x.toString()));
//		c.getCompetencias().forEach(x -> x.getFactores().forEach(z -> System.out.println(z.toString())));
//		
//	}

//	private void getAndSetPreguntasPorFactor(Cuestionario cuestionario) throws SQLException
//	{
//		// TODO
//		for (CompetenciaCuestionario c : cuestionario.getCompetencias())
//		{
//			for (FactorCuestionario f : c.getFactores())
//			{
//				FactorDAO dao = new PostgresFactor();
//				List<Pregunta> preguntas = dao.findPreguntasByCodigoFactor(f.getCodigo());
//				Collections.shuffle(preguntas); // Desordena la lista, obtengo las 2 primeras preguntas
//				List<Pregunta> elegidas = new ArrayList<Pregunta>();
//				elegidas.add(preguntas.get(0));
//				elegidas.add(preguntas.get(1));
//				List<PreguntaCuestionario> preguntasDelFactor = generarPreguntaAndRespuestaCuestionario(elegidas, f);
//				f.setPreguntas(preguntasDelFactor);
//			}
//		}
//	}

//	private List<PreguntaCuestionario> generarPreguntaAndRespuestaCuestionario(List<Pregunta> preguntas,
//			FactorCuestionario f) throws SQLException
//	{
//
//		List<PreguntaCuestionario> resultado = new ArrayList<PreguntaCuestionario>();
//		for (Pregunta p : preguntas)
//		{
//			PreguntaCuestionario aux = new PreguntaCuestionario();
//			aux.setNombre(p.getNombre());
//			aux.setDescripcion(p.getDescripcion());
//			aux.setFactor(f);
//			List<RespuestaCuestionario> respuestas = obtenerRespuestasPregunta(p);
//			aux.setRespuestas(respuestas);
//			resultado.add(aux);
//		}
//
//		return resultado;
//	}

//	private List<RespuestaCuestionario> obtenerRespuestasPregunta(Pregunta p) throws SQLException
//	{
//		List<RespuestaCuestionario> resultado = new ArrayList<RespuestaCuestionario>();
//
//		PreguntaDAO dao = new PostgresPregunta();
//		List<Respuesta> respuestas = dao.findRespuestas(p);
//
//		for (Respuesta r : respuestas)
//		{
//			Ponderacion pond = dao.findPonderacion(p, r);
//			r.setPonderacion(pond);
//			RespuestaCuestionario rc = new RespuestaCuestionario();
//			rc.setNombre(r.getNombre());
//			rc.setDescripcion(r.getDescripcion());
//			rc.setSeleccionada(false);
//			rc.setPonderacion(pond.getPonderacion());
//			rc.setOrdenVisualizacion(r.getOrdenVisualizacion());
//			resultado.add(rc);
//		}
//
//		return resultado;
//	}

//	private List<CompetenciaCuestionario> generarCompetenciasYFactoresCuestionario(Funcion f, Cuestionario cuestionario,
//			List<Competencia> competencias) throws SQLException
//	{
//
//		CompetenciaCuestionario comp = null;
//		List<CompetenciaCuestionario> comps = new ArrayList<CompetenciaCuestionario>();
//		FuncionDAO dao = new PostgresFuncion();
//
//		for (Competencia c : competencias)
//		{
//			comp = new CompetenciaCuestionario();
//			comp.setNombre(c.getNombre());
//			comp.setDescripcion(c.getDescripcion());
//			comp.setPuntajeNecesario(dao.findPuntaje(f, c).getPuntaje());
//			comp.setCodigo(c.getCodigo());
//			comp.setPuntajeObtenido(0);
//			List<FactorCuestionario> factoresCuestionario = generarFactoresCuestionarios(c);
//			comp.setFactores(factoresCuestionario);
//			comps.add(comp);
//		}
//
//		return comps;
//	}

	public Cuestionario crearCuestionario(Funcion f, Candidato c, String clave) throws SQLException
	{
		// TODO A partir de aca son los metodos actualizados
		Cuestionario cuestionario = new Cuestionario();

		LocalDateTime fechaCreacion = LocalDateTime.now();

		cuestionario.setEstado(EstadoCuestionario.Activo);
		cuestionario.setFechaInicio(fechaCreacion); // Aca no importa porque se supone que cuando el candidato inicie
													// por primera vez sta fecha se sobreescribe al igual que cuando
													// finaliza
		cuestionario.setFechaFin(fechaCreacion);
		cuestionario.setCantidadAccessosMaxima(100);
		cuestionario.setCantidadAccesos(0);
		cuestionario.setUltimoIngreso(fechaCreacion);
		cuestionario.setFechaLimite(fechaCreacion.plusDays(7)); // tiene 1 semana para completarlo
		cuestionario.setTiempoMaximo(3600L); // 3600 segundos = 1 hora
		cuestionario.setClave(clave);
		cuestionario.setPuntajeObtenido(0); // Al finalizar cuestionario se sobreescribe
		cuestionario.setCandidato(c);

		List<CompetenciaCuestionario> competenciasCuestionario = generarCompetenciasCuestionario(f);
		cuestionario.setCompetencias(competenciasCuestionario);
		
		List<Bloque> bloques = generarBloques(cuestionario);
		
		cuestionario.setBloques(bloques);

		return cuestionario;
	}

	private List<CompetenciaCuestionario> generarCompetenciasCuestionario(Funcion f) throws SQLException
	{

		List<CompetenciaCuestionario> comps = new ArrayList<CompetenciaCuestionario>();

		for (PuntajeNecesario p : f.getPuntajeNecesarioPorCompetencia())
		{
			CompetenciaCuestionario comp = new CompetenciaCuestionario();
			Competencia c = p.getCompetencia();
			comp = new CompetenciaCuestionario();
			comp.setNombre(c.getNombre());
			comp.setDescripcion(c.getDescripcion());
			comp.setPuntajeNecesario(p.getPuntaje());
			comp.setCodigo(c.getCodigo());
			comp.setPuntajeObtenido(0);
			List<FactorCuestionario> factoresCuestionario = generarFactoresCuestionarios(c);
			comp.setFactores(factoresCuestionario);
			comps.add(comp);
		}

		return comps;
	}

	private List<FactorCuestionario> generarFactoresCuestionarios(Competencia c) throws SQLException
	{
		List<FactorCuestionario> factores = new ArrayList<FactorCuestionario>();

		for(Factor f : c.getFactores())
		{
			FactorCuestionario aux = new FactorCuestionario();
			aux.setNombre(f.getNombre());
			aux.setDescripcion(f.getDescripcion());
			aux.setCodigo(f.getCodigo());
			aux.setNroOrden(f.getNroOrden());
			aux.setPuntajeObtenido(0);
			List<PreguntaCuestionario> preguntasCuestionario = generarPreguntasCuestionario(f,aux);
			aux.setPreguntas(preguntasCuestionario);
			factores.add(aux);
		}

		return factores;
	}

	private List<PreguntaCuestionario> generarPreguntasCuestionario(Factor f, FactorCuestionario faux) throws SQLException
	{
		List<PreguntaCuestionario> preguntasCuestionario = new ArrayList<PreguntaCuestionario>();

		List<Pregunta> preguntas = f.getPreguntas();

		Collections.shuffle(preguntas); // Reordeno aleatoriamente y saco las 2 primeras
		List<Pregunta> preguntasAleatorias = new ArrayList<Pregunta>();
		preguntasAleatorias.add(preguntas.get(0));
		preguntasAleatorias.add(preguntas.get(1));

		for (Pregunta p : preguntasAleatorias)
		{
			PreguntaCuestionario aux = generarPreguntaCuestionario(p);
			aux.setFactor(faux);
			preguntasCuestionario.add(aux);
		}

		return preguntasCuestionario;
	}

	private PreguntaCuestionario generarPreguntaCuestionario(Pregunta p) throws SQLException
	{
		PreguntaCuestionario pregunta = new PreguntaCuestionario();
		
		pregunta.setNombre(p.getNombre());
		pregunta.setDescripcion(p.getDescripcion());
//		pregunta.setNroOrden(); Esto lo asigna el bloque
		List<RespuestaCuestionario> respuestas = generarRespuestasCuestionario(p);
		pregunta.setRespuestas(respuestas);
		
		return pregunta;
	}

	private List<RespuestaCuestionario> generarRespuestasCuestionario(Pregunta p) throws SQLException
	{
		List<RespuestaCuestionario> respuestas = new ArrayList<RespuestaCuestionario>();
		
		PreguntaDAO dao = new PostgresPregunta();
		List<Respuesta> rtaAux = dao.findRespuestas(p,true);
		
		for(Respuesta r : rtaAux)
		{
			RespuestaCuestionario aux = new RespuestaCuestionario();
			aux.setNombre(r.getNombre());
			aux.setSeleccionada(false);
			aux.setPonderacion(r.getPonderacion().getPonderacion());
			aux.setDescripcion(r.getDescripcion());
			aux.setOrdenVisualizacion(r.getOrdenVisualizacion());
			respuestas.add(aux);
		}
		
		return respuestas;
	}

}
