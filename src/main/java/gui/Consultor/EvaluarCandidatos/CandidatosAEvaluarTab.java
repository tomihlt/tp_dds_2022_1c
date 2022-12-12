package gui.Consultor.EvaluarCandidatos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import clases.dto.CandidatoBasicoDTO;
import gui.tableRenderersYTableModels.CandidatosAEvaluarTableModel;
import gui.tableRenderersYTableModels.EstandarCellRenderer;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CandidatosAEvaluarTab extends JPanel
{
	private JPanel panelBotones;
	private JButton eliminarButton;
	private PantallaElegirCandidatos invocador;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CandidatosAEvaluarTab(PantallaElegirCandidatos invocador)
	{
		this.invocador = invocador;
		initialize();
	}

	private void initialize()
	{
		setLayout(new BorderLayout(0, 0));

		panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		add(panelBotones, BorderLayout.SOUTH);

		eliminarButton = new JButton("Eliminar");
		eliminarButton.addActionListener(e -> eliminar());
		panelBotones.add(eliminarButton);

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new CandidatosAEvaluarTableModel(new Object[][] {}, new String[]
		{ "Apellido", "Nombre", "Número de candidato" }));
		table.setDefaultRenderer(Object.class, new EstandarCellRenderer());
		table.setDefaultRenderer(Integer.class, new EstandarCellRenderer());
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
	}

	private void eliminar()
	{
		if (table.getSelectedRowCount() < 1)
		{
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cadidato.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int[] filasSeleccionadas = table.getSelectedRows();
		List<CandidatoBasicoDTO> aux = obtenerCandidatosTabla(filasSeleccionadas);
		eliminarCandidatoTabla(aux);
	}
	
	private List<CandidatoBasicoDTO> obtenerCandidatosTabla(int[] filasSeleccionadas)
	{
		List<CandidatoBasicoDTO> aux = new ArrayList<CandidatoBasicoDTO>();
		
		for(int i = 0; i < filasSeleccionadas.length ; i++)
		{
		CandidatoBasicoDTO c = (CandidatoBasicoDTO) ((CandidatosAEvaluarTableModel) table.getModel())
				.getValueAt(filasSeleccionadas[i], 2);
		aux.add(c);
		}
		return aux;
	}

	private void eliminarCandidatoTabla(List<CandidatoBasicoDTO> aux)
	{
		for(CandidatoBasicoDTO c : aux)
			eliminarCandidatoTabla(c);
	}

	private void eliminarCandidatoTabla(CandidatoBasicoDTO aux)
	{
		CandidatosAEvaluarTableModel model = (CandidatosAEvaluarTableModel) table.getModel();
		for(int i = 0 ; i < table.getRowCount() ; i++)
		{
			if(((CandidatoBasicoDTO)model.getValueAt(i, 2)).equals(aux))
			{
				model.removeRow(i);
				break;
			}
		}
	}

	protected JTable getTable()
	{
		return table;
	}

	protected void setTable(JTable table)
	{
		this.table = table;
	}

	protected void agregarElementoTabla(CandidatoBasicoDTO c) throws CandidatoYaCargadoException
	{

		if (existeCandidatoEnTabla(c))
			throw new CandidatoYaCargadoException(
					"El candidato " + c.getApellido() + " " + c.getNombre() + " ya ha sido agregado.");

		CandidatosAEvaluarTableModel model = (CandidatosAEvaluarTableModel) table.getModel();
		Object[] row = new Object[]
		{ c.getApellido(), c.getNombre(), c };
		model.addRow(row);
	}

	private Boolean existeCandidatoEnTabla(CandidatoBasicoDTO c)
	{
		CandidatosAEvaluarTableModel model = (CandidatosAEvaluarTableModel) table.getModel();

		for (int i = 0; i < model.getRowCount(); i++)
			if (((CandidatoBasicoDTO) model.getValueAt(i, 2)).equals(c))
				return true;

		return false;
	}

	protected List<CandidatoBasicoDTO> obtenerCandidatos()
	{
		List<CandidatoBasicoDTO> candidatos = new ArrayList<CandidatoBasicoDTO>();
		
		CandidatosAEvaluarTableModel model = (CandidatosAEvaluarTableModel) table.getModel();
		
		for(int i = 0 ; i < model.getRowCount() ; i++)
			candidatos.add((CandidatoBasicoDTO)model.getValueAt(i, 2));
		
		return candidatos;
	}

}
