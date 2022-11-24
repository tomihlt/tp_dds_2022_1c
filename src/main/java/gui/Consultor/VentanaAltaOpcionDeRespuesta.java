package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.Main;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaAltaOpcionDeRespuesta extends JDialog
{
	
	private Main wWindow;
	private JPanel invocador;
	
	private final JPanel contentPanel = new JPanel();
	private JPanel panelContenido;
	private JPanel panelBotones;
	private JButton cancelarButton;
	private JButton aceptarButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			VentanaAltaOpcionDeRespuesta dialog = new VentanaAltaOpcionDeRespuesta();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public VentanaAltaOpcionDeRespuesta(Main wWindow, JPanel invocador)
	{
		super(wWindow, "Dar de alta función", Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(wWindow);
		this.wWindow = wWindow;
		this.invocador = invocador;
		initialize();
	}
	private void initialize() {
		setBounds(100, 100, 671, 416);
		
		panelContenido = new JPanel();
		getContentPane().add(panelContenido, BorderLayout.SOUTH);
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		
		panel = new JPanel();
		panelContenido.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 10;
		gbc_lblNewLabel_1.gridy = 10;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		cancelarButton = new JButton("Cancelar");
		panelBotones.add(cancelarButton);
		
		aceptarButton = new JButton("Aceptar");
		panelBotones.add(aceptarButton);
	}

}
