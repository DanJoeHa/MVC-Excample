/**
 * 
 */
package de.MVCExcample.controller;

import java.awt.event.ActionListener;
import de.MVCExcample.view.View;

/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public interface Controller extends ActionListener {
	
	public View getView();
		
}
