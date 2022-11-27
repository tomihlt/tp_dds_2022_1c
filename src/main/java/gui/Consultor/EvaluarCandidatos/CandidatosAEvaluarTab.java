package gui.Consultor.EvaluarCandidatos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import gui.tableRenderersYTableModels.CandidatosAEvaluarTableModel;

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
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		add(panelBotones, BorderLayout.SOUTH);
		
		eliminarButton = new JButton("Eliminar");
		panelBotones.add(eliminarButton);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new CandidatosAEvaluarTableModel(
			new Object[][] {
			},
			new String[] {
				"Apellido", "Nombre", "Número de candidato"
			}
		));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
	}
	
	protected JTable getTable()
	{
		return table;
	}

	protected void setTable(JTable table)
	{
		this.table = table;
	}
	
}
