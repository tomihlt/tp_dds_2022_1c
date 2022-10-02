package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.InicioDeSesion.MenuLogIn;

import java.awt.CardLayout;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Main extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel currentMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				try
//				{
		Main frame = new Main();
		frame.setVisible(true);
//				} catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public Main()
	{
		setTitle("TP DDS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel m = new MenuLogIn(this);
		setCurrentMenu(m);
		
		setLocationRelativeTo(null);
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
