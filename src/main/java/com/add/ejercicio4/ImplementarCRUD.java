/*package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementarCRUD implements EstudianteDAO {
	
		
		public boolean create(Estudiante estudiante) {
			boolean create = false;
			
			Statement stm;
			Connection conn;
			
			String sql=("INSERT INTO estudiantes (id, nombre, apellido, modulo) VALUES "
											+ "('Julia', 'García', 'DAM'), ('Javier', 'Fuentes', 'DAW'),"
											+ "('Julia', 'Rodríguez', 'ASIR'), ('Jacobo', Ruiz', 'SMR')");
			
			try {			
				conn=ConexionSQL.conectar();
				stm= conn.createStatement();
				stm.execute(sql);
				create=true;
				stm.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error: Clase ImplementarCRUD, método registrar");
				e.printStackTrace();
			}
			return create;
		}
	 
		public List<Estudiante> read() {
			Connection conn;
			Statement stm;
			ResultSet rs;
			
			String sql="SELECT * FROM estudiantes";
			
			List<Estudiante> listaEstudiante= new ArrayList<Estudiante>();
			
			try {			
				conn= ConexionSQL.conectar();
				stm=conn.createStatement();
				rs=stm.executeQuery(sql);
				while (rs.next()) {
					Estudiante c=new Estudiante();
					c.setId(rs.getInt(1));
					c.setNombre(rs.getString(2));
					c.setApellido(rs.getString(3));
					c.setModulo(rs.getString(4));
					listaEstudiante.add(c);
				}
				stm.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error: Clase ImplementarCRUD, método obtener");
				e.printStackTrace();
			}
			
			return listaEstudiante;
		}
	 
		public boolean update(Estudiante estudiante) {
			Connection conn;
			Statement stm;
			
			boolean update=false;
					
			String sql="UPDATE estudiantes SET nombre='"+estudiante.getNombre()+"', apellido='"+estudiante.getApellido()+"', modulo='"+estudiante.getModulo()+"'" +" WHERE id="+estudiante.getId();
			try {
				conn=ConexionSQL.conectar();
				stm=conn.createStatement();
				stm.execute(sql);
				update=true;
			} catch (SQLException e) {
				System.out.println("Error: Clase ImplementarCRUD, método actualizar");
				e.printStackTrace();
			}		
			return update;
		}
		
		public boolean insert(Estudiante estudiante) {
			Connection conn;
			Statement stm;
			
			boolean insert=false;
					
			String sql="INSERT INTO estudiantes VALUES (NULL,'"+"','"+estudiante.getNombre()+"','"+estudiante.getApellido()+"','"+estudiante.getModulo();
			try {
				conn=ConexionSQL.conectar();
				stm=conn.createStatement();
				stm.execute(sql);
				insert=true;
			} catch (SQLException e) {
				System.out.println("Error: Clase ImplementarCRUD, método actualizar");
				e.printStackTrace();
			}		
			return insert;
		}
	 
		public boolean delete(Estudiante estudiante) {
			Connection conn;
			Statement stm;
			
			boolean delete=false;
					
			String sql="DELETE FROM estudiantes WHERE id="+estudiante.getId();
			try {
				conn=ConexionSQL.conectar();
				stm=conn.createStatement();
				stm.execute(sql);
				delete=true;
			} catch (SQLException e) {
				System.out.println("Error: Clase ImplementarCRUD, método eliminar");
				e.printStackTrace();
			}		
			return delete;
	}	 
}
*/