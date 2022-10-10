package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import gui.Main;
import gui.tableRenderersAndModels.CompetenciaPonderacionCellRenderer;
import gui.tableRenderersAndModels.CompetenciaPonderacionTableModel;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.dto.CompetenciaBasicaDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionCndeDTO;
import clases.gestores.GestorCompetencia;
import clases.gestores.GestorFuncion;
import clases.tablas.Empresa;

import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAltaFuncion extends JDialog
{
	private Main wWindow;
	private JPanel invocador;
	/*
	 * Utilizo una lista de competencias para no consultar a la bdd cada vez que
	 * quiero añadir una competencia a la nueva funcion
	 */
	private List<CompetenciaBasicaDTO> competenciasBasicasDTO;

	private JPanel panelBotones;
	private JButton cancelarButton;
	private JButton aceptarButton;
	private JPanel panelDeContenido;
	private JPanel panelCargaDeDatosBasicos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField codigoTxt;
	private Component verticalStrut;
	private JLabel lblNewLabel_2;
	private JTextField descripcionTxt;
	private Component horizontalStrut;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField nombreFuncionTxt;
	private JComboBox<String> empresaCbx;
	private JLabel lblNewLabel_5;
	private Component verticalStrut_1;
	private JPanel panelTablaDecompetencias;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panelBotonesTabla;
	private JButton agregarButton;
	private JButton eliminarButton;
	private JLabel agregarEmpresaLabel;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			VentanaAltaFuncion dialog = new VentanaAltaFuncion();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public VentanaAltaFuncion(Main wWindow, JPanel invocador)
	{
		super(wWindow, "Dar de alta función", Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(wWindow);
		this.wWindow = wWindow;
		this.invocador = invocador;
		setBounds(100, 100, 671, 416);

		panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(20);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(e -> dispose());
		panelBotones.add(cancelarButton);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.addActionListener(e -> crearFuncion());
		panelBotones.add(aceptarButton);

		panelDeContenido = new JPanel();
		getContentPane().add(panelDeContenido, BorderLayout.CENTER);
		panelDeContenido.setLayout(new BoxLayout(panelDeContenido, BoxLayout.Y_AXIS));

		panelCargaDeDatosBasicos = new JPanel();
		panelDeContenido.add(panelCargaDeDatosBasicos);
		GridBagLayout gbl_panelCargaDeDatosBasicos = new GridBagLayout();
		gbl_panelCargaDeDatosBasicos.columnWidths = new int[]
		{ 0, 0, 140, 0, 0, 154, 0, 0, 0 };
		gbl_panelCargaDeDatosBasicos.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0 };
		gbl_panelCargaDeDatosBasicos.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCargaDeDatosBasicos.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCargaDeDatosBasicos.setLayout(gbl_panelCargaDeDatosBasicos);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelCargaDeDatosBasicos.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panelCargaDeDatosBasicos.add(lblNewLabel_1, gbc_lblNewLabel_1);

		codigoTxt = new JTextField();
		codigoTxt.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (minusculas || mayusculas || espacio)
				{
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_codigoTxt = new GridBagConstraints();
		gbc_codigoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_codigoTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigoTxt.gridx = 2;
		gbc_codigoTxt.gridy = 1;
		panelCargaDeDatosBasicos.add(codigoTxt, gbc_codigoTxt);
		codigoTxt.setColumns(10);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 1;
		panelCargaDeDatosBasicos.add(horizontalStrut, gbc_horizontalStrut);

		lblNewLabel_3 = new JLabel("Nombre de la función");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		panelCargaDeDatosBasicos.add(lblNewLabel_3, gbc_lblNewLabel_3);

		nombreFuncionTxt = new JTextField();
		GridBagConstraints gbc_nombreFuncionTxt = new GridBagConstraints();
		gbc_nombreFuncionTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nombreFuncionTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreFuncionTxt.gridx = 5;
		gbc_nombreFuncionTxt.gridy = 1;
		panelCargaDeDatosBasicos.add(nombreFuncionTxt, gbc_nombreFuncionTxt);
		nombreFuncionTxt.setColumns(10);

		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 2;
		panelCargaDeDatosBasicos.add(verticalStrut, gbc_verticalStrut);

		lblNewLabel_2 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panelCargaDeDatosBasicos.add(lblNewLabel_2, gbc_lblNewLabel_2);

		descripcionTxt = new JTextField();
		GridBagConstraints gbc_descripcionTxt = new GridBagConstraints();
		gbc_descripcionTxt.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionTxt.gridx = 2;
		gbc_descripcionTxt.gridy = 3;
		panelCargaDeDatosBasicos.add(descripcionTxt, gbc_descripcionTxt);
		descripcionTxt.setColumns(10);

		lblNewLabel_4 = new JLabel("Empresa");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 3;
		panelCargaDeDatosBasicos.add(lblNewLabel_4, gbc_lblNewLabel_4);

		empresaCbx = new JComboBox<String>();
		GridBagConstraints gbc_empresaCbx = new GridBagConstraints();
		gbc_empresaCbx.insets = new Insets(0, 0, 5, 5);
		gbc_empresaCbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_empresaCbx.gridx = 5;
		gbc_empresaCbx.gridy = 3;
		panelCargaDeDatosBasicos.add(empresaCbx, gbc_empresaCbx);

		agregarEmpresaLabel = new JLabel("Agregar...");
		agregarEmpresaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		agregarEmpresaLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				JDialog addEmpresa = new VentanaAgregarEmpresa(wWindow, VentanaAltaFuncion.this);
				addEmpresa.setVisible(true);
			}
		});
		agregarEmpresaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		agregarEmpresaLabel.setForeground(new Color(30, 144, 255));
		agregarEmpresaLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		GridBagConstraints gbc_agregarEmpresaLabel = new GridBagConstraints();
		gbc_agregarEmpresaLabel.insets = new Insets(0, 10, 0, 0);
		gbc_agregarEmpresaLabel.anchor = GridBagConstraints.EAST;
		gbc_agregarEmpresaLabel.gridx = 6;
		gbc_agregarEmpresaLabel.gridy = 3;
		panelCargaDeDatosBasicos.add(agregarEmpresaLabel, gbc_agregarEmpresaLabel);

		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weightx = 0.5;
		gbc_lblNewLabel_5.weighty = 0.5;
		gbc_lblNewLabel_5.gridx = 7;
		gbc_lblNewLabel_5.gridy = 4;
		panelCargaDeDatosBasicos.add(lblNewLabel_5, gbc_lblNewLabel_5);

		verticalStrut_1 = Box.createVerticalStrut(20);
		panelDeContenido.add(verticalStrut_1);

		panelTablaDecompetencias = new JPanel();
		panelDeContenido.add(panelTablaDecompetencias);
		panelTablaDecompetencias.setLayout(new BorderLayout(0, 0));

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelTablaDecompetencias.add(horizontalStrut_1, BorderLayout.WEST);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelTablaDecompetencias.add(horizontalStrut_2, BorderLayout.EAST);

		scrollPane = new JScrollPane();
		panelTablaDecompetencias.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setModel(new DefaultTableModel(new Object[][] {}, new String[]
//		{ "Competencia", "Ponderación" }));
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new CompetenciaPonderacionTableModel(new Object[][] {}, new String[]
		{ "Competencia", "Ponderación" }));
		table.setDefaultRenderer(Object.class, new CompetenciaPonderacionCellRenderer());
		table.setDefaultRenderer(Integer.class, new CompetenciaPonderacionCellRenderer());
		scrollPane.setViewportView(table);

		panelBotonesTabla = new JPanel();
		FlowLayout fl_panelBotonesTabla = (FlowLayout) panelBotonesTabla.getLayout();
		fl_panelBotonesTabla.setHgap(20);
		fl_panelBotonesTabla.setAlignment(FlowLayout.LEFT);
		panelTablaDecompetencias.add(panelBotonesTabla, BorderLayout.SOUTH);

		agregarButton = new JButton("Agregar");
		agregarButton.addActionListener(e -> {
			JDialog addCompetencia = new VentanaAgregarCompetencia(wWindow, this, this.competenciasBasicasDTO);
			addCompetencia.setVisible(true);
		});
		panelBotonesTabla.add(agregarButton);

		eliminarButton = new JButton("Eliminar");
		eliminarButton.addActionListener(e -> {
			int irow = table.getSelectedRow();
			if (-1 != irow)
				((DefaultTableModel) table.getModel()).removeRow(irow); // TODO
		});
		panelBotonesTabla.add(eliminarButton);

		// Init
		cargarEmpresas();
		cargarCompetencias();
	}

	private void crearFuncion()
	{
		if (!validarCampos())
		{
			JOptionPane.showMessageDialog(this, "Campos inválidos", "Error de validación", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		GestorFuncion gestor = new GestorFuncion();
		FuncionCndeDTO f = new FuncionCndeDTO();
		List<CompetenciaPuntajeNombreDTO> lc = new ArrayList<CompetenciaPuntajeNombreDTO>();
		
		f.setNombre(nombreFuncionTxt.getText());
		f.setCodigo(Integer.parseInt(codigoTxt.getText()));
		f.setDescripcion(descripcionTxt.getText());
		f.setEmpresa((String)empresaCbx.getSelectedItem());
		
		CompetenciaPuntajeNombreDTO c = new CompetenciaPuntajeNombreDTO();
		for(int i = 0 ; i < table.getRowCount() ; i++)
		{
			c = new CompetenciaPuntajeNombreDTO();
			c.setNombre((String)table.getModel().getValueAt(i, 0));
			c.setPonderacion((Integer)table.getModel().getValueAt(i, 1));
			lc.add(c);
		}
		
		try
		{
			gestor.guardarFuncion(f,lc);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispose();
	}

	private Boolean validarCampos()
	{
		return !(codigoTxt.getText().isBlank() || codigoTxt.getText().isEmpty() || nombreFuncionTxt.getText().isEmpty() || nombreFuncionTxt.getText().length() > 200
				|| nombreFuncionTxt.getText().isBlank() || descripcionTxt.getText().isEmpty() || descripcionTxt.getText().length() > 500);
	}

	private void cargarCompetencias()
	{
		GestorCompetencia gestor = new GestorCompetencia();
		competenciasBasicasDTO = gestor.getAllCompetenciasBasicasDTO();
	}

	private void cargarEmpresas()
	{
		GestorFuncion gestor = new GestorFuncion();
		List<EmpresaDTO> empresas = gestor.getAllEmpresas();
		empresas.forEach(e -> agregarElementoEmpresaCbx(e.getNombre()));
	}

	public void agregarElementoEmpresaCbx(String str)
	{
		empresaCbx.addItem(str);
	}

	public void agregarCompetenciaTabla(CompetenciaPuntajeNombreDTO comp) throws Exception
	{
		if (existeComp(comp.getNombre()))
			throw new Exception("Ya existe esa competencia para la función");
		else
			((CompetenciaPonderacionTableModel) table.getModel()).addRow(new Object[]
			{ comp.getNombre(), comp.getPonderacion() });
	}

	private Boolean existeComp(String nombre)
	{

		for (int i = 0; i < table.getRowCount(); i++)
			if (((String) table.getValueAt(i, 0)).equals(nombre))
				return true;

		return false;
	}

}
