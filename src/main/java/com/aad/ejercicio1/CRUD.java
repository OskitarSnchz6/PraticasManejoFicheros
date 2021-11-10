package com.aad.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CRUD {
	public static void main(String[] args) {
		try {
			//Agregamos primero la dependecia de la h2database en el pom.xml
			
			//Class.forName("org.h2.Driver");
			Connection conn= DriverManager.getConnection("jdbc:h2:"+"./Database/AADU2"+"sa"+" ");
			Statement st = conn.createStatement();
			
			st.execute("DROP TABLE IF EXISTS ESTUDIANTES");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS ESTUDIANTES ("
					+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
					+ "nombre varchar(50),"
					+ "apellido varchar(50),"
					+ "modulo varchar(50),"
					+ "PRIMARY KEY (id));");
			System.out.println("Table created");
			System.out.println("\n");
			
			st.executeUpdate("INSERT INTO estudiantes (nombre, apellido, modulo) "
					+ "VALUES ('Oscar', 'Sanchez', 'IT'),"
					+ "('David', 'Antón', 'IT'),"
					+ "('Gonzalo', 'DelCodo', 'Jardineria'),"
					+ "('Ruben', 'Domingo', 'TAFAD'),"
					+ "('Javier', 'Iribas', 'ADE');");
			System.out.println("Datos insertados");
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM ESTUDIANTES");
				int i=1;
			      while (rs1.next()) {
			    	System.out.println("--------------------");
			        System.out.println("ID: "+ i++);        
			        System.out.println("Nombre: " + rs1.getString("nombre"));
			        System.out.println("Apellido: " + rs1.getString("apellido"));
			        System.out.println("Modulo: " + rs1.getString("modulo"));
			      } 
			
			 st.executeUpdate("UPDATE estudiantes SET modulo='Informatica' WHERE id=1");
			 st.executeUpdate("DELETE FROM ESTUDIANTES WHERE id = 5");
			 System.out.println("\nDatos actualizados");
			 System.out.println("\n");
			 
			 ResultSet rs2 = st.executeQuery("SELECT * FROM ESTUDIANTES");
			 int a=1;
			 while (rs2.next()) {
			    	System.out.println("--------------------");
			        System.out.println("ID: "+ a++);        
			        System.out.println("Nombre: " + rs2.getString("nombre"));
			        System.out.println("Apellido: " + rs2.getString("apellido"));
			        System.out.println("Modulo: " + rs2.getString("modulo"));
			 }
			 conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
