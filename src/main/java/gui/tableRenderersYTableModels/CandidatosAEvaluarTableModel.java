package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.CandidatoIdNumeroDTO;

public class CandidatosAEvaluarTableModel extends DefaultTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] titulos;
	private Object[][] datos;
	
	public CandidatosAEvaluarTableModel(Object[][] datos, String[] titulos)
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
			return String.class;
		else if(columnIndex == 1)
			return String.class;
		else
			return CandidatoIdNumeroDTO.class;
	}
}
