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
import java.awt.CardLayout;

public class MenuPrincipal extends JPanel
{
	private Main wWindow;
	private JPanel currentMenu;
	private JPanel menuBarPanel;
	private JMenuBar menuBar;
	private JMenu gestionarCandidatosMenu;
	private JMenu importarCandidatosMenu;
	private JMenu gestionarCompetenciasMenu;
	private JMenu gestionarFactoresMenu;
	private JMenu gestionarPreguntasMenu;
	private JMenu gestionarPuestosMenu;
	private JMenu evaluarCandidatosMenu;
	private JMenu exportarResultadosMenu;
	private JMenu reporteComparativoMenu;
	private JMenu ordenDeMeritosMenu;
	private JPanel panelCentral;

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
		gbl_menuBarPanel.columnWidths = new int[]
		{ 1166, 0 };
		gbl_menuBarPanel.rowHeights = new int[]
		{ 22, 0 };
		gbl_menuBarPanel.columnWeights = new double[]
		{ 0.0, Double.MIN_VALUE };
		gbl_menuBarPanel.rowWeights = new double[]
		{ 0.0, Double.MIN_VALUE };
		menuBarPanel.setLayout(gbl_menuBarPanel);

		menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.weightx = 1.0;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		menuBarPanel.add(menuBar, gbc_menuBar);

		gestionarCandidatosMenu = new JMenu("Gestionar candidatos");
		menuBar.add(gestionarCandidatosMenu);

		importarCandidatosMenu = new JMenu("Importar candidatos");
		menuBar.add(importarCandidatosMenu);

		gestionarCompetenciasMenu = new JMenu("Gestionar competencias");
		menuBar.add(gestionarCompetenciasMenu);

		gestionarFactoresMenu = new JMenu("Gestionar factores");
		menuBar.add(gestionarFactoresMenu);

		gestionarPreguntasMenu = new JMenu("Gestionar preguntas");
		menuBar.add(gestionarPreguntasMenu);

		gestionarPuestosMenu = new JMenu("Gestionar puestos");
		menuBar.add(gestionarPuestosMenu);

		evaluarCandidatosMenu = new JMenu("Evaluar candidatos");
		menuBar.add(evaluarCandidatosMenu);

		exportarResultadosMenu = new JMenu("Exportar resultados");
		menuBar.add(exportarResultadosMenu);

		reporteComparativoMenu = new JMenu("Reporte comparativo");
		menuBar.add(reporteComparativoMenu);

		ordenDeMeritosMenu = new JMenu("Orden de méritos");
		menuBar.add(ordenDeMeritosMenu);

		panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new CardLayout(0, 0));

	}
	
	public void setCurrentMenu(JPanel nuevoPanel)
	{
		panelCentral.removeAll();
		panelCentral.add(nuevoPanel, BorderLayout.CENTER);
		currentMenu = nuevoPanel;
		panelCentral.repaint();
		panelCentral.revalidate();
	}

	public JPanel getCurrentMenu()
	{
		return currentMenu;
	}

}
