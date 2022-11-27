package gui.Consultor.Inicio;

import javax.swing.JPanel;

import gui.Main;
import gui.Consultor.EvaluarCandidatos.PanelEvaluarCandidatos;
import gui.Consultor.EvaluarCandidatos.PantallaElegirCandidatos;
import gui.Consultor.GestionarCompetencias.PanelCompetencias;
import gui.Consultor.GestionarFactores.PanelFactores;
import gui.Consultor.GestionarFunciones.PanelFunciones;
import gui.Consultor.GestionarOpcionDeRespuesta.PanelOpcionDeRespuesta;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;

import clases.dto.ConsultorDTO;

import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MenuPrincipal extends JPanel
{
	private Integer lastSelectedTab;
	private Main wWindow;
	private ConsultorDTO consultor;
	private JPanel currentMenu;
	private JTabbedPane tabbedPane;
	private JPanel inicioTab;
	private JPanel gestionarCandidatosTab;
	private JPanel impCandidatosTab;
	private JPanel panelCompetencias;
	private JPanel panelFactores;
	private JPanel panel_1;
	private JPanel panelFunciones;
	private JPanel panelEvaluarCandidatos;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panelOpcionDeRespuesta;

	/**
	 * Create the panel.
	 */
	public MenuPrincipal(Main wWindow, ConsultorDTO consultor)
	{
		this.wWindow = wWindow;
		this.consultor = consultor;
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				if (tabbedPane.getSelectedIndex() == 9)
					tabbedPane.setComponentAt(9, new PanelEvaluarCandidatos(wWindow));
			}
		});
		add(tabbedPane, BorderLayout.CENTER);
		
		inicioTab = new PanelUsuario(wWindow, consultor);
		tabbedPane.addTab("Inicio", null, inicioTab, null);

		gestionarCandidatosTab = new JPanel();
		tabbedPane.addTab("Gestionar candidatos", null, gestionarCandidatosTab, null);

		impCandidatosTab = new JPanel();
		tabbedPane.addTab("Importar candidatos", null, impCandidatosTab, null);

		panelCompetencias = new PanelCompetencias(wWindow);
		tabbedPane.addTab("Gestionar competencias", null, panelCompetencias, null);

		panelFactores = new PanelFactores(wWindow);
		tabbedPane.addTab("Gestionar factores", null, panelFactores, null);

		// Pestaña opcion de respuesta
		panelOpcionDeRespuesta = new PanelOpcionDeRespuesta(wWindow);
		tabbedPane.addTab("Gestionar Opciones de respuesta", null, panelOpcionDeRespuesta, null);

		panel_6 = new JPanel();
		tabbedPane.addTab("Orden de méritos", null, panel_6, null);

		panel_1 = new JPanel();
		tabbedPane.addTab("Gestionar preguntas", null, panel_1, null);

		panelFunciones = new PanelFunciones(wWindow);
		tabbedPane.addTab("Gestionar funciones", null, panelFunciones, null);

		panelEvaluarCandidatos = new PanelEvaluarCandidatos(wWindow);
		tabbedPane.addTab("Evaluar candidatos", null, panelEvaluarCandidatos, null);

		panel_4 = new JPanel();
		tabbedPane.addTab("Exportar resultados", null, panel_4, null);

		panel_5 = new JPanel();
		tabbedPane.addTab("Reporte comparativo", null, panel_5, null);

	}

}
