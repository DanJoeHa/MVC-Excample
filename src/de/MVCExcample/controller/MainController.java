/**
 * 
 */
package de.MVCExcample.controller;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import de.MVCExcample.model.User;
import de.MVCExcample.view.LoginView;
import de.MVCExcample.view.MainFrame;
import de.MVCExcample.view.View;
import de.MVCExcample.view.WelcomeView;

/**
 * @author Johannes Haag
 *
 */
public class MainController implements Controller {
	
	private MainFrame frame;
	private User activeUser;
	private Controller activeController;
	
	public MainController(){
		//starte Application-Frame
		this.frame = new MainFrame();
		frame.addActionListener( this );

		//erstelle Login-Controller
		this.activeController = new LoginController( this );
		
		//zeige App-Frame inkl. Login-View
		frame.setContent(this.activeController.getView());
	}
	
	/*
	 * Über die ActionListener-Methode des MainController wird die Rahmensteuerung der App (MenuItems) realisiert
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println(e.getActionCommand());
		
		//user hat sich erfolgreich eingeloggt
		if(e.getActionCommand() == "loggedin"){
			System.out.println("User eingeloggt");
			
			//eingeloggten user von LoginController holen und speichern
			LoginController l = (LoginController) this.activeController;
			this.activeUser = l.getActiveUser();
			
			//prüfen ob User das Recht hat, das Adminmenü zu sehen
			if( this.activeUser.hasRight("Adminmenu") ) this.frame.AdminView();
			
			//setze Willkommen-Screen (ohne Controller, da keine Interaktions-Möglichkeiten)
			this.frame.setContent( new WelcomeView() );
		}
		
		//MenuItem "beenden"
		if(e.getActionCommand() == "exit"){
			System.out.println("App beenden");
			System.exit(0);
		}
		
		//MenuItem "Mitarbeiter anlegen"
		if(e.getActionCommand() == "createMA"){
			System.out.println("Mitarbeiter anlegen");
			
		}
		
		//MenuItemj "Mitarbeiter ändern"
		if(e.getActionCommand() == "editMA"){
			System.out.println("Mitarbeiter ändern");
			
		}
	}

	
	
	
	/*
	 * getView ist beim MainController irrelevant
	 */
	@Override
	public View getView() {
		return null;
	}
}
