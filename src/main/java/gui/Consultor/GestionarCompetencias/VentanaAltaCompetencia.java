package gui.Consultor.GestionarCompetencias;

import javax.swing.JDialog;
import javax.swing.JPanel;

import gui.Main;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import clases.dao.interfaces.CRUD;
import clases.dao.interfaces.CompetenciaDAO;
import clases.dao.postgres.PostgresCompetencia;
import clases.entidades.Competencia;

import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class VentanaAltaCompetencia extends JDialog
{
	private Main wWindow;
	private JPanel invocador;
	private JPanel panel;
	private JButton cancelarButton;
	private JButton aceptarButton;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JTextField codigoTxt;
	private JLabel lblNewLabel_3;
	private JTextField nombreTxt;
	private JLabel lblNewLabel_4;
	private JTextField descripcionTxt;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;

	public VentanaAltaCompetencia(Main wWindow, JPanel invocador)
	{
		super(wWindow, "Dar de alta competencia", Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(wWindow);
		this.wWindow = wWindow;
		this.invocador = invocador;
		setBounds(100, 100, 671, 416);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(e -> dispose());
		panel.add(cancelarButton);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.addActionListener(e -> {
			crearCompetencia();
		});
		panel.add(aceptarButton);

		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]
		{ 0, 0, 0, 0, 157, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_2 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 2;
		panel_1.add(horizontalStrut, gbc_horizontalStrut);

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
		GridBagConstraints gbc_codigoTxt = new GridBagConstraints();
		gbc_codigoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_codigoTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigoTxt.gridx = 4;
		gbc_codigoTxt.gridy = 2;
		panel_1.add(codigoTxt, gbc_codigoTxt);
		codigoTxt.setColumns(10);

		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 4;
		gbc_verticalStrut.gridy = 3;
		panel_1.add(verticalStrut, gbc_verticalStrut);

		lblNewLabel_3 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		nombreTxt = new JTextField();
		GridBagConstraints gbc_nombreTxt = new GridBagConstraints();
		gbc_nombreTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreTxt.gridx = 4;
		gbc_nombreTxt.gridy = 4;
		panel_1.add(nombreTxt, gbc_nombreTxt);
		nombreTxt.setColumns(10);

		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 5;
		panel_1.add(verticalStrut_1, gbc_verticalStrut_1);

		lblNewLabel_4 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 6;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		descripcionTxt = new JTextField();
		GridBagConstraints gbc_descripcionTxt = new GridBagConstraints();
		gbc_descripcionTxt.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionTxt.gridx = 4;
		gbc_descripcionTxt.gridy = 6;
		panel_1.add(descripcionTxt, gbc_descripcionTxt);
		descripcionTxt.setColumns(10);

		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 8;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

	private boolean validarCampos()
	{
		if (nombreTxt.getText().length() > 100 || descripcionTxt.getText().length() > 500
				|| nombreTxt.getText().isEmpty() || codigoTxt.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Campos inválidos, asegúrese de que rellenar todos los campos",
					"Error de validación", JOptionPane.WARNING_MESSAGE);
			return false;
		} else
			return true;
	}

	private void crearCompetencia()
	{
		if (validarCampos())
		{
			Competencia comp = new Competencia();
			comp.setCodigo(Integer.parseInt(codigoTxt.getText()));
			comp.setNombre(nombreTxt.getText());
			comp.setEliminado(false);
			comp.setDescripcion(descripcionTxt.getText());

			CompetenciaDAO dao = new PostgresCompetencia();
			try
			{
				dao.save(comp);
				dispose();
			} catch (SQLException e)
			{
				JOptionPane.showMessageDialog(this, "Ya existe una competencia con el código " + codigoTxt.getText(),
						"Error de validación", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}
