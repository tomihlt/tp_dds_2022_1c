package clases.gestores;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.CuestionarioDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresCuestionario;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.CandidatoDTO;
import clases.dto.CuestionarioDTO;
import clases.entidades.Candidato;
import clases.entidades.Competencia;
import clases.entidades.CompetenciaCuestionario;
import clases.entidades.Cuestionario;
import clases.entidades.FactorCuestionario;
import clases.entidades.Funcion;
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

	public Cuestionario crearCuestionario(Funcion f,List<Competencia> competencias, Candidato c, String clave) throws SQLException
	{
		Cuestionario cuestionario = new Cuestionario();
			
		LocalDateTime fechaCreacion = LocalDateTime.now();
		
		cuestionario.setEstado(EstadoCuestionario.SinContestar);
		cuestionario.setFechaInicio(fechaCreacion);	// Aca no importa porque se supone que cuando el candidato inicie por primera vez
		cuestionario.setFechaFin(fechaCreacion);	// esta fecha se sobreescribe al igual que cuando finaliza
		cuestionario.setCantidadAccessosMaxima(100);
		cuestionario.setCantidadAccesos(0);
		cuestionario.setUltimoIngreso(fechaCreacion);
		cuestionario.setFechaLimite(fechaCreacion.plusDays(7)); // tiene 1 semana para completarlo
		cuestionario.setTiempoMaximo(3600L); // 3600 segundos = 1 hora
		cuestionario.setClave(clave);
		cuestionario.setPuntajeObtenido(0);
		cuestionario.setCandidato(c);
		
		generarCompetenciasYFactoresCuestionario(f, cuestionario,competencias);
		
		return cuestionario;
	}

	private void generarCompetenciasYFactoresCuestionario(Funcion f, Cuestionario cuestionario, List<Competencia> competencias) throws SQLException
	{
		
		CompetenciaCuestionario comp = null;
		List<CompetenciaCuestionario> comps = new ArrayList<CompetenciaCuestionario>();
		FuncionDAO dao = new PostgresFuncion();
		
		for(Competencia c : competencias)
		{
			comp = new CompetenciaCuestionario();
			comp.setNombre(c.getNombre());
			comp.setDescripcion(c.getDescripcion());
			comp.setPuntajeNecesario(dao.findPuntaje(f,c).getPuntaje());
			comp.setCodigo(c.getCodigo());
			comp.setPuntajeObtenido(0);
			List<FactorCuestionario> factoresCuestionario = obtenerFactoresCuestionarios(c);
			comp.setFactores(factoresCuestionario);
			comps.add(comp);
		}
	}

	private List<FactorCuestionario> obtenerFactoresCuestionarios(Competencia c)
	{
		List<FactorCuestionario> factores = new ArrayList<FactorCuestionario>();
		
		c.getFactores().forEach(f -> {
			FactorCuestionario aux = new FactorCuestionario();
			aux.setNombre(f.getNombre());
			aux.setDescripcion(f.getDescripcion());
			aux.setCodigo(f.getCodigo());
			aux.setNroOrden(f.getNroOrden());
			aux.setPuntajeObtenido(0);
			factores.add(aux);
		});
		
		return factores;
	}

}
