package gui.InicioDeSesion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.Main;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

import clases.dto.CandidatoDTO;
import clases.dto.CuestionarioDTO;
import clases.enums.EstadoCuestionario;
import clases.enums.TipoDNI;
import clases.gestores.GestorCuestionario;
import clases.gestores.GestorUsuario;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MenuLogInCandidato extends JPanel
{
	private Main wWindow;
	private JPanel panel;
	private JButton salirButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox tipoDniCbx;
	private JLabel lblNewLabel_3;
	private JTextField documentoTxt;
	private JLabel lblNewLabel_4;
	private JPasswordField pwTxt;
	private JButton volverButton;
	private JButton iniciarSesionButton;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Create the panel.
	 */
	public MenuLogInCandidato(Main wWindow)
	{
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.SOUTH);

		salirButton = new JButton("Salir");
		salirButton.addActionListener(e -> wWindow.dispose());
		panel.add(salirButton);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 0.5;
		gbc_lblNewLabel_5.weightx = 0.5;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_8 = new JLabel("Iniciar sesión como usuario candidato");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 8;
		gbc_lblNewLabel_8.gridy = 3;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);

		lblNewLabel_6 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.weighty = 0.5;
		gbc_lblNewLabel_6.weightx = 0.5;
		gbc_lblNewLabel_6.gridx = 10;
		gbc_lblNewLabel_6.gridy = 10;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY, 2));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 8;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_2.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_2.setLayout(gbl_panel_2);

		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_2 = new JLabel("Tipo de documento");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		tipoDniCbx = new JComboBox();
		tipoDniCbx.setModel(new DefaultComboBoxModel(TipoDNI.values()));
		GridBagConstraints gbc_tipoDniCbx = new GridBagConstraints();
		gbc_tipoDniCbx.insets = new Insets(0, 0, 5, 5);
		gbc_tipoDniCbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoDniCbx.gridx = 5;
		gbc_tipoDniCbx.gridy = 2;
		panel_2.add(tipoDniCbx, gbc_tipoDniCbx);

		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 4;
		gbc_verticalStrut_2.gridy = 3;
		panel_2.add(verticalStrut_2, gbc_verticalStrut_2);

		lblNewLabel_3 = new JLabel("N° documento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weightx = 0.1;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 4;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);

		documentoTxt = new JTextField();
		documentoTxt.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if (!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57))
					e.consume();
			}
		});
		GridBagConstraints gbc_documentoTxt = new GridBagConstraints();
		gbc_documentoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_documentoTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_documentoTxt.gridx = 5;
		gbc_documentoTxt.gridy = 4;
		panel_2.add(documentoTxt, gbc_documentoTxt);
		documentoTxt.setColumns(10);

		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 5;
		panel_2.add(verticalStrut_1, gbc_verticalStrut_1);

		lblNewLabel_4 = new JLabel("Contraseña");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 6;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		pwTxt = new JPasswordField();
		pwTxt.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if (e.getKeyChar() == 32)
					e.consume();
			}
		});
		GridBagConstraints gbc_pwTxt = new GridBagConstraints();
		gbc_pwTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwTxt.insets = new Insets(0, 0, 5, 5);
		gbc_pwTxt.gridx = 5;
		gbc_pwTxt.gridy = 6;
		panel_2.add(pwTxt, gbc_pwTxt);

		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 4;
		gbc_verticalStrut.gridy = 7;
		panel_2.add(verticalStrut, gbc_verticalStrut);

		volverButton = new JButton("Volver");
		volverButton.addActionListener(e -> {
			MenuLogIn menuLogin = new MenuLogIn(wWindow);
			wWindow.setCurrentMenu(menuLogin);
		});
		GridBagConstraints gbc_volverButton = new GridBagConstraints();
		gbc_volverButton.insets = new Insets(0, 0, 5, 5);
		gbc_volverButton.gridx = 2;
		gbc_volverButton.gridy = 8;
		panel_2.add(volverButton, gbc_volverButton);

		iniciarSesionButton = new JButton("Iniciar sesión");
		iniciarSesionButton.addActionListener(e -> autenticarCandidato());
		GridBagConstraints gbc_iniciarSesionButton = new GridBagConstraints();
		gbc_iniciarSesionButton.anchor = GridBagConstraints.EAST;
		gbc_iniciarSesionButton.insets = new Insets(0, 0, 5, 5);
		gbc_iniciarSesionButton.gridx = 5;
		gbc_iniciarSesionButton.gridy = 8;
		panel_2.add(iniciarSesionButton, gbc_iniciarSesionButton);

		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.gridx = 12;
		gbc_lblNewLabel_1.gridy = 11;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

	}

	private void autenticarCandidato()
	{
		if (!camposValidos())
			return;

		GestorUsuario gestor = new GestorUsuario();

		try
		{
			CandidatoDTO candidato = gestor.findCandidatoByDni(Integer.parseInt(documentoTxt.getText()));
			if(candidato == null)
			{
				JOptionPane.showMessageDialog(this, "No existe este candidato en la base de datos.", "Error.",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (!cuestionarioAccesbile(candidato))
				return;

		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "No existe este candidato en la base de datos o no tiene un cuestionario.", "Error.",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Aca va el inicio de la lógica del Caso de uso 26 - Completar cuestionario

	}

	private Boolean cuestionarioAccesbile(CandidatoDTO candidato)
	{
		CuestionarioDTO cuestionario = null;
		GestorCuestionario gestor = new GestorCuestionario();

		try
		{
			cuestionario = gestor.findByCandidato(candidato);

			if (cuestionario == null)
			{
				JOptionPane.showMessageDialog(this, "Usted no posee un cuestionario.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else if (!cuestionario.getClave().equals(pwTxt.getPassword().toString()))
			{
				JOptionPane.showMessageDialog(this, "La contraseña del cuestionario es incorrecta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else if (cuestionario.getFechaFin().isAfter(LocalDateTime.now()))
			{
				JOptionPane.showMessageDialog(this, "La fecha para completar el cuestionario expiró.", "Error",
						JOptionPane.ERROR_MESSAGE);
				// TODO actualizar info en la base de datos
				return false;
			} else if (cuestionario.getCantidadAccesosMaxima() <= cuestionario.getCantidadAccesos())
			{
				JOptionPane.showMessageDialog(this, "Ya no le quedan más intentos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "No se pudo obtener el cuestionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private Boolean camposValidos()
	{
		if (!dniValido())
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar su dni.", "Error de validación.",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!contraseñaValida())
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar una contraseña.", "Error de validación.",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else
			return true;
	}

	private boolean contraseñaValida()
	{
		return !(pwTxt.getPassword().length == 0);
	}

	private Boolean dniValido()
	{
		return !(documentoTxt.getText().length() == 0);
	}

}
