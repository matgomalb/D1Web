package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			System.out.println("Procurando Driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Encontrado");
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Drive N�O Encontrado");
			ex.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		try {
			System.out.println("Estabelecendo Conex�o...");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/portal_realnews?useSSL=false",		
			"root", "");
			
			System.out.println("Conex�o Estabelecida com Sucesso");
			
			return c;
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;	
		}		
	}
}
