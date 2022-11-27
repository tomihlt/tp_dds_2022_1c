package gui.Consultor.EvaluarCandidatos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.tableRenderersYTableModels.CandidatosAEvaluarTableModel;
import javax.swing.ListSelectionModel;

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
		panelBotones.add(agregarButton);

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new CandidatosAEvaluarTableModel(new Object[][] {}, new String[]
		{ "Apellido", "Nombre", "Número de candidato" }));
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
