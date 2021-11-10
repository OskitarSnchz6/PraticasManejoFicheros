package com.add.ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo: " + e.getErrorCode());
	  }

	  public static void main(String[] args) {

	    String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "Oskitar2301";

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s = c.createStatement()) {
	      s.execute("DROP TABLE IF EXISTS usuarios;");
	      s.execute("CREATE TABLE aadu2.usuarios (id MEDIUMINT NOT NULL AUTO_INCREMENT,"
	    		  + " nombre varchar(100),"
	              + " apellido varchar(100),"
	    		  +	" email varchar(100),"
	              + " PRIMARY KEY (id));");

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }
}

