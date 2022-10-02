package gui.Consultor;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import gui.Main;

import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class PanelFunciones extends JPanel
{
	private Main wWindow;
	private JPanel panelBuscador;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_2;
	private JLabel lblNewLabel_7;
	private JButton buscarButton;
	private JLabel lblNewLabel_9;
	public Component verticalStrut;
	public Component verticalStrut_1;
	public Component verticalStrut_2;
	public JPanel panelDeDatos;
	public JPanel panelDeBotones;
	public JButton eliminarButton;
	public JButton modificarButton;
	public JButton nuevoButton;
	public Component horizontalStrut;
	public Component horizontalStrut_1;
	public JScrollPane scrollPane;
	public JTable table;
	public Component horizontalStrut_2;
	public Component horizontalStrut_3;
	public Component verticalStrut_3;

	/**
	 * Create the panel.
	 */
	public PanelFunciones(Main wWindow)
	{
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));
		
		panelBuscador = new JPanel();
		panelBuscador.setBorder(new LineBorder(Color.GRAY));
		add(panelBuscador, BorderLayout.NORTH);
		GridBagLayout gbl_panelBuscador = new GridBagLayout();
		gbl_panelBuscador.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBuscador.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBuscador.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBuscador.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBuscador.setLayout(gbl_panelBuscador);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.weighty = 0.5;
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
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panelBuscador.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panelBuscador.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panelBuscador.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.weightx = 0.1;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		panelBuscador.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombre de la función");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panelBuscador.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 2;
		panelBuscador.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.weightx = 0.1;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 2;
		panelBuscador.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Nombre de la empresa");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 7;
		gbc_lblNewLabel_6.gridy = 2;
		panelBuscador.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 2;
		panelBuscador.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_7.weightx = 0.5;
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
		gbc_buscarButton.fill = GridBagConstraints.VERTICAL;
		gbc_buscarButton.insets = new Insets(0, 0, 5, 5);
		gbc_buscarButton.gridx = 5;
		gbc_buscarButton.gridy = 4;
		panelBuscador.add(buscarButton, gbc_buscarButton);
		
		verticalStrut_2 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 5;
		gbc_verticalStrut_2.gridy = 5;
		panelBuscador.add(verticalStrut_2, gbc_verticalStrut_2);
		
		lblNewLabel_9 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 9;
		gbc_lblNewLabel_9.gridy = 6;
		panelBuscador.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		panelDeDatos = new JPanel();
		add(panelDeDatos, BorderLayout.CENTER);
		panelDeDatos.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelDeDatos.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nombre de la función", "Nombre de la empresa"
			}
		));
		table.getTableHeader().setReorderingAllowed(false);
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
		panelDeBotones.add(nuevoButton);

	}

}
