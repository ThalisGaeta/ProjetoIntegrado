package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//set @@global.time_zone = '-3:00'; 

public class ConnectionFactory {
		   
	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	    }
	    public static Connection conectar() throws SQLException {
	        return DriverManager.getConnection
	                ("jdbc:mysql://localhost/ProjetoIntegrado?useSSL=false" , "root",
	                        "Tfaria@2018ç");
	    }
}
