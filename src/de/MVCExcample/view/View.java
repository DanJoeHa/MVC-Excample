/**
 * 
 */
package de.MVCExcample.view;

import de.MVCExcample.controller.Controller;

/**
 * @author Johannes Haag
 * @version 1.0
 *
 */
public interface View {
	public void addActionListener(Controller c);
	public void reset();
}
