package gui.tableRenderersYTableModels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import clases.dto.CompetenciaBasicaDTO;

public class CompetenciaPonderacionCellRenderer extends DefaultTableCellRenderer
{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		
		setBackground(row % 2 == 0 ? new Color(255,255,255) : new Color(238,238,238));
		
		setHorizontalAlignment(SwingConstants.CENTER);
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

}
