/**
 * 
 */
package de.MVCExcample.view;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import de.MVCExcample.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JEditorPane;

/**
 * @author Johannes
 *
 */
public class WelcomeView extends JPanel implements View {

	/**
	 * Create the panel.
	 */
	public WelcomeView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(249dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblHerzlichWillkommen = new JLabel("Herzlich Willkommen!");
		add(lblHerzlichWillkommen, "4, 4");
		
		JLabel lblBitteWhlenSie = new JLabel("");
		add(lblBitteWhlenSie, "4, 8");
		
		JTextArea txtrBitteWhlenSie = new JTextArea();
		txtrBitteWhlenSie.setWrapStyleWord(true);
		txtrBitteWhlenSie.setEnabled(false);
		txtrBitteWhlenSie.setEditable(false);
		txtrBitteWhlenSie.setBackground(Color.WHITE);
		txtrBitteWhlenSie.setLineWrap(true);
		txtrBitteWhlenSie.setText("Bitte wählen Sie in der Menüzeile oben die gewünschte Aktion aus.\r\n\r\nBei Fragen und Problemen finden Sie bitte einen geeigneten Ansprechpartner ;)");
		add(txtrBitteWhlenSie, "4, 12, fill, fill");

	}

	@Override
	public void addActionListener(Controller c) {
		// wird hier nicht gebraucht, da keine Interaktionsmöglichkeiten
		
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
