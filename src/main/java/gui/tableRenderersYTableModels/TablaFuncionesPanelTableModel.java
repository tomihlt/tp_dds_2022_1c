package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.CompetenciaBasicaDTO;
import clases.dto.EmpresaDTO;

public class TablaFuncionesPanelTableModel extends DefaultTableModel
{
	
	private String[] titulos;
	private Object[][] datos;
	
	public TablaFuncionesPanelTableModel(Object[][] datos, String[] titulos)
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
			return Integer.class;
		else if(columnIndex == 1)
			return String.class;
		else
			return EmpresaDTO.class;
	}
	
}
