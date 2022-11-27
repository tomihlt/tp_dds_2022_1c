package gui.Consultor.EvaluarCandidatos;

import javax.swing.JPanel;

import gui.Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

public class PanelEvaluarCandidatos extends JPanel
{
	private Main wWindow;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JPanel currentMenu;

	/**
	 * Create the panel.
	 */
	public PanelEvaluarCandidatos(Main wWindow)
	{
		this.wWindow = wWindow;
		initialize();
		setCurrentMenu(new PantallaElegirCandidatos(wWindow));
	}

	private void initialize()
	{
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		contentPane = new JPanel();
		scrollPane.setViewportView(contentPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.setLayout(new CardLayout(0, 0));
	}

	public void setCurrentMenu(JPanel nuevoPanel)
	{
		contentPane.removeAll();
		contentPane.add(nuevoPanel, BorderLayout.CENTER);
		currentMenu = nuevoPanel;
		contentPane.repaint();
		contentPane.revalidate();
	}

	public JPanel getCurrentMenu()
	{
		return currentMenu;
	}

}
