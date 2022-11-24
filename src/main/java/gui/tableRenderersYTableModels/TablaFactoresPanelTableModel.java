package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.EmpresaDTO;
import clases.dto.FactorIdCodigoDTO;
import clases.dto.FuncionIdCodigoDTO;

public class TablaFactoresPanelTableModel extends DefaultTableModel
{
	private String[] titulos;
	private Object[][] datos;
	
	public TablaFactoresPanelTableModel(Object[][] datos, String[] titulos)
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
			return FactorIdCodigoDTO.class;
		else if(columnIndex == 1)
			return String.class;
		else
			return EmpresaDTO.class;
	}
}
