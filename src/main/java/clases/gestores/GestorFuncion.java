package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.dao.interfaces.CompetenciaDAO;
import clases.dao.interfaces.EmpresaDAO;
import clases.dao.interfaces.EvaluacionDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresCompetencia;
import clases.dao.postgres.PostgresEmpresa;
import clases.dao.postgres.PostgresEvaluacion;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionBasicaDTO;
import clases.dto.FuncionCndeDTO;
import clases.dto.FuncionDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.entidades.Competencia;
import clases.entidades.Empresa;
import clases.entidades.Evaluacion;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public class GestorFuncion
{

	public List<EmpresaDTO> getAllEmpresas() throws SQLException
	{
		List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>();

		EmpresaDAO dao = new PostgresEmpresa();
		List<Empresa> emps = new ArrayList<Empresa>();
		try
		{
			emps = dao.getAll();
		} catch (SQLException e1)
		{
			throw e1;
		}
		for (Empresa e : emps)
		{
			EmpresaDTO aux = new EmpresaDTO();
			aux.setNombre(e.getNombre());
			aux.setId(e.getId());
			empresas.add(aux);
		}

		return empresas;
	}

	public void guardarFuncion(FuncionCndeDTO funcionSinCompetencias,
			List<CompetenciaPuntajeNombreDTO> competenciasDeLaFuncion) throws SQLException
	{
		Funcion funcion = new Funcion();

		EmpresaDAO eDao = new PostgresEmpresa();
		CompetenciaDAO cDao = new PostgresCompetencia();
		FuncionDAO fDao = new PostgresFuncion();

		Empresa empresaFuncion = null;
		List<PuntajeNecesario> puntajes = new ArrayList<PuntajeNecesario>();

		empresaFuncion = eDao.find(funcionSinCompetencias.getEmpresa().getId()); // Aca puede dar SQLException

		for (CompetenciaPuntajeNombreDTO c : competenciasDeLaFuncion)
		{
			PuntajeNecesario puntaje = new PuntajeNecesario();
			Competencia t_Competencia = cDao.find(c.getId());

			puntaje.setFuncion(funcion);
			puntaje.setCompetencia(t_Competencia);
			puntaje.setPuntaje(c.getPonderacion());
			puntajes.add(puntaje);
		}

		funcion.setCodigo(funcionSinCompetencias.getCodigo());
		funcion.setDescripcion(funcionSinCompetencias.getDescripcion());
		funcion.setEliminado(false);
		funcion.setEmpresa(empresaFuncion);
		funcion.setNombre(funcionSinCompetencias.getNombre());
		funcion.setPuntajeNecesarioPorCompetencia(puntajes);

		fDao.save(funcion); // Aca se puede dar un SQLException, que se le hace un throw

	}

	public void addEmpresa(EmpresaDTO e) throws SQLException
	{
		EmpresaDAO empDao = new PostgresEmpresa();
		Empresa emp = new Empresa();
		emp.setNombre(e.getNombre());
		try
		{
			empDao.save(emp);
		} catch (SQLException e1)
		{
			throw e1;
		}
	}

	public List<FuncionDTO> buscarFuncionesConEmpresa(Integer codigo, String nombre, String empresa) throws SQLException
	{
		FuncionDAO fDao = new PostgresFuncion();
		try
		{
			List<Funcion> funciones = fDao.findByFilters(codigo, nombre, empresa);
			funciones.forEach(f -> {
				try
				{
					fDao.setEmpresa(f);
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			});

			List<FuncionDTO> funcionesDto = new ArrayList<FuncionDTO>();
			FuncionDTO funcion = null;
			EmpresaDTO e = null;

			for (Funcion f : funciones)
			{
				funcion = new FuncionDTO();
				e = new EmpresaDTO();

				e.setId(f.getEmpresa().getId());
				e.setNombre(f.getEmpresa().getNombre());

				funcion.setId(f.getId());
				funcion.setCodigo(f.getCodigo());
				funcion.setNombre(f.getNombre());
				funcion.setEmpresa(e);

				funcionesDto.add(funcion);

			}

			return funcionesDto;
		} catch (SQLException e)
		{
			throw e;
		}

	}

	public Boolean eliminarFuncion(FuncionBasicaDTO funcion) throws SQLException
	{

		FuncionDAO fDao = new PostgresFuncion();
		EvaluacionDAO eDao = new PostgresEvaluacion();

		try
		{
			Funcion f = fDao.find(funcion.getId());
			List<Evaluacion> evaluaciones = eDao.findEvaluacionesByFuncion(f);
			
			if (!evaluaciones.isEmpty())
				return false;
			
			f.setEliminado(true);
			fDao.update(f);
			
			return true;
			
		} catch (SQLException e)
		{
			throw e;
		}

	}

	public FuncionCndeDTO buscarFuncion(FuncionDTO f) throws SQLException
	{
		FuncionCndeDTO func = new FuncionCndeDTO();
		FuncionDAO fDao = new PostgresFuncion();
		
		try
		{			
			Funcion fAux = fDao.find(f.getId());
			EmpresaDAO eDao = new PostgresEmpresa();
			Empresa e = eDao.find(f.getEmpresa().getId());
			fAux.setEmpresa(e);
			
			func.setId(fAux.getId());
			func.setDescripcion(fAux.getDescripcion());
			func.setCodigo(fAux.getCodigo());
			func.setNombre(fAux.getNombre());
			
			EmpresaDTO emp = new EmpresaDTO();
			emp.setId(e.getId());
			emp.setNombre(e.getNombre());
			
			func.setEmpresa(emp);
			
		} catch (SQLException e)
		{
			throw e;
		}		
		
		return func;
	}

	public List<CompetenciaPuntajeNombreDTO> buscarPuntajes(FuncionDTO f) throws SQLException
	{
		List<CompetenciaPuntajeNombreDTO> puntajesDto = new ArrayList<CompetenciaPuntajeNombreDTO>();
		
		FuncionDAO fDao = new PostgresFuncion();
		Funcion func;
		try
		{
			func = fDao.find(f.getId());
			List<PuntajeNecesario> puntajes = fDao.findPuntajes(func);
			puntajes.forEach(p -> {
				CompetenciaPuntajeNombreDTO aux = new CompetenciaPuntajeNombreDTO();
				aux.setId(p.getCompetencia().getId());
				aux.setNombre(p.getCompetencia().getNombre());
				aux.setPonderacion(p.getPuntaje());
				puntajesDto.add(aux);
			});
		} catch (SQLException e)
		{
			throw e;
		}
		
		return puntajesDto;
	}

	public void actualizarFuncion(FuncionCndeDTO funcionSinCompetencias,
			List<CompetenciaPuntajeNombreDTO> competenciasDeLaFuncion) throws SQLException
	{
		FuncionDAO fDao = new PostgresFuncion();
		Funcion f;
		
		f = fDao.findByCodigo(funcionSinCompetencias.getCodigo());
		
		f.setCodigo(funcionSinCompetencias.getCodigo());
		f.setDescripcion(funcionSinCompetencias.getDescripcion());
		f.setNombre(funcionSinCompetencias.getNombre());
		f.setEliminado(false);
		
		CompetenciaDAO cDao = new PostgresCompetencia();
		List<PuntajeNecesario> puntajes = new ArrayList<PuntajeNecesario>();
		Competencia comp = null;
		PuntajeNecesario p = null;
		
		for(CompetenciaPuntajeNombreDTO c : competenciasDeLaFuncion)
		{
			comp = cDao.find(c.getId());
			p = new PuntajeNecesario();
			p.setFuncion(f);
			p.setCompetencia(comp);
			p.setPuntaje(c.getPonderacion());
			puntajes.add(p);
		}
		
		f.setPuntajeNecesarioPorCompetencia(puntajes);
		
		EmpresaDAO eDao = new PostgresEmpresa();
		Empresa e = eDao.find(funcionSinCompetencias.getEmpresa().getId());
		f.setEmpresa(e);
		
		fDao.updateFuncionConPuntajesYEmpresa(f);
		
		
	}

	public List<FuncionNombreIdDTO> findFuncionesByEmpresa(EmpresaDTO e) throws SQLException
	{
		FuncionDAO fDao = new PostgresFuncion();
		List<Funcion> funciones = fDao.findFuncionesByIdEmpresa(e.getId());
		
		List<FuncionNombreIdDTO> funcionesDto = new ArrayList<FuncionNombreIdDTO>();
		
		FuncionNombreIdDTO aux = null;
		for(Funcion f : funciones)
		{
			aux = new FuncionNombreIdDTO();
			aux.setId(f.getId());
			aux.setNombre(f.getNombre());
			funcionesDto.add(aux);
		}
		
		return funcionesDto;
	}

	public List<CompetenciaPuntajeNombreDTO> findCompetenciasByFuncion(FuncionNombreIdDTO func) throws SQLException
	{
		FuncionDAO fDao = new PostgresFuncion();
		Funcion f = fDao.find(func.getId(),true); //TODO agregar parametro para cargar puntajes
		
		List<PuntajeNecesario> pjNecesario = f.getPuntajeNecesarioPorCompetencia();
		
		List<CompetenciaPuntajeNombreDTO> puntajes = new ArrayList<CompetenciaPuntajeNombreDTO>();
		CompetenciaPuntajeNombreDTO puntaje = null;
		
		for(PuntajeNecesario p : pjNecesario)
		{
			puntaje = new CompetenciaPuntajeNombreDTO();
			puntaje.setId(p.getCompetencia().getId());
			puntaje.setNombre(p.getCompetencia().getNombre());
			puntaje.setPonderacion(p.getPuntaje());
			puntajes.add(puntaje);
		}
		
		return puntajes;
	}

}
