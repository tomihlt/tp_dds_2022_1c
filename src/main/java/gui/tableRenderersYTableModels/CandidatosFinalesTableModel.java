package gui.tableRenderersYTableModels;

import javax.swing.table.DefaultTableModel;

import clases.dto.CandidatoBasicoDTO;
import clases.dto.CandidatoNormalDTO;

public class CandidatosFinalesTableModel extends DefaultTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] titulos;
	private Object[][] datos;
	
	public CandidatosFinalesTableModel(Object[][] datos, String[] titulos)
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
			return CandidatoNormalDTO.class;
		else if(columnIndex == 3)
			return Integer.class;
		else
			return Object.class;
	}
}
