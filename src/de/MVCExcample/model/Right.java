/**
 * 
 */
package de.MVCExcample.model;

/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public class Right implements Model {
	
	private String Bezeichnung;
	private boolean Granted;
	
	public Right(String bez){
		
		this.setBezeichnung(bez);
		this.setGranted(true);
	}
	
	/**
	 * @return the Bezeichnung
	 */
	public String getBezeichnung() {
		return Bezeichnung;
	}
	/**
	 * @param Bezeichnung the Bezeichnung to set
	 */
	public void setBezeichnung(String Bezeichnung) {
		this.Bezeichnung = Bezeichnung;
	}
	/**
	 * @return the granted
	 */
	public boolean isGranted() {
		return Granted;
	}
	/**
	 * @param granted the granted to set
	 */
	public void setGranted(boolean granted) {
		this.Granted = granted;
	}
	
	
	
}
