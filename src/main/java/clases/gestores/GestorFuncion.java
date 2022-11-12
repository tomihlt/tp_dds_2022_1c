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
//			JOptionPane.showMessageDialog(null, "Error al obtener las empresas de la bdd", "Error",
//					JOptionPane.ERROR_MESSAGE);
//			e1.printStackTrace();
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
			Funcion f = fDao.findByCodigo(funcion.getCodigo());
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

}
