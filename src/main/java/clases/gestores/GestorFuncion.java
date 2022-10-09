package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.dao.interfaces.EmpresaDAO;
import clases.dao.postgres.PostgresEmpresa;
import clases.dto.EmpresaDTO;
import clases.tablas.Empresa;

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
			empresas.add(aux);
		}

		return empresas;
	}

}
