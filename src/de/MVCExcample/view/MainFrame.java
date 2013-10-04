/**
 * 
 */
package de.MVCExcample.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.MVCExcample.controller.Controller;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public class MainFrame extends JFrame implements View{

	private static final long serialVersionUID = -6158813169959585283L;
	private JPanel contentPane, activeView;
	private JMenu mnAdministration, mnDatei;
	private JMenuItem mntmBeenden, mntmMitarbeiterAnlegen, mntmMitarbeiterndern;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MVCExcample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		this.mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		this.mntmBeenden = new JMenuItem("beenden");
		this.mntmBeenden.setActionCommand("exit");
		mnDatei.add(mntmBeenden);
		
		this.mnAdministration = new JMenu("Administration");
		this.mnAdministration.setVisible(false);
		menuBar.add(mnAdministration);
		
		this.mntmMitarbeiterAnlegen = new JMenuItem("Mitarbeiter anlegen");
		this.mntmMitarbeiterAnlegen.setActionCommand("createMA");
		mnAdministration.add(mntmMitarbeiterAnlegen);
		
		this.mntmMitarbeiterndern = new JMenuItem("Mitarbeiter ändern");
		this.mntmMitarbeiterndern.setActionCommand("editMA");
		mnAdministration.add(mntmMitarbeiterndern);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.setVisible(true);
	}

	/* 
	 * Setzte ActionListener
	 */
	@Override
	public void addActionListener(Controller c) {
		this.mntmBeenden.addActionListener(c);
		this.mntmMitarbeiterAnlegen.addActionListener(c);
		this.mntmMitarbeiterndern.addActionListener(c);
	}
	
	/*
	 * Den Inhalt des Hauptfensters erneuern
	 */
	public void setContent(View vi){
		JPanel v = (JPanel) vi;
		try{
			this.contentPane.remove(this.activeView);
		}catch(NullPointerException e){
			System.out.println("error while removing acitve view");
		}
		this.contentPane.add( v, BorderLayout.CENTER);
		this.activeView = v;
		this.contentPane.doLayout();
		this.revalidate();
	}
	
	/*
	 * Den Eintrag "Administration" anzeigen
	 */
	public void AdminView(){
		this.mnAdministration.setVisible(true);
		this.revalidate();
	}
	
	/*
	 * Die Ansicht auf den ursprünglichen Zustand (nicht eingeloggt) zurücksetzen
	 */
	@Override
	public void reset() {
		this.mnAdministration.setVisible(false);
		this.revalidate();
	}
	
}
