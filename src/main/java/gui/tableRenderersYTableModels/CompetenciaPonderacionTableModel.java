package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.CompetenciaBasicaDTO;

/*
 * Este modelo de tabla se usa en:
 * VentanaAltaFuncion
 */

public class CompetenciaPonderacionTableModel extends DefaultTableModel
{
	private String[] titulos;
	private Object[][] datos;
	
	public CompetenciaPonderacionTableModel(Object[][] datos, String[] titulos)
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
		if(columnIndex == 0)
			return CompetenciaBasicaDTO.class;
		else
			return Integer.class;
	}
	
}
