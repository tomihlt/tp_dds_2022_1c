package gui.Consultor;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import gui.Main;
import gui.tableRenderersYTableModels.EstandarCellRenderer;
import gui.tableRenderersYTableModels.TablaFuncionesPanelTableModel;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionBasicaDTO;
import clases.dto.FuncionCndeDTO;
import clases.dto.FuncionDTO;
import clases.dto.FuncionIdCodigoDTO;
import clases.entidades.Funcion;
import clases.gestores.GestorFuncion;

import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFunciones extends JPanel
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
	private JLabel lblNewLabel_2;
	private JTextField codigoTxt;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField nombreFuncionTxt;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField nombreEmpresaTxt;
	private JLabel lblNewLabel_7;
	private Component verticalStrut_1;
	private JButton buscarButton;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_8;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private Component verticalStrut_4;

	/**
	 * Create the panel.
	 */
	public PanelFunciones(Main wWindow)
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
		table.setModel(new TablaFuncionesPanelTableModel(new Object[][] {}, new String[]
		{ "Código", "Nombre de la función", "Nombre de la empresa" }));
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
		eliminarButton.addActionListener(e -> eliminarFuncion());
		panelDeBotones.add(eliminarButton);

		horizontalStrut = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut);

		modificarButton = new JButton("Modificar");
		modificarButton.addActionListener(e -> modificarEmpresa());
		panelDeBotones.add(modificarButton);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelDeBotones.add(horizontalStrut_1);

		nuevoButton = new JButton("Nuevo");
		nuevoButton.addActionListener(e -> {
			JDialog altaFuncion = new VentanaAltaFuncion(wWindow, this);
			altaFuncion.setVisible(true);
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

		lblNewLabel_2 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panelBuscador.add(lblNewLabel_2, gbc_lblNewLabel_2);

		codigoTxt = new JTextField();
		codigoTxt.addKeyListener(new KeyAdapter()
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
		codigoTxt.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panelBuscador.add(codigoTxt, gbc_textField);

		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weightx = 0.1;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		panelBuscador.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Nombre de la función");
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

		lblNewLabel_6 = new JLabel("Nombre de la empresa");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 7;
		gbc_lblNewLabel_6.gridy = 2;
		panelBuscador.add(lblNewLabel_6, gbc_lblNewLabel_6);

		nombreEmpresaTxt = new JTextField();
		nombreEmpresaTxt.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 2;
		panelBuscador.add(nombreEmpresaTxt, gbc_textField_2);

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
		buscarButton.addActionListener(e -> {
			limpiarTabla();
			buscarFunciones();
		});
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
	
	private void modificarEmpresa()
	{
		TablaFuncionesPanelTableModel model = (TablaFuncionesPanelTableModel) table.getModel();
		int fila = table.getSelectedRow();

		if (fila == -1)
		{
			JOptionPane.showMessageDialog(this, "Debe seleccionar una función", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}

		FuncionIdCodigoDTO icf = (FuncionIdCodigoDTO) model.getValueAt(fila, 0);
		String nombre = (String) model.getValueAt(fila, 1);
		EmpresaDTO empresa = (EmpresaDTO) model.getValueAt(fila, 2);
		
		FuncionDTO funcion = new FuncionDTO();
		funcion.setId(icf.getId());
		funcion.setCodigo(icf.getCodigo());
		funcion.setNombre(nombre);
		funcion.setEmpresa(empresa);
		
		VentanaModificarFuncion ventana = new VentanaModificarFuncion(wWindow, this, funcion);
		ventana.setVisible(true);
	}

	private void eliminarFuncion()
	{
		TablaFuncionesPanelTableModel model = (TablaFuncionesPanelTableModel) table.getModel();
		int fila = table.getSelectedRow();

		if (fila == -1)
		{
			JOptionPane.showMessageDialog(this, "Debe seleccionar una función", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Integer codigo = (Integer) model.getValueAt(fila, 0);
		String nombre = (String) model.getValueAt(fila, 1);
		EmpresaDTO empresa = (EmpresaDTO) model.getValueAt(fila, 2);

		FuncionBasicaDTO funcion = new FuncionBasicaDTO();
		funcion.setCodigo(codigo);
		funcion.setNombre(nombre);
		funcion.setEmpresa(empresa.getNombre());

		GestorFuncion gestor = new GestorFuncion();
		try
		{
			if (gestor.eliminarFuncion(funcion))
				eliminarFuncionTabla(funcion);
			else
				JOptionPane.showMessageDialog(this,
						"No se pudo eliminar la función ya que tiene evaluaciones asociadas",
						"Fallo al eliminar la funcion", JOptionPane.ERROR_MESSAGE);

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "No se pudo eliminar la función", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	private void eliminarFuncionTabla(FuncionBasicaDTO funcion)
	{
		TablaFuncionesPanelTableModel model = ((TablaFuncionesPanelTableModel) table.getModel());
		for(int i = 0 ; i < model.getRowCount() ; i++)
		{
			if(((Integer)model.getValueAt(i, 0)).equals(funcion.getCodigo()))
			{
				model.removeRow(i);
				break;
			}
		}
	}

	private void limpiarTabla()
	{
//		TablaFuncionesPanelTableModel model = ((TablaFuncionesPanelTableModel) table.getModel());
//		
//		for(int i = 0 ; i < model.getRowCount() ; i++)
//		{
//			model.removeRow(i);
//		}

		table.setModel(new TablaFuncionesPanelTableModel(new Object[][] {}, new String[]
		{ "Código", "Nombre de la función", "Nombre de la empresa" }));

	}

	private void buscarFunciones()
	{
		Integer codigo = null;
		String nombre = null;
		String empresa = null;

		if (!codigoTxt.getText().isEmpty())
			codigo = Integer.parseInt(codigoTxt.getText());
		if (!(nombreEmpresaTxt.getText().isBlank() || nombreEmpresaTxt.getText().isEmpty()))
			empresa = nombreEmpresaTxt.getText();
		if (!(nombreFuncionTxt.getText().isBlank() || nombreFuncionTxt.getText().isEmpty()))
			nombre = nombreFuncionTxt.getText();

		GestorFuncion gestor = new GestorFuncion();

		try
		{
			List<FuncionDTO> funciones = gestor.buscarFuncionesConEmpresa(codigo, nombre, empresa);
			funciones.forEach(f -> agregarElementoTabla(f));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void agregarElementoTabla(FuncionDTO f)
	{
		TablaFuncionesPanelTableModel model = (TablaFuncionesPanelTableModel) table.getModel();
		
		FuncionIdCodigoDTO aux = new FuncionIdCodigoDTO();
		aux.setId(f.getId());
		aux.setCodigo(f.getCodigo());
		
		Object[] row = new Object[]
		{ aux, f.getNombre(), f.getEmpresa() };

		model.addRow(row);
	}

}
