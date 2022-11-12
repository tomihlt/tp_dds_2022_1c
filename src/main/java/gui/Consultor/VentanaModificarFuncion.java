package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.dto.CompetenciaBasicaDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.EmpresaDTO;
import clases.dto.FuncionBasicaDTO;
import clases.dto.FuncionCndeDTO;
import clases.dto.FuncionDTO;
import clases.gestores.GestorCompetencia;
import clases.gestores.GestorFuncion;
import gui.Main;
import gui.tableRenderersYTableModels.CompetenciaPonderacionTableModel;
import gui.tableRenderersYTableModels.EstandarCellRenderer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaModificarFuncion extends JDialog
{
	
	private Main wWindow;
	private JPanel invocador;
	private FuncionDTO funcion;
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
	private JComboBox<EmpresaDTO> empresaCbx;
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
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			VentanaModificarFuncion dialog = new VentanaModificarFuncion();
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
	public VentanaModificarFuncion(Main wWindow, JPanel invocador, FuncionDTO funcion)
	{
		super(wWindow, "Dar de alta función", Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(wWindow);
		this.wWindow = wWindow;
		this.invocador = invocador;
		this.funcion = funcion;
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
		aceptarButton.addActionListener(e -> actualizarFuncion());
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
		codigoTxt.setEditable(false);
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

		empresaCbx = new JComboBox<EmpresaDTO>();
		GridBagConstraints gbc_empresaCbx = new GridBagConstraints();
		gbc_empresaCbx.insets = new Insets(0, 0, 5, 5);
		gbc_empresaCbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_empresaCbx.gridx = 5;
		gbc_empresaCbx.gridy = 3;
		panelCargaDeDatosBasicos.add(empresaCbx, gbc_empresaCbx);

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
		table.setDefaultRenderer(Object.class, new EstandarCellRenderer());
		table.setDefaultRenderer(Integer.class, new EstandarCellRenderer());
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
				((DefaultTableModel) table.getModel()).removeRow(irow);
		});
		panelBotonesTabla.add(eliminarButton);

		// Init
		cargarEmpresas();
		cargarCompetencias();
		setDatosFuncion(this.funcion);
	}
	
	private void actualizarFuncion()
	{
		if (crearFuncion())
		{
			JOptionPane.showMessageDialog(this, "Función actualizada correctamente",
					"Funcion actualizada.", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
	
	private Boolean crearFuncion()
	{
		if (!validarCampos())
		{
			return false;
		}

		GestorFuncion gestor = new GestorFuncion();
		FuncionCndeDTO funcionSinCompetencias = new FuncionCndeDTO();
		List<CompetenciaPuntajeNombreDTO> competenciasDeLaFuncion = new ArrayList<CompetenciaPuntajeNombreDTO>();

		funcionSinCompetencias.setNombre(nombreFuncionTxt.getText());
		funcionSinCompetencias.setCodigo(Integer.parseInt(codigoTxt.getText()));
		funcionSinCompetencias.setDescripcion(descripcionTxt.getText());
		funcionSinCompetencias.setEmpresa(((EmpresaDTO) empresaCbx.getSelectedItem()));

		CompetenciaPuntajeNombreDTO c;
		for (int i = 0; i < table.getRowCount(); i++)
		{
			c = new CompetenciaPuntajeNombreDTO();
			c.setId(((CompetenciaBasicaDTO) table.getModel().getValueAt(i, 0)).getId());
			c.setNombre(((CompetenciaBasicaDTO) table.getModel().getValueAt(i, 0)).getNombre());
			c.setPonderacion((Integer) table.getModel().getValueAt(i, 1));
			competenciasDeLaFuncion.add(c);
		}

		try
		{
			gestor.actualizarFuncion(funcionSinCompetencias, competenciasDeLaFuncion);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "No se pudo actualizar la funcion.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	private Boolean validarCampos()
	{
		return codigoTxtValido() && nombreFuncionTxtValido() && descripcionTxtValido();
	}

	public boolean descripcionTxtValido()
	{
		if (descripcionTxt.getText().isEmpty() || descripcionTxt.getText().length() > 500)
		{
			JOptionPane.showMessageDialog(this, "Debe introducir una descripción (no debe superar los 500 caracteres).",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public boolean nombreFuncionTxtValido()
	{
		if (nombreFuncionTxt.getText().isEmpty() || nombreFuncionTxt.getText().length() > 200
				|| nombreFuncionTxt.getText().isBlank())
		{
			JOptionPane.showMessageDialog(this,
					"Debe introducir un nombre para la función (no debe superar los 200 caracteres).",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public Boolean codigoTxtValido()
	{
		if (codigoTxt.getText().isBlank() || codigoTxt.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Debe introducir un código.", "Error de validación",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	private void setDatosFuncion(FuncionDTO f)
	{
		GestorFuncion gestor = new GestorFuncion();
		
		try
		{
			FuncionCndeDTO func = gestor.buscarFuncion(f);
			List<CompetenciaPuntajeNombreDTO> competenciasDeLaFuncion = gestor.buscarPuntajes(f);
			cargarDatosDeLaFuncionEnElPanel(func,competenciasDeLaFuncion);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cargarDatosDeLaFuncionEnElPanel(FuncionCndeDTO func,List<CompetenciaPuntajeNombreDTO> listaPuntajes)
	{
		this.codigoTxt.setText(func.getCodigo().toString());
		this.nombreFuncionTxt.setText(func.getNombre());
		this.descripcionTxt.setText(func.getDescripcion());
		this.empresaCbx.setSelectedItem(func.getEmpresa());
		
		//Cargar competencias:
		listaPuntajes.forEach(c -> {
			try
			{
				agregarCompetenciaTabla(c);
			} catch (Exception e)
			{
				// No deberia haber cargada ninguna competencia asi que no deberia ocurrir esta excepcion
			}
		});
		
	}

	public void agregarCompetenciaTabla(CompetenciaPuntajeNombreDTO comp) throws Exception
	{

		if (existeComp(comp))
			throw new Exception("Esta competencia ya esta en la tabla");

		CompetenciaBasicaDTO competenciaParaInsertar = new CompetenciaBasicaDTO();
		competenciaParaInsertar.setId(comp.getId());
		competenciaParaInsertar.setNombre(comp.getNombre());

		CompetenciaPonderacionTableModel model = (CompetenciaPonderacionTableModel) table.getModel();
		model.addRow(new Object[]
		{ competenciaParaInsertar, comp.getPonderacion() });

	}

	private Boolean existeComp(CompetenciaPuntajeNombreDTO comp)
	{
		for (int i = 0; i < table.getRowCount(); i++)
			if (((CompetenciaBasicaDTO) table.getValueAt(i, 0)).getId().equals(comp.getId()))
				return true;

		return false;
	}

	private void cargarEmpresas()
	{
		GestorFuncion gestor = new GestorFuncion();
		List<EmpresaDTO> empresas;
		try
		{
			empresas = gestor.getAllEmpresas();
			empresas.forEach(e -> agregarElementoEmpresaCbx(e));
		} catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "Error al obtener las empresas de la bdd", "Error",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public void agregarElementoEmpresaCbx(EmpresaDTO e)
	{
		empresaCbx.addItem(e);
	}

	private void cargarCompetencias()
	{
		GestorCompetencia gestor = new GestorCompetencia();
		competenciasBasicasDTO = gestor.getAllCompetenciasBasicasDTO();
	}

}
