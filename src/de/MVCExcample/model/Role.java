/**
 * 
 */
package de.MVCExcample.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public class Role implements Model {
	
	private Collection<Right> rechte = new LinkedList<>();
	private String bezeichnung;
	
	public Role(String bez){
		//aus DB holen
		
		//Dummy-Befüllung Testzwecke
		if( bez.equals("Administrator") ){
			this.setBezeichnung(bez);
			
			Right r = new Right("Adminmenu");
			this.addRecht(r);
		}
	}
	
	public void setBezeichnung(String bezeichnung){
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}
	
	public void addRecht(Right r){
		this.rechte.add(r);
	}
	
	public Collection<Right> getRechte(){
		return this.rechte;
	}
	
	public Right getRechtByBezeichnung(String bezeichnung){
		Iterator<Right> i = this.rechte.iterator();
		
		while( i.hasNext() ){
			Right r = (Right) i.next();
			if( bezeichnung.equalsIgnoreCase(r.getBezeichnung()) ){
				return r;
			}
		}
		
		return null;
	}	
}
