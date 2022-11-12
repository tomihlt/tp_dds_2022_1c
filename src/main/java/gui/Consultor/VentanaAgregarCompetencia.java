package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.dto.CompetenciaBasicaDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import gui.Main;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.SpinnerNumberModel;

public class VentanaAgregarCompetencia extends JDialog
{

	private Main wWindow;
	private JDialog invocador;
	private List<CompetenciaBasicaDTO> competencias;
	private final JPanel contentPanel = new JPanel();
	private JSpinner ponderacionTxt;
	private JComboBox<CompetenciaBasicaDTO> competenciaCbx;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			VentanaAgregarCompetencia dialog = new VentanaAgregarCompetencia();
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
	public VentanaAgregarCompetencia(Main wWindow, JDialog invocador, List<CompetenciaBasicaDTO> competencias)
	{
		super(invocador, "Agregar competencia a la función", Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(wWindow);
		this.wWindow = wWindow;
		this.invocador = invocador;
		this.competencias = competencias;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]
		{ 0, 0, 126, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Competencia");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		competenciaCbx = new JComboBox<CompetenciaBasicaDTO>();
		GridBagConstraints gbc_competenciaCbx = new GridBagConstraints();
		gbc_competenciaCbx.insets = new Insets(0, 0, 5, 5);
		gbc_competenciaCbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_competenciaCbx.gridx = 2;
		gbc_competenciaCbx.gridy = 1;
		contentPanel.add(competenciaCbx, gbc_competenciaCbx);
		for (CompetenciaBasicaDTO c : competencias)
		{
			competenciaCbx.addItem(c);
		}

		JLabel lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 0.01;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 2;
		contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("Ponderación");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		ponderacionTxt = new JSpinner();
		ponderacionTxt.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_ponderacionTxt = new GridBagConstraints();
		gbc_ponderacionTxt.fill = GridBagConstraints.BOTH;
		gbc_ponderacionTxt.insets = new Insets(0, 0, 5, 5);
		gbc_ponderacionTxt.gridx = 2;
		gbc_ponderacionTxt.gridy = 3;
		contentPanel.add(ponderacionTxt, gbc_ponderacionTxt);

		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 5;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(e -> dispose());
		cancelarButton.setActionCommand("OK");
		buttonPane.add(cancelarButton);
		getRootPane().setDefaultButton(cancelarButton);

		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.addActionListener(e -> agregarCompetencia());
		aceptarButton.setActionCommand("Cancel");
		buttonPane.add(aceptarButton);

	}

	private void agregarCompetencia()
	{
		CompetenciaPuntajeNombreDTO comp = new CompetenciaPuntajeNombreDTO();
		comp.setNombre(((CompetenciaBasicaDTO) competenciaCbx.getSelectedItem()).getNombre());
		comp.setId(((CompetenciaBasicaDTO) competenciaCbx.getSelectedItem()).getId());
		comp.setPonderacion((Integer) ponderacionTxt.getValue());

		if (competenciaCbx.getSelectedItem() == null)
		{
			JOptionPane.showMessageDialog(this, "No se ha seleccionado una competencia", "Error",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try
		{
			((VentanaModificarFuncion) invocador).agregarCompetenciaTabla(comp);
			dispose();
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Esta competencia ya ha sido cargada", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
