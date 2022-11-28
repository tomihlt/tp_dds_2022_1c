package gui.Consultor.EvaluarCandidatos;

import java.util.List;

import javax.swing.JPanel;
import clases.dto.CandidatoBasicoDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionNombreIdDTO;
import gui.Main;
import gui.tableRenderersYTableModels.EstandarCellRenderer;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaSeleccionarFuncion extends JPanel
{
	private Main wWindow;
	private PanelEvaluarCandidatos panel;
	private JPanel pantallAnterior;
	private List<CandidatoBasicoDTO> candidatos;
	private JPanel panelNorte;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JPanel panelBuscador;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox<EmpresaDTO> empresaCBx;
	private JLabel lblNewLabel_2;
	private JComboBox<FuncionNombreIdDTO> funcionCBx;
	private JLabel lblNewLabel_3;
	private Component verticalStrut_2;
	private Component horizontalStrut_2;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private JPanel panelDeDatos;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panelDeBotones;
	private JButton anteriorButton;
	private Component horizontalStrut_5;
	private JLabel lblNewLabel_4;
	private JButton siguienteButton;
	private Component horizontalStrut_6;
	private Component horizontalStrut_7;

	/**
	 * Create the panel.
	 */
	public PantallaSeleccionarFuncion(Main wWindow, PanelEvaluarCandidatos panel, JPanel pantallaAnterior)
	{
		this.wWindow = wWindow;
		this.panel = panel;
		this.pantallAnterior = pantallaAnterior;
		initialize();
	}

	private void initialize()
	{
		setLayout(new BorderLayout(0, 0));

		panelNorte = new JPanel();
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));

		horizontalStrut = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut, BorderLayout.WEST);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut_1, BorderLayout.EAST);

		verticalStrut = Box.createVerticalStrut(20);
		panelNorte.add(verticalStrut, BorderLayout.NORTH);

		verticalStrut_1 = Box.createVerticalStrut(20);
		panelNorte.add(verticalStrut_1, BorderLayout.SOUTH);

		panelBuscador = new JPanel();
		panelBuscador.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelNorte.add(panelBuscador, BorderLayout.CENTER);
		GridBagLayout gbl_panelBuscador = new GridBagLayout();
		gbl_panelBuscador.columnWidths = new int[]
		{ 0, 0, 0, 152, 0, 0 };
		gbl_panelBuscador.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelBuscador.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelBuscador.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBuscador.setLayout(gbl_panelBuscador);

		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 3;
		gbc_verticalStrut_4.gridy = 0;
		panelBuscador.add(verticalStrut_4, gbc_verticalStrut_4);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelBuscador.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("Nombre de la empresa");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panelBuscador.add(lblNewLabel_1, gbc_lblNewLabel_1);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 2;
		panelBuscador.add(horizontalStrut_2, gbc_horizontalStrut_2);

		empresaCBx = new JComboBox<EmpresaDTO>();
		GridBagConstraints gbc_empresaCBx = new GridBagConstraints();
		gbc_empresaCBx.insets = new Insets(0, 0, 5, 5);
		gbc_empresaCBx.fill = GridBagConstraints.HORIZONTAL;
		gbc_empresaCBx.gridx = 3;
		gbc_empresaCBx.gridy = 2;
		panelBuscador.add(empresaCBx, gbc_empresaCBx);

		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 3;
		gbc_verticalStrut_2.gridy = 3;
		panelBuscador.add(verticalStrut_2, gbc_verticalStrut_2);

		lblNewLabel_2 = new JLabel("Nombre de la función");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panelBuscador.add(lblNewLabel_2, gbc_lblNewLabel_2);

		funcionCBx = new JComboBox<FuncionNombreIdDTO>();
		GridBagConstraints gbc_funcionCBx = new GridBagConstraints();
		gbc_funcionCBx.insets = new Insets(0, 0, 5, 5);
		gbc_funcionCBx.fill = GridBagConstraints.HORIZONTAL;
		gbc_funcionCBx.gridx = 3;
		gbc_funcionCBx.gridy = 4;
		panelBuscador.add(funcionCBx, gbc_funcionCBx);

		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 3;
		gbc_verticalStrut_3.gridy = 5;
		panelBuscador.add(verticalStrut_3, gbc_verticalStrut_3);

		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 0.5;
		gbc_lblNewLabel_3.weightx = 0.5;
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 6;
		panelBuscador.add(lblNewLabel_3, gbc_lblNewLabel_3);

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		add(horizontalStrut_3, BorderLayout.WEST);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		add(horizontalStrut_4, BorderLayout.EAST);

		panelDeDatos = new JPanel();
		add(panelDeDatos, BorderLayout.CENTER);
		panelDeDatos.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panelDeDatos.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[]
		{ "Competencia", "Ponderación" }));
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultRenderer(Object.class, new EstandarCellRenderer());
		table.setDefaultRenderer(Integer.class, new EstandarCellRenderer());
		scrollPane.setViewportView(table);

		panelDeBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDeBotones.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panelDeBotones, BorderLayout.SOUTH);

		anteriorButton = new JButton("Anterior");
		anteriorButton.addActionListener(e -> ((PanelEvaluarCandidatos) panel).setCurrentMenu(pantallAnterior));
		panelDeBotones.add(anteriorButton);

		horizontalStrut_5 = Box.createHorizontalStrut(5);
		panelDeBotones.add(horizontalStrut_5);

		lblNewLabel_4 = new JLabel("2/3");
		panelDeBotones.add(lblNewLabel_4);

		horizontalStrut_7 = Box.createHorizontalStrut(5);
		panelDeBotones.add(horizontalStrut_7);

		siguienteButton = new JButton("Siguiente");
		siguienteButton.addActionListener(e -> siguiente());
		panelDeBotones.add(siguienteButton);

		horizontalStrut_6 = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut_6);
	}

	private void siguiente()
	{
		PantallaFinalizar pantallaSiguiente = new PantallaFinalizar(wWindow,panel,this);
		panel.setCurrentMenu(pantallaSiguiente);
	}

}
