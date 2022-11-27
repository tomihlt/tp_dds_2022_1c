package gui.Consultor.Inicio;

import javax.swing.JPanel;

import gui.Main;
import gui.Consultor.EvaluarCandidatos.PanelEvaluarCandidatos;
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
	private JPanel gestionarCompetenciasTab;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;

	/**
	 * Create the panel.
	 */
	public MenuPrincipal(Main wWindow,ConsultorDTO consultor)
	{
		this.wWindow = wWindow;
		this.consultor = consultor;
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		inicioTab = new JPanel();
		tabbedPane.addTab("Inicio", null, new PanelUsuario(wWindow,consultor), null);
		
		gestionarCandidatosTab = new JPanel();
		tabbedPane.addTab("Gestionar candidatos", null, gestionarCandidatosTab, null);
		
		impCandidatosTab = new JPanel();
		tabbedPane.addTab("Importar candidatos", null, impCandidatosTab, null);
		
		gestionarCompetenciasTab = new JPanel();
		tabbedPane.addTab("Gestionar competencias", null, new PanelCompetencias(wWindow), null);
		
		panel = new JPanel();
		tabbedPane.addTab("Gestionar factores", null, new PanelFactores(wWindow), null);
		
		//Pestaña opcion de respuesta
		tabbedPane.addTab("Gestionar Opciones de respuesta", null, new PanelOpcionDeRespuesta(wWindow), null);
		
		panel_6 = new JPanel();
		tabbedPane.addTab("Orden de méritos", null, panel_6, null);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Gestionar preguntas", null, panel_1, null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Gestionar funciones", null, new PanelFunciones(wWindow), null);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Evaluar candidatos", null, new PanelEvaluarCandidatos(wWindow), null);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Exportar resultados", null, panel_4, null);
		
		panel_5 = new JPanel();
		tabbedPane.addTab("Reporte comparativo", null, panel_5, null);

	}

}
