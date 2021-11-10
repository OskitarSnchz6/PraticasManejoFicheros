/*package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pruebaCRUD {
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo especifico: " + e.getErrorCode());
	  }

	  public static void main(String[] args) {

	    String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "Oskitar2301";
	    
		try {		
		
		Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
		Statement st = conn.createStatement();
		
		st.execute("DROP TABLE IF EXISTS estudiantes");
		st.executeUpdate("CREATE TABLE IF NOT EXISTS estudiantes ("
				+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
				+ "nombre varchar(50),"
				+ "apellido varchar(50),"
				+ "modulo varchar(50),"
				+ "PRIMARY KEY (id));");
		System.out.println("Tabla creada");
		System.out.println("\n");
		
		st.executeUpdate("INSERT INTO estudiantes (nombre, apellido, modulo) "
				+ "VALUES ('Julia', 'Gracia', 'DAM'),"
				+ "('Javier', 'Fuentes', 'DAW'),"
				+ "('Julia', 'Rodríguez', 'ASIR'),"
				+ "('Jacobo', 'Ruiz', 'SMR');");
		System.out.println("Estudiantes insertados");
		
		ResultSet rs1 = st.executeQuery("SELECT * FROM estudiantes");
			int i=1;
		      while (rs1.next()) {
		    	System.out.println("--------------------");
		        System.out.println("ID: "+ i++);        
		        System.out.println("Nombre: " + rs1.getString("nombre"));
		        System.out.println("Apellido: " + rs1.getString("apellido"));
		        System.out.println("Modulo: " + rs1.getString("modulo"));
		      } 
		
		 st.executeUpdate("UPDATE estudiantes SET modulo='DAM' WHERE id=2");
		 
		 System.out.println("\n Estudiante actualizado");
		 
		 ResultSet rs2 = st.executeQuery("SELECT * FROM estudiantes WHERE id = 2");
			int x=1;
		      while (rs2.next()) {
		    	System.out.println("--------------------");
		        System.out.println("ID: "+ x++);        
		        System.out.println("Nombre: " + rs2.getString("nombre"));
		        System.out.println("Apellido: " + rs2.getString("apellido"));
		        System.out.println("Modulo: " + rs2.getString("modulo"));
		      }
		 
		 st.executeUpdate("DELETE FROM estudiantes WHERE id = 2");
		 
		 System.out.println("\n Estudiante borrado");
		 
		 ResultSet rs3 = st.executeQuery("SELECT * FROM estudiantes");
		 int a=1;
		 while (rs3.next()) {
		    	System.out.println("--------------------");
		        System.out.println("ID: "+ a++);        
		        System.out.println("Nombre: " + rs3.getString("nombre"));
		        System.out.println("Apellido: " + rs3.getString("apellido"));
		        System.out.println("Modulo: " + rs3.getString("modulo"));
		 }
		 
		 st.execute("INSERT INTO estudiantes (nombre, apellido, modulo) VALUES ('Jonh', 'Romero', 'TAE'");
		 
		 System.out.println("\n Estudiante añadido");
		 
		 ResultSet rs4 = st.executeQuery("SELECT * FROM estudiantes WHERE id = 5");
		 int y=1;
		 while (rs4.next()) {
		    	System.out.println("--------------------");
		        System.out.println("ID: "+ y++);        
		        System.out.println("Nombre: " + rs4.getString("nombre"));
		        System.out.println("Apellido: " + rs4.getString("apellido"));
		        System.out.println("Modulo: " + rs4.getString("modulo"));
		 }
		 
		 st.execute("TRUNCATE TABLE estudiantes");
		 
		 System.out.println("\n Estudiantes borrados");
		 
		 ResultSet rs5 = st.executeQuery("SELECT * FROM estudiantes");
		 int o=1;
		 while (rs5.next()) {
		    	System.out.println("--------------------");
		        System.out.println("ID: "+ o++);        
		        System.out.println("Nombre: " + rs5.getString("nombre"));
		        System.out.println("Apellido: " + rs5.getString("apellido"));
		        System.out.println("Modulo: " + rs5.getString("modulo"));
		        
		 		}
		 conn.close();
			} 
	catch (SQLException e) {
		e.printStackTrace();
		}
		
	}

	public static Connection conectar() {
		return null;
	}

}
*/