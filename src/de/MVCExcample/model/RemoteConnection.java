package de.MVCExcample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoteConnection {
	
	protected static Connection connection = null;
	protected static Statement sql = null;
	
	public static void connect(){
		try{
			//DB-Verbindung aufbauen inkl. DB auswählen
			RemoteConnection.connection = DriverManager.getConnection("jdbc:mysql://141.31.67.147/mvc-excample", "root", "");
			
			//Statement erstellen
			RemoteConnection.sql = connection.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
