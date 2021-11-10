package com.add.ejercicio3;

import com.csvreader.CsvReader;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
	
	public class CSVMySQL {
		
		static String basedatos = "aadu2";
	    static String host = "localhost";
	    static String port = "3306";
	    static String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    static String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    static String user = "root";
	    static String pwd = "Oskitar2301";
	    
	    public static void main(String[] args) throws SQLException {
	        List<Usuario> usuarios = new ArrayList<Usuario>();
	        
	        usuarios = importarCSV();
	        
	        insertarMySQL(usuarios);
	    }
	    
	    public static List<Usuario> importarCSV() {
	        List<Usuario> usuarios = new ArrayList<Usuario>();
	        
	        try {
	            CsvReader leerUsuarios = new CsvReader("C:\\Users\\oskit\\OneDrive\\Escritorio\\Acceso a Datos\\usuarios.csv");
	            leerUsuarios.readHeaders();
	            
	            while(leerUsuarios.readRecord()) {
	            	String id = leerUsuarios.get(0);
	                String nombre = leerUsuarios.get(1);
	                String apellido = leerUsuarios.get(2);
	                String email = leerUsuarios.get(3);
	                
	                usuarios.add(new Usuario(id, nombre, apellido, email));
	            }
	            
	            leerUsuarios.close();
	            
	            System.out.println("LISTA DE USUARIOS DEL CSV\n");
	            for(Usuario user : usuarios) {
	                System.out.println(
	                		user.getId()+" "+
	                        user.getNombre()+" "+
	                        user.getApellido()+" "+
	                        user.getEmail()+" ");
	            }
	        } catch(FileNotFoundException e) {
	            e.printStackTrace();
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	        
	        return usuarios;
	        
	    }
	    
	    public static void insertarMySQL(List<Usuario> usuarios) throws SQLException {
	        System.out.println("\nSE VAN A INSERTA: "+usuarios.size()+" REGISTROS\n");
	        
	        ConexionMySQL sql = new ConexionMySQL();
	        Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	        
	        String query = "INSERT INTO aadu2.usuarios(id, nombre, apellido, email) VALUES(?,?,?,?)";
	        
	        try {
	            JdbcPreparedStatement ps = (JdbcPreparedStatement) c.prepareStatement(query);
	            
	            for(int i = 0 ; i < usuarios.size() ; i++) {
	                ps.setString(1, usuarios.get(i).getId());
	                ps.setString(2, usuarios.get(i).getNombre());
	                ps.setString(3, usuarios.get(i).getApellido());
	                ps.setString(4, usuarios.get(i).getEmail());
	                
	                ps.executeUpdate();
	                
	                System.out.println("Se inserto el elemento: "+(i+1)+"/"+usuarios.size());
	            }
	            
	            ps.close();
	            c.close();
	        } catch(SQLException e) {
	            
	        }
	    }
	}