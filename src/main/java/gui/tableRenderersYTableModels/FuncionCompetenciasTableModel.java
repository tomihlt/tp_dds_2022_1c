package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionIdCodigoDTO;

public class FuncionCompetenciasTableModel extends DefaultTableModel
{
	
	private String[] titulos;
	private Object[][] datos;
	
	public FuncionCompetenciasTableModel(Object[][] datos, String[] titulos)
	{
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		if (columnIndex == 0)
			return CompetenciaPuntajeNombreDTO.class;
		else
			return Integer.class;
	}
	
}
