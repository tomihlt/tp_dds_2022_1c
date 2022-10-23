package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import clases.dao.interfaces.CompetenciaDAO;
import clases.dao.interfaces.EmpresaDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresCompetencia;
import clases.dao.postgres.PostgresEmpresa;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionCndeDTO;
import clases.entidades.Competencia;
import clases.entidades.Empresa;
import clases.entidades.Funcion;
import clases.entidades.PuntajeNecesario;

public class GestorFuncion
{

	public List<EmpresaDTO> getAllEmpresas()
	{
		List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>();

		EmpresaDAO dao = new PostgresEmpresa();
		List<Empresa> emps = new ArrayList<Empresa>();
		try
		{
			emps = dao.getAll();
		} catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "Error al obtener las empresas de la bdd", "Error",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
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
		List<String> nombresCompetencias = competenciasDeLaFuncion.stream().map(c -> c.getNombre())
				.collect(Collectors.toList());
		CompetenciaDAO cDao = new PostgresCompetencia();
		try
		{
			List<Competencia> listaDeCompetencias = cDao.findByName(nombresCompetencias);
			PuntajeNecesario p = null;
			for (Competencia c : listaDeCompetencias)
			{
				p = new PuntajeNecesario();
				p.setFuncion(funcion);
				for (CompetenciaPuntajeNombreDTO d : competenciasDeLaFuncion)
				{
					if (d.getNombre().equals(c.getNombre()))
					{
						p.setCompetencia(c);
						p.setPuntaje(d.getPonderacion());
						funcion.addCompetencia(p);
					}
				}
			}
			funcion.setNombre(funcionSinCompetencias.getNombre());
			funcion.setCodigo(funcionSinCompetencias.getCodigo());
			funcion.setDescripcion(funcionSinCompetencias.getDescripcion());
			funcion.setEliminado(false);
			EmpresaDAO eDao = new PostgresEmpresa();
			Empresa e = eDao.findByName(funcionSinCompetencias.getEmpresa());
			funcion.setEmpresa(e);
			FuncionDAO fDao = new PostgresFuncion();
			fDao.add(funcion);
		} catch (SQLException e)
		{
			throw e;
		}
	}

	public void addEmpresa(EmpresaDTO e) throws SQLException
	{
		EmpresaDAO empDao = new PostgresEmpresa();
		Empresa emp = new Empresa();
		emp.setNombre(e.getNombre());
		try
		{
			empDao.add(emp);
		} catch (SQLException e1)
		{
			throw e1;
		}
	}

}
