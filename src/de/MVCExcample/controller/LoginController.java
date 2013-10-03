/**
 * 
 */
package de.MVCExcample.controller;

import java.awt.event.ActionEvent;

import de.MVCExcample.model.User;
import de.MVCExcample.view.LoginView;
import de.MVCExcample.view.View;

/**
 * @author Johannes Haag
 * @version 1.0
 */
public class LoginController implements Controller {

	private LoginView view;
	private MainController MainController;
	private User user;
	
	public LoginController(MainController MainController){
		this.MainController = MainController;
		
		this.view = new LoginView();
		this.view.addActionListener( this );
	}
	
	public User getActiveUser(){
		return this.user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//hole User zu Benutzername
		this.user = new User ( this.view.getBenutzername() );
		
		//prüfe Nutzerangaben
		if( this.view.getPasswort().equals( this.user.getPasswort() ) ){
			//korrekt
			ActionEvent loggedin = new ActionEvent(this, 0, "loggedin");
			this.MainController.actionPerformed(loggedin);
		}else{
			//falsch
			this.view.reset();
		}
		
	}

	@Override
	public View getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

}
