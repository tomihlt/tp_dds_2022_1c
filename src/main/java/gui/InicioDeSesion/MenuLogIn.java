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

public class MenuLogIn extends JPanel
{
	
	private Main wWindow;
	private JPanel panelSur;
	private JButton salirButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton usuarioButton;
	private JButton cuestionarioButton;
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
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 0.5;
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		usuarioButton = new JButton("Ingresar como usuario");
		usuarioButton.addActionListener(e -> {
			MenuLogInUsuario loginUsuario = new MenuLogInUsuario(this.wWindow);
			this.wWindow.setCurrentMenu(loginUsuario);
		});
		GridBagConstraints gbc_usuarioButton = new GridBagConstraints();
		gbc_usuarioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuarioButton.insets = new Insets(10, 0, 10, 5);
		gbc_usuarioButton.gridx = 4;
		gbc_usuarioButton.gridy = 4;
		panel.add(usuarioButton, gbc_usuarioButton);
		
		cuestionarioButton = new JButton("Realizar cuestionario");
		cuestionarioButton.addActionListener(e -> {
			MenuLogInCandidato loginCandidato = new MenuLogInCandidato(wWindow);
			wWindow.setCurrentMenu(loginCandidato);			
		});
		GridBagConstraints gbc_cuestionarioButton = new GridBagConstraints();
		gbc_cuestionarioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cuestionarioButton.insets = new Insets(10, 0, 10, 5);
		gbc_cuestionarioButton.gridx = 4;
		gbc_cuestionarioButton.gridy = 5;
		panel.add(cuestionarioButton, gbc_cuestionarioButton);
		
		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.gridx = 10;
		gbc_lblNewLabel_1.gridy = 10;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
}
