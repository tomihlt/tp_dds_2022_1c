package gui.Consultor.EvaluarCandidatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import gui.Main;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaElegirCandidatos extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Main wWindow;
	private PanelEvaluarCandidatos panel;
	private JPanel panelDeDatos;
	private JPanel panelDeBotones;
	private JPanel panelNorte;
	private JPanel panelBuscador;
	private JLabel lblNewLabel;
	private Component verticalStrut;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField apellidoTxt;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField nombreTxt;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField numeroTxt;
	private JLabel lblNewLabel_7;
	private Component verticalStrut_1;
	private JButton buscarButton;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_8;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private Component verticalStrut_4;
	private JLabel lblNewLabel_9;
	private JButton siguienteButton;
	private Component horizontalStrut;
	private JTabbedPane agregarEliminarPane;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component verticalStrut_3;
	// JTables y Tabs
	private CandidatosTab panelA = new CandidatosTab(this);
	private CandidatosAEvaluarTab panelB = new CandidatosAEvaluarTab(this);
	@SuppressWarnings("unused")
	private JTable tablaA = panelA.getTable();
	@SuppressWarnings("unused")
	private JTable tablaB = panelB.getTable();

	/**
	 * Create the panel.
	 */
	public PantallaElegirCandidatos(Main wWindow, PanelEvaluarCandidatos panel)
	{
		this.wWindow = wWindow;
		this.panel = panel;
		initialize();
	}
	
	private void initialize()
	{
		setLayout(new BorderLayout(0, 0));

		panelDeDatos = new JPanel();
		add(panelDeDatos, BorderLayout.CENTER);
		panelDeDatos.setLayout(new BorderLayout(0, 0));
		
		agregarEliminarPane = new JTabbedPane(JTabbedPane.TOP);
		agregarEliminarPane.addTab("Candidatos", null, new CandidatosTab(this), null);
		agregarEliminarPane.addTab("Candidatos a evaluar", null, new CandidatosAEvaluarTab(this), null);
		panelDeDatos.add(agregarEliminarPane, BorderLayout.CENTER);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelDeDatos.add(horizontalStrut_1, BorderLayout.WEST);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelDeDatos.add(horizontalStrut_2, BorderLayout.EAST);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		panelDeDatos.add(verticalStrut_3, BorderLayout.NORTH);

		panelDeBotones = new JPanel();
		add(panelDeBotones, BorderLayout.SOUTH);
		panelDeBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 10));
		
		lblNewLabel_9 = new JLabel("1/3");
		panelDeBotones.add(lblNewLabel_9);
		
		siguienteButton = new JButton("Siguiente");
		siguienteButton.addActionListener(e -> siguiente());
		panelDeBotones.add(siguienteButton);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut);

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

		lblNewLabel_2 = new JLabel("Apellido");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panelBuscador.add(lblNewLabel_2, gbc_lblNewLabel_2);

		apellidoTxt = new JTextField();
		apellidoTxt.setColumns(10);
		GridBagConstraints gbc_apellidoTxt = new GridBagConstraints();
		gbc_apellidoTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_apellidoTxt.gridx = 2;
		gbc_apellidoTxt.gridy = 2;
		panelBuscador.add(apellidoTxt, gbc_apellidoTxt);

		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weightx = 0.1;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		panelBuscador.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panelBuscador.add(lblNewLabel_4, gbc_lblNewLabel_4);

		nombreTxt = new JTextField();
		nombreTxt.setColumns(10);
		GridBagConstraints gbc_nombreTxt = new GridBagConstraints();
		gbc_nombreTxt.fill = GridBagConstraints.BOTH;
		gbc_nombreTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTxt.gridx = 5;
		gbc_nombreTxt.gridy = 2;
		panelBuscador.add(nombreTxt, gbc_nombreTxt);

		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weightx = 0.1;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 2;
		panelBuscador.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Número de candidato");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 7;
		gbc_lblNewLabel_6.gridy = 2;
		panelBuscador.add(lblNewLabel_6, gbc_lblNewLabel_6);

		numeroTxt = new JTextField();
		numeroTxt.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				int key = e.getKeyChar();

				if (key < 48 || key > 57)
				{
					e.consume();
				}
			}
		});
		numeroTxt.setColumns(10);
		GridBagConstraints gbc_numeroTxt = new GridBagConstraints();
		gbc_numeroTxt.fill = GridBagConstraints.BOTH;
		gbc_numeroTxt.insets = new Insets(0, 0, 5, 5);
		gbc_numeroTxt.gridx = 8;
		gbc_numeroTxt.gridy = 2;
		panelBuscador.add(numeroTxt, gbc_numeroTxt);

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

	private void siguiente()
	{
		PantallaSeleccionarFuncion pantallaSiguiente = new PantallaSeleccionarFuncion(wWindow,panel,this);
		panel.setCurrentMenu(pantallaSiguiente);
	}

}
