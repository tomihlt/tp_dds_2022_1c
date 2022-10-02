package gui.Consultor;

import javax.swing.JPanel;

import gui.Main;
import gui.InicioDeSesion.MenuLogIn;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuario extends JPanel
{
	private Main wWindow;
	private JPanel mainMenu;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public PanelUsuario(Main wWindow, MenuPrincipal mainMenu)
	{
		this.wWindow = wWindow;
		this.mainMenu = mainMenu;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Imagen de Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weighty = 0.1;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Usted ha iniciado sesion como Apellido Nombre");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.weighty = 0.03;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		btnNewButton = new JButton("Cerrar sesión");
		btnNewButton.addActionListener(e -> {
			MenuLogIn login = new MenuLogIn(wWindow);
			wWindow.setCurrentMenu(login);
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.gridx = 10;
		gbc_lblNewLabel.gridy = 10;
		add(lblNewLabel, gbc_lblNewLabel);
	}

}
