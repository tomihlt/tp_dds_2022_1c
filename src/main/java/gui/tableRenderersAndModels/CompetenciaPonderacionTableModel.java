package gui.tableRenderersAndModels;

import javax.swing.table.DefaultTableModel;

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
			return String.class;
		else
			return Integer.class;
	}
	
}
