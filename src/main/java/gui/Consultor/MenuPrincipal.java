package gui.Consultor;

import javax.swing.JPanel;

import gui.Main;
import gui.InicioDeSesion.MenuLogIn;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPrincipal extends JPanel
{
	private Main wWindow;
	private JPanel menuBarPanel;
	private JMenuBar menuBar;
	private JMenu gestionarCandidatosMenu;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;
	private JMenu mnNewMenu_8;
	private JPanel panelCentral;
	private JLabel lblNewLabel;
	private JLabel iconoUsuario;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JButton cerrarSesionButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Create the panel.
	 */
	public MenuPrincipal(Main wWindow)
	{
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));

		menuBarPanel = new JPanel();
		add(menuBarPanel, BorderLayout.NORTH);
		GridBagLayout gbl_menuBarPanel = new GridBagLayout();
		gbl_menuBarPanel.columnWidths = new int[]{1166, 0};
		gbl_menuBarPanel.rowHeights = new int[]{22, 0};
		gbl_menuBarPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_menuBarPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		menuBarPanel.setLayout(gbl_menuBarPanel);
		
				menuBar = new JMenuBar();
				GridBagConstraints gbc_menuBar = new GridBagConstraints();
				gbc_menuBar.weightx = 1.0;
				gbc_menuBar.gridx = 0;
				gbc_menuBar.gridy = 0;
				menuBarPanel.add(menuBar, gbc_menuBar);
				
						gestionarCandidatosMenu = new JMenu("Gestionar candidatos");
						menuBar.add(gestionarCandidatosMenu);
						
						mnNewMenu = new JMenu("Importar candidatos");
						menuBar.add(mnNewMenu);
						
						mnNewMenu_1 = new JMenu("Gestionar competencias");
						menuBar.add(mnNewMenu_1);
						
						mnNewMenu_2 = new JMenu("Gestionar factores");
						menuBar.add(mnNewMenu_2);
						
						mnNewMenu_3 = new JMenu("Gestionar preguntas");
						menuBar.add(mnNewMenu_3);
						
						mnNewMenu_4 = new JMenu("Gestionar puestos");
						menuBar.add(mnNewMenu_4);
						
						mnNewMenu_5 = new JMenu("Evaluar candidatos");
						menuBar.add(mnNewMenu_5);
						
						mnNewMenu_6 = new JMenu("Exportar resultados");
						menuBar.add(mnNewMenu_6);
						
						mnNewMenu_7 = new JMenu("Reporte comparativo");
						menuBar.add(mnNewMenu_7);
						
						mnNewMenu_8 = new JMenu("Orden de méritos");
						menuBar.add(mnNewMenu_8);
						
						panelCentral = new JPanel();
						add(panelCentral, BorderLayout.CENTER);
						GridBagLayout gbl_panelCentral = new GridBagLayout();
						gbl_panelCentral.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
						gbl_panelCentral.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
						gbl_panelCentral.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
						gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
						panelCentral.setLayout(gbl_panelCentral);
						
						lblNewLabel = new JLabel("");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.weighty = 0.5;
						gbc_lblNewLabel.weightx = 0.5;
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel.gridx = 0;
						gbc_lblNewLabel.gridy = 0;
						panelCentral.add(lblNewLabel, gbc_lblNewLabel);
						
						iconoUsuario = new JLabel("Icono usuario");
						iconoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
						GridBagConstraints gbc_iconoUsuario = new GridBagConstraints();
						gbc_iconoUsuario.insets = new Insets(0, 0, 5, 5);
						gbc_iconoUsuario.gridx = 10;
						gbc_iconoUsuario.gridy = 10;
						panelCentral.add(iconoUsuario, gbc_iconoUsuario);
						
						lblNewLabel_2 = new JLabel("Usted ha iniciado sesión como Apellido Nombre");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
						GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
						gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_2.gridx = 10;
						gbc_lblNewLabel_2.gridy = 12;
						panelCentral.add(lblNewLabel_2, gbc_lblNewLabel_2);
						
						lblNewLabel_1 = new JLabel("");
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.weightx = 0.5;
						gbc_lblNewLabel_1.weighty = 0.5;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 21;
						gbc_lblNewLabel_1.gridy = 20;
						panelCentral.add(lblNewLabel_1, gbc_lblNewLabel_1);
						
						cerrarSesionButton = new JButton("Cerrar sesión");
						cerrarSesionButton.addActionListener(e -> {
							MenuLogIn menulogin = new MenuLogIn(wWindow);
							wWindow.setCurrentMenu(menulogin);
						});
						GridBagConstraints gbc_cerrarSesionButton = new GridBagConstraints();
						gbc_cerrarSesionButton.insets = new Insets(0, 0, 5, 5);
						gbc_cerrarSesionButton.gridx = 10;
						gbc_cerrarSesionButton.gridy = 14;
						panelCentral.add(cerrarSesionButton, gbc_cerrarSesionButton);
						
						lblNewLabel_3 = new JLabel("");
						GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
						gbc_lblNewLabel_3.weighty = 0.06;
						gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_3.gridx = 10;
						gbc_lblNewLabel_3.gridy = 11;
						panelCentral.add(lblNewLabel_3, gbc_lblNewLabel_3);
						
						lblNewLabel_4 = new JLabel("");
						GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
						gbc_lblNewLabel_4.weighty = 0.03;
						gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_4.gridx = 10;
						gbc_lblNewLabel_4.gridy = 13;
						panelCentral.add(lblNewLabel_4, gbc_lblNewLabel_4);

	}

}
