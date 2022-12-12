package gui.Consultor.EvaluarCandidatos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.dto.CandidatoBasicoDTO;
import gui.tableRenderersYTableModels.CandidatosAEvaluarTableModel;
import gui.tableRenderersYTableModels.EstandarCellRenderer;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CandidatosTab extends JPanel
{
	private JPanel panelBotones;
	private JButton agregarButton;
	private PantallaElegirCandidatos invocador;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CandidatosTab(PantallaElegirCandidatos invocador)
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

		agregarButton = new JButton("Agregar");
		agregarButton.addActionListener(e -> agregar());
		panelBotones.add(agregarButton);

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

	private void agregar()
	{
		if (table.getSelectedRowCount() < 1)
		{
			JOptionPane.showMessageDialog(this, "Debe seleccionar un candidato.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}	
		int[] filasSeleccionadas = table.getSelectedRows();
		List<CandidatoBasicoDTO> candidatos = obtenerCandidatosTabla(filasSeleccionadas);
		
		invocador.cargarCandidatoTablaB(candidatos);
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

	protected JTable getTable()
	{
		return table;
	}

	protected void setTable(JTable table)
	{
		this.table = table;
	}

	protected void agregarElementoTabla(CandidatoBasicoDTO c)
	{
		CandidatosAEvaluarTableModel model = (CandidatosAEvaluarTableModel) table.getModel();
		Object[] row = new Object[]
		{ c.getApellido(), c.getNombre(), c };
		model.addRow(row);
	}

	public void limpiarTabla()
	{
		this.table.setModel(new CandidatosAEvaluarTableModel(new Object[][] {}, new String[]
		{ "Apellido", "Nombre", "Número de candidato" }));
	}
}
