package gui.InicioDeSesion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Main;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class MenuLogIn extends JPanel
{
	
	private Main wWindow;
	private JPanel panelSur;
	private JButton salirButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton usuarioButton;
	private JButton cuestionarioButton;
	private Component verticalStrut;
	private JLabel lblNewLabel_4;
	/**
	 * Create the panel.
	 */
	public MenuLogIn(Main wWindow)
	{	
		this.wWindow = wWindow;
		setLayout(new BorderLayout(0, 0));
		
		panelSur = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panelSur, BorderLayout.SOUTH);
		
		salirButton = new JButton("Salir");
		salirButton.addActionListener(e -> {
			wWindow.dispose();
		});
		panelSur.add(salirButton);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_4 = new JLabel("Iniciar sesión");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.weighty = 0.25;
		gbc_lblNewLabel_2.weightx = 0.25;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		usuarioButton = new JButton("Ingresar como usuario");
		usuarioButton.addActionListener(e -> {
			MenuLogInUsuario loginUsuario = new MenuLogInUsuario(wWindow);
			wWindow.setCurrentMenu(loginUsuario);
		});
		GridBagConstraints gbc_usuarioButton = new GridBagConstraints();
		gbc_usuarioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuarioButton.insets = new Insets(0, 0, 5, 5);
		gbc_usuarioButton.gridx = 1;
		gbc_usuarioButton.gridy = 2;
		panel_1.add(usuarioButton, gbc_usuarioButton);
		
		verticalStrut = Box.createVerticalStrut(50);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 3;
		panel_1.add(verticalStrut, gbc_verticalStrut);
		
		cuestionarioButton = new JButton("Realizar cuestionario");
		cuestionarioButton.addActionListener(e -> {
			MenuLogInCandidato loginCandidato = new MenuLogInCandidato(wWindow);
			wWindow.setCurrentMenu(loginCandidato);
		});
		GridBagConstraints gbc_cuestionarioButton = new GridBagConstraints();
		gbc_cuestionarioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cuestionarioButton.insets = new Insets(0, 0, 5, 5);
		gbc_cuestionarioButton.gridx = 1;
		gbc_cuestionarioButton.gridy = 4;
		panel_1.add(cuestionarioButton, gbc_cuestionarioButton);
		
		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weightx = 0.25;
		gbc_lblNewLabel_3.weighty = 0.25;
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 5;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.gridx = 10;
		gbc_lblNewLabel_1.gridy = 10;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
}
