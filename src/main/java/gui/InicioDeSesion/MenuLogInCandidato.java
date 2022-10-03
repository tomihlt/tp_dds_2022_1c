package gui.InicioDeSesion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.Main;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import clases.enums.TipoDNI;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.Box;

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
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_4;
	private JPasswordField passwordField;
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
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoDNI.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 2;
		panel_2.add(comboBox, gbc_comboBox);
		
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 4;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
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
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 6;
		panel_2.add(passwordField, gbc_passwordField);
		
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

}
