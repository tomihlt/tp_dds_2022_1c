package gui.Consultor.EvaluarCandidatos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.dto.CandidatoBasicoDTO;
import clases.dto.CandidatoDTO;
import clases.dto.CandidatoNormalDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.FactorBasicoDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.gestores.GestorEvaluacion;
import clases.gestores.GestorUsuario;
import gui.Main;
import gui.tableRenderersYTableModels.CandidatosFinalesTableModel;
import gui.tableRenderersYTableModels.EstandarCellRenderer;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class PantallaFinalizar extends JPanel
{
	private Main wWindow;
	private PantallaSeleccionarFuncion anterior;
	private PanelEvaluarCandidatos panel;
	private JPanel panelSuperior;
	private JLabel lblNewLabel;
	private JLabel infoLabel;
	private JLabel lblNewLabel_1;
	private JPanel panelDeBotones;
	private Component horizontalStrut;
	private JButton cancelarButton;
	private JLabel lblNewLabel_2;
	private JButton anteriorButton;
	private JLabel lblNewLabel_3;
	private JButton finalizarButton;
	private Component horizontalStrut_1;
	private JPanel panelDeDatos;
	private JScrollPane scrollPane;
	private JTable table;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;

	/**
	 * Create the panel.
	 */
	public PantallaFinalizar(Main wWindow, PanelEvaluarCandidatos panel, PantallaSeleccionarFuncion anterior)
	{
		this.wWindow = wWindow;
		this.anterior = anterior;
		this.panel = panel;
		initialize();
	}

	private void initialize()
	{
		setLayout(new BorderLayout(0, 0));

		panelSuperior = new JPanel();
		add(panelSuperior, BorderLayout.NORTH);
		GridBagLayout gbl_panelSuperior = new GridBagLayout();
		gbl_panelSuperior.columnWidths = new int[]
		{ 0, 0, 0, 0 };
		gbl_panelSuperior.rowHeights = new int[]
		{ 0, 0, 0, 0, 0 };
		gbl_panelSuperior.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelSuperior.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelSuperior.setLayout(gbl_panelSuperior);

		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		panelSuperior.add(verticalStrut_2, gbc_verticalStrut_2);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelSuperior.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		panelSuperior.add(lblNewLabel_1, gbc_lblNewLabel_1);

		infoLabel = new JLabel("Resumen de candidatos a evaluar para la función FUNCION en la empresa EMPRESA.");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 1;
		gbc_infoLabel.gridy = 2;
		panelSuperior.add(infoLabel, gbc_infoLabel);

		panelDeBotones = new JPanel();
		add(panelDeBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_panelDeBotones = new GridBagLayout();
		gbl_panelDeBotones.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelDeBotones.rowHeights = new int[]
		{ 0, 0, 0, 0 };
		gbl_panelDeBotones.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelDeBotones.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDeBotones.setLayout(gbl_panelDeBotones);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		panelDeBotones.add(horizontalStrut, gbc_horizontalStrut);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(e -> cancelar());
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelarButton.gridx = 1;
		gbc_cancelarButton.gridy = 0;
		panelDeBotones.add(cancelarButton, gbc_cancelarButton);

		lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weightx = 0.5;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panelDeBotones.add(lblNewLabel_2, gbc_lblNewLabel_2);

		anteriorButton = new JButton("Anterior");
		anteriorButton.addActionListener(e -> anterior());
		GridBagConstraints gbc_anteriorButton = new GridBagConstraints();
		gbc_anteriorButton.insets = new Insets(0, 0, 5, 5);
		gbc_anteriorButton.gridx = 3;
		gbc_anteriorButton.gridy = 0;
		panelDeBotones.add(anteriorButton, gbc_anteriorButton);

		lblNewLabel_3 = new JLabel("2/3");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		panelDeBotones.add(lblNewLabel_3, gbc_lblNewLabel_3);

		finalizarButton = new JButton("Finalizar");
		finalizarButton.addActionListener(e -> finalizar());
		GridBagConstraints gbc_finalizarButton = new GridBagConstraints();
		gbc_finalizarButton.insets = new Insets(0, 0, 5, 5);
		gbc_finalizarButton.gridx = 5;
		gbc_finalizarButton.gridy = 0;
		panelDeBotones.add(finalizarButton, gbc_finalizarButton);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 6;
		gbc_horizontalStrut_1.gridy = 0;
		panelDeBotones.add(horizontalStrut_1, gbc_horizontalStrut_1);

		verticalStrut_3 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 2;
		gbc_verticalStrut_3.gridy = 1;
		panelDeBotones.add(verticalStrut_3, gbc_verticalStrut_3);

		panelDeDatos = new JPanel();
		add(panelDeDatos, BorderLayout.CENTER);
		panelDeDatos.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panelDeDatos.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setEnabled(false);
		table.setModel(new CandidatosFinalesTableModel(new Object[][] {}, new String[]
		{ "Apellido", "Nombre", "Tipo de documento", "Número de documento", "Clave de ingreso" }));
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultRenderer(Object.class, new EstandarCellRenderer());
		table.setDefaultRenderer(Integer.class, new EstandarCellRenderer());
		scrollPane.setViewportView(table);

		verticalStrut = Box.createVerticalStrut(20);
		panelDeDatos.add(verticalStrut, BorderLayout.NORTH);

		verticalStrut_1 = Box.createVerticalStrut(20);
		panelDeDatos.add(verticalStrut_1, BorderLayout.SOUTH);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2, BorderLayout.WEST);

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		add(horizontalStrut_3, BorderLayout.EAST);

		//
		setInfoLabel();
		cargarCandidatosTabla();

	}

	private void finalizar()
	{
		GestorEvaluacion gestor = new GestorEvaluacion();
		Map<CandidatoNormalDTO,String> usuariosConClaves = obtenerCandidatosFinales();
		Map<CompetenciaPuntajeNombreDTO, List<FactorBasicoDTO>> competenciasEvaluables = obtenerCompetenciasParaEvaluar();
		try
		{
			gestor.generarEvaluacion(obtenerFuncionAEvaluar(),competenciasEvaluables,usuariosConClaves);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private FuncionNombreIdDTO obtenerFuncionAEvaluar()
	{
		return anterior.getFuncionParaEvaluar();
	}

	private Map<CompetenciaPuntajeNombreDTO, List<FactorBasicoDTO>> obtenerCompetenciasParaEvaluar()
	{
		return anterior.getCompetenciasEvaluables();
	}

	private Map<CandidatoNormalDTO, String> obtenerCandidatosFinales()
	{
		Map<CandidatoNormalDTO,String> candidatos = new HashMap<CandidatoNormalDTO,String>();
		CandidatosFinalesTableModel model = (CandidatosFinalesTableModel) table.getModel();
		
		for(int i = 0 ; i < model.getRowCount(); i++)
		{
			CandidatoNormalDTO c = (CandidatoNormalDTO) model.getValueAt(i, 0);
			String clave = (String) model.getValueAt(i, 4);
			candidatos.put(c, clave);
		}
		
		return candidatos;
	}

	private void cargarCandidatosTabla()
	{
		List<CandidatoBasicoDTO> candidatosAEvaluar = obtenerCandidatos();
		GestorUsuario gestor = new GestorUsuario();
		try
		{
			List<CandidatoNormalDTO> candidatos = gestor.getCandidatosDto(candidatosAEvaluar);
			Map<CandidatoNormalDTO,String> candidatoConClave = gestor.generarClaves(candidatos);
			agregarCandidatosTabla(candidatoConClave);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "Error al obtener los candidatos.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void agregarCandidatosTabla(Map<CandidatoNormalDTO,String> candidatos)
	{
		
		for(CandidatoNormalDTO c : candidatos.keySet())
		{
			agregarCandidatosTabla(c,candidatos.get(c));	
		}
	}

	private void agregarCandidatosTabla(CandidatoNormalDTO c, String clave)
	{
		Object[] row = new Object[] {c,c.getNombre(),c.getTipoDNI(),c.getDni(), clave};
		CandidatosFinalesTableModel model = (CandidatosFinalesTableModel) table.getModel();
		
		model.addRow(row);
	}

	private List<CandidatoBasicoDTO> obtenerCandidatos()
	{
		return anterior.obtenerCandidatos();
	}

	private void setInfoLabel()
	{
		infoLabel.setText("Resumen de candidatos a evaluar para la función " + anterior.getFuncionParaEvaluar()
				+ " en la empresa " + anterior.getEmpresaParaEvaluar() + ".");
	}

	private void cancelar()
	{
		panel.setCurrentMenu(new PanelEvaluarCandidatos(wWindow));
	}

	private void anterior()
	{
		panel.setCurrentMenu(anterior);
	}

}
