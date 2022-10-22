package gui.Consultor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.dao.interfaces.EmpresaDAO;
import clases.dao.postgres.PostgresEmpresa;
import clases.dto.EmpresaDTO;
import clases.entidades.Empresa;
import clases.gestores.GestorFuncion;
import gui.Main;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaAgregarEmpresa extends JDialog
{

	private Main wWindow;
	private JDialog invocador;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombreTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			VentanaAgregarEmpresa dialog = new VentanaAgregarEmpresa();
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
	public VentanaAgregarEmpresa(Main wWindow, JDialog invocador)
	{
		super(invocador, "Añadir empresa", Dialog.ModalityType.DOCUMENT_MODAL);
		this.wWindow = wWindow;
		this.invocador = invocador;
		setLocationRelativeTo(invocador);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]
		{ 0, 0, 0, 139, 0, 0 };
		gbl_contentPanel.rowHeights = new int[]
		{ 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.weighty = 0.5;
			gbc_lblNewLabel.weightx = 0.5;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 2;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			nombreTxt = new JTextField();
			GridBagConstraints gbc_nombreTxt = new GridBagConstraints();
			gbc_nombreTxt.insets = new Insets(0, 0, 5, 5);
			gbc_nombreTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_nombreTxt.gridx = 3;
			gbc_nombreTxt.gridy = 1;
			contentPanel.add(nombreTxt, gbc_nombreTxt);
			nombreTxt.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.weightx = 0.5;
			gbc_lblNewLabel_2.weighty = 0.5;
			gbc_lblNewLabel_2.gridx = 4;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(e -> {
					dispose();
				});
				cancelarButton.setActionCommand("OK");
				buttonPane.add(cancelarButton);
				getRootPane().setDefaultButton(cancelarButton);
			}
			{
				JButton aceptarButton = new JButton("Aceptar");
				aceptarButton.addActionListener(e -> agregarEmpresa());
				aceptarButton.setActionCommand("Cancel");
				buttonPane.add(aceptarButton);
			}
		}
	}

	private void agregarEmpresa()
	{
		if (!nombreValido())
		{
			JOptionPane.showMessageDialog(this,
					"El nombre de la empresa supera los 200 caracteres o no se facilito uno", "Error",
					JOptionPane.ERROR_MESSAGE);

			return;
		}

//		EmpresaDAO dao = new PostgresEmpresa();
//		Empresa e = new Empresa();
//		e.setNombre(nombreTxt.getText());
//		try
//		{													Esto lo hace el GestorFuncion
//			dao.add(e);
//			dispose();
//		} catch (SQLException e1)
//		{
//			JOptionPane.showInternalMessageDialog(this, "No se pudo agregar la empresa a la BDD", "Error BDD",
//					JOptionPane.ERROR_MESSAGE);
//			e1.printStackTrace();
//		}

		GestorFuncion gest = new GestorFuncion();
		EmpresaDTO e = new EmpresaDTO();
		e.setNombre(nombreTxt.getText().toString());
		try
		{
			gest.addEmpresa(e);
			((VentanaAltaFuncion) invocador).agregarElementoEmpresaCbx(e);
			dispose();
		} catch (SQLException e1)
		{
			JOptionPane.showInternalMessageDialog(this, "No se pudo agregar la empresa a la BDD", "Error BDD",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}

	private boolean nombreValido()
	{
		return !(nombreTxt.getText().isEmpty() || nombreTxt.getText().isBlank() || nombreTxt.getText().length() > 200);
	}

}
