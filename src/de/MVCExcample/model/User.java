/**
 * 
 */
package de.MVCExcample.model;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public class User extends RemoteConnection implements Model {
	
	//Attribute
	private String Vorname;
	private String Nachname;
	private String Benutzerid;
	private String Passwort;
	
	private Role rolle;
	
	//Konstruktor
	public User(String userid) {
		
		if( RemoteConnection.connection == null || RemoteConnection.sql == null ){
			RemoteConnection.connect();
		}
		
		try {
			//Userdaten anhand userid aus DB abfragen
			ResultSet res = RemoteConnection.sql.executeQuery( "SELECT * FROM user WHERE BenutzerID = '" + userid +"'" );
			
			//User-Attribute aus DB füllen
			res.first();
			this.setVorname( res.getString("Vorname"));
			this.setNachname(res.getString("Nachname"));
			this.setBenutzerid(res.getString("BenutzerID"));
			this.setPasswort(res.getString("Passwort"));
			
			Role r = new Role(res.getString("Rolle"));
			this.setRolle(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Dummy-Befüllung zu Testzwecken
		if(userid.equals("dojo")){
			this.setVorname("John");
			this.setNachname("Doe");
			this.setPasswort("123456");
			this.setBenutzerid("dojo");
			
			Role r = new Role("Administrator");
			this.setRolle(r);
		}
	}
	
	
	public boolean hasRight(String bez){
		Right r = this.rolle.getRechtByBezeichnung(bez);
		if( r.isGranted() == true ) return true;
		return false;
	}
	
	

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return this.Vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.Vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return this.Nachname;
	}

	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.Nachname = nachname;
	}

	/**
	 * @return the benutzerid
	 */
	public String getBenutzerid() {
		return this.Benutzerid;
	}

	/**
	 * @param benutzerid the benutzerid to set
	 */
	public void setBenutzerid(String benutzerid) {
		this.Benutzerid = benutzerid;
	}

	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return this.Passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	public void setPasswort(String passwort) {
		this.Passwort = passwort;
	}
	
	public void setRolle(Role rolle){
		this.rolle = rolle;
	}
	
	public Role getRolle(){
		return this.rolle;
	}
	
}
