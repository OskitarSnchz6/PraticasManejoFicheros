package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
		static String driverClassName = "com.mysql.jdbc.Driver";
		static String connectionUrl = "jdbc:mysql://localhost:3306/aadu2";
		static String user = "root";
		static String pwd = "Oskitar2301";


		private ConexionSQL() {
			try {
				Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public Connection getConnection() throws SQLException {
			Connection conn;
			conn = DriverManager.getConnection(connectionUrl, user, pwd);
			return conn;
		}
}
