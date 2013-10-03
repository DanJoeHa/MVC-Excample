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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

/**
 * @author Johannes
 *
 */
public class LoginView extends JPanel implements View {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JTextPane txtpnBenutzerDojoPasswort;

	/**
	 * Create the panel.
	 */
	public LoginView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLogin = new JLabel("Login");
		add(lblLogin, "4, 4");
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		add(lblBenutzername, "10, 10, right, default");
		
		textField = new JTextField();
		add(textField, "12, 10, fill, default");
		textField.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort");
		add(lblPasswort, "10, 12, right, default");
		
		passwordField = new JPasswordField();
		add(passwordField, "12, 12, fill, default");
		
		this.btnLogin = new JButton("Login");
		add(btnLogin, "12, 14");
		
		txtpnBenutzerDojoPasswort = new JTextPane();
		txtpnBenutzerDojoPasswort.setEnabled(false);
		txtpnBenutzerDojoPasswort.setEditable(false);
		txtpnBenutzerDojoPasswort.setText("Benutzer: dojo\r\nPasswort: 123456");
		add(txtpnBenutzerDojoPasswort, "12, 18, fill, fill");

	}
	
	public String getBenutzername(){
		return this.textField.getText();
	}
	
	public String getPasswort(){
		return String.valueOf( this.passwordField.getPassword());
	}
	
	@Override
	public void reset(){
		this.textField.setText("");
		this.passwordField.setText("");
	}
	
	@Override
	public void addActionListener(Controller c) {
		this.btnLogin.addActionListener(c);
		
	}
}
