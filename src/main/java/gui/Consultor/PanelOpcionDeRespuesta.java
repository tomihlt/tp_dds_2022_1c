package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import gui.Main;
import gui.tableRenderersYTableModels.EstandarCellRenderer;
import gui.tableRenderersYTableModels.TablaFactoresPanelTableModel;

public class PanelOpcionDeRespuesta extends JPanel
{
	
	private Main wWindow;
	private JPanel panelDeDatos;
	private JPanel panelDeBotones;
	private JButton eliminarButton;
	private JButton modificarButton;
	private JButton nuevoButton;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private JScrollPane scrollPane;
	private JTable table;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component verticalStrut_3;
	private JPanel panelNorte;
	private JPanel panelBuscador;
	private JLabel lblNewLabel;
	private Component verticalStrut;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JTextField nombreFuncionTxt;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private Component verticalStrut_1;
	private JButton buscarButton;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_8;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private Component verticalStrut_4;
	
	public PanelOpcionDeRespuesta(Main wWindow)
	{
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));

		panelDeDatos = new JPanel();
		add(panelDeDatos, BorderLayout.CENTER);
		panelDeDatos.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panelDeDatos.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new TablaFactoresPanelTableModel(new Object[][] {}, new String[]
		{ "Nombre", "Descripción" }));
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultRenderer(Object.class, new EstandarCellRenderer());
		table.setDefaultRenderer(Integer.class, new EstandarCellRenderer());
		scrollPane.setViewportView(table);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelDeDatos.add(horizontalStrut_2, BorderLayout.WEST);

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		panelDeDatos.add(horizontalStrut_3, BorderLayout.EAST);

		verticalStrut_3 = Box.createVerticalStrut(20);
		panelDeDatos.add(verticalStrut_3, BorderLayout.NORTH);

		panelDeBotones = new JPanel();
		add(panelDeBotones, BorderLayout.SOUTH);
		panelDeBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		eliminarButton = new JButton("Eliminar");
		panelDeBotones.add(eliminarButton);

		horizontalStrut = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut);

		modificarButton = new JButton("Modificar");
		panelDeBotones.add(modificarButton);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut_1);

		nuevoButton = new JButton("Nuevo");
		nuevoButton.addActionListener(e -> {
			VentanaAltaOpcionDeRespuesta ventana = new VentanaAltaOpcionDeRespuesta(this.wWindow, this);
			ventana.setVisible(true);
		});
		panelDeBotones.add(nuevoButton);

		panelNorte = new JPanel();
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));

		panelBuscador = new JPanel();
		panelBuscador.setBorder(new LineBorder(Color.GRAY));
		panelNorte.add(panelBuscador, BorderLayout.CENTER);
		GridBagLayout gbl_panelBuscador = new GridBagLayout();
		gbl_panelBuscador.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelBuscador.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelBuscador.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelBuscador.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBuscador.setLayout(gbl_panelBuscador);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelBuscador.add(lblNewLabel, gbc_lblNewLabel);

		verticalStrut = Box.createVerticalStrut(25);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 1;
		panelBuscador.add(verticalStrut, gbc_verticalStrut);

		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panelBuscador.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_4 = new JLabel("Nombre de la opción");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panelBuscador.add(lblNewLabel_4, gbc_lblNewLabel_4);

		nombreFuncionTxt = new JTextField();
		nombreFuncionTxt.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 2;
		panelBuscador.add(nombreFuncionTxt, gbc_textField_1);

		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weightx = 0.1;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 2;
		panelBuscador.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weightx = 0.5;
		gbc_lblNewLabel_7.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 9;
		gbc_lblNewLabel_7.gridy = 2;
		panelBuscador.add(lblNewLabel_7, gbc_lblNewLabel_7);

		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 5;
		gbc_verticalStrut_1.gridy = 3;
		panelBuscador.add(verticalStrut_1, gbc_verticalStrut_1);
		
		buscarButton = new JButton("Buscar");

		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.gridwidth = 11;
		gbc_buscarButton.fill = GridBagConstraints.VERTICAL;
		gbc_buscarButton.insets = new Insets(0, 0, 5, 5);
		gbc_buscarButton.gridx = 0;
		gbc_buscarButton.gridy = 4;
		panelBuscador.add(buscarButton, gbc_buscarButton);

		verticalStrut_2 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 5;
		gbc_verticalStrut_2.gridy = 5;
		panelBuscador.add(verticalStrut_2, gbc_verticalStrut_2);

		lblNewLabel_8 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 9;
		gbc_lblNewLabel_8.gridy = 6;
		panelBuscador.add(lblNewLabel_8, gbc_lblNewLabel_8);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut_4, BorderLayout.WEST);

		horizontalStrut_5 = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut_5, BorderLayout.EAST);

		verticalStrut_4 = Box.createVerticalStrut(20);
		panelNorte.add(verticalStrut_4, BorderLayout.NORTH);
	}

}
