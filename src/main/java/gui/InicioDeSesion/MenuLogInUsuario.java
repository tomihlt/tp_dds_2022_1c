package gui.InicioDeSesion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import gui.Main;
import gui.Consultor.Inicio.MenuPrincipal;
import gui.Consultor.Inicio.PanelUsuario;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import clases.dto.ConsultorDTO;
import clases.entidades.Consultor;
import clases.gestores.GestorUsuario;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuLogInUsuario extends JPanel
{
	private Main wWindow;
	private JPanel panel;
	private JButton salirButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField usuarioTxt;
	private JLabel lblNewLabel_1;
	private JPasswordField pwTxt;
	private JButton volverButton;
	private JButton iniciarSesionButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	/**
	 * Create the panel.
	 */
	public MenuLogInUsuario(Main wWindow)
	{
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.SOUTH);

		salirButton = new JButton("Salir");
		salirButton.addActionListener(e -> {
			wWindow.dispose();
		});
		panel.add(salirButton);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]
		{ 0.0, 0.0, 1.0, 0.0 };
		gbl_panel_1.rowWeights = new double[]
		{ 0.0, 0.0, 1.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weighty = 0.5;
		gbc_lblNewLabel_4.weightx = 0.5;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblNewLabel_9 = new JLabel("Iniciar sesión como usuario consultor");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 1;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);

		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 0.5;
		gbc_lblNewLabel_5.weightx = 0.5;
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 3;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY, 2));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 2;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]
		{ 0, 0, 0, 0, 145, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weightx = 0.5;
		gbc_lblNewLabel_2.weighty = 0.5;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel = new JLabel("Usuario");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_8 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.weightx = 0.1;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 3;
		gbc_lblNewLabel_8.gridy = 2;
		panel_2.add(lblNewLabel_8, gbc_lblNewLabel_8);

		usuarioTxt = new JTextField();
		GridBagConstraints gbc_usuarioTxt = new GridBagConstraints();
		gbc_usuarioTxt.insets = new Insets(0, 0, 5, 5);
		gbc_usuarioTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuarioTxt.gridx = 4;
		gbc_usuarioTxt.gridy = 2;
		panel_2.add(usuarioTxt, gbc_usuarioTxt);
		usuarioTxt.setColumns(10);

		lblNewLabel_6 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.weighty = 0.2;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 3;
		panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);

		lblNewLabel_1 = new JLabel("Contraseña");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

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
		gbc_pwTxt.insets = new Insets(0, 0, 5, 5);
		gbc_pwTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwTxt.gridx = 4;
		gbc_pwTxt.gridy = 4;
		panel_2.add(pwTxt, gbc_pwTxt);

		lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.weighty = 0.2;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 5;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);

		volverButton = new JButton("Volver");
		volverButton.addActionListener(e -> {
			MenuLogIn menuLogin = new MenuLogIn(wWindow);
			wWindow.setCurrentMenu(menuLogin);
		});
		GridBagConstraints gbc_volverButton = new GridBagConstraints();
		gbc_volverButton.insets = new Insets(0, 0, 5, 5);
		gbc_volverButton.gridx = 2;
		gbc_volverButton.gridy = 6;
		panel_2.add(volverButton, gbc_volverButton);

		iniciarSesionButton = new JButton("Iniciar sesión");
		iniciarSesionButton.addActionListener(e -> {
//			MenuPrincipal home = new MenuPrincipal(wWindow);
//			wWindow.setCurrentMenu(home);
			autenticarConsultor();
		});
		GridBagConstraints gbc_iniciarSesionButton = new GridBagConstraints();
		gbc_iniciarSesionButton.insets = new Insets(0, 0, 5, 5);
		gbc_iniciarSesionButton.anchor = GridBagConstraints.EAST;
		gbc_iniciarSesionButton.gridx = 4;
		gbc_iniciarSesionButton.gridy = 6;
		panel_2.add(iniciarSesionButton, gbc_iniciarSesionButton);

		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 0.5;
		gbc_lblNewLabel_3.weightx = 0.5;
		gbc_lblNewLabel_3.gridx = 7;
		gbc_lblNewLabel_3.gridy = 7;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

	}

	private void autenticarConsultor()
	{
		String usuario = usuarioTxt.getText();
		char[] contraseña = pwTxt.getPassword();

		if (!camposValidos())
			return;

		GestorUsuario gestor = new GestorUsuario();

		try
		{
			ConsultorDTO consultor = gestor.findConsultorByNombreUsuario(usuario);

			if (consultor == null)
			{
				JOptionPane.showMessageDialog(this, "No existe el usuario '" + usuario + "'.", "Usuario incorrecto.",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (!gestor.contraseñaCorrecta(consultor, contraseña))
			{
				JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Contraseña incorrecta",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			MenuPrincipal home = new MenuPrincipal(wWindow,consultor);
			wWindow.setCurrentMenu(home);

		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "Excepcion en la linea 231 del login.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	private Boolean camposValidos()
	{
		if (!usuarioValido())
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de usuario", "Error de validación",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!contraseñaValida())
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña", "Error de validación",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else
			return true;
	}

	private Boolean contraseñaValida()
	{
		return !(pwTxt.getPassword().length == 0);
	}

	private Boolean usuarioValido()
	{
		return !(usuarioTxt.getText().isEmpty() || usuarioTxt.getText().isBlank());
	}

}
