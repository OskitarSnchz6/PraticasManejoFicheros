package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaDAOImpl implements pruebaDAO{

    private void registrarDriver() {
        try {
            Class.forName(ConexionSQL.driverClassName).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: fallo al cargar el Driver de la BBDD");
            e.printStackTrace();
        }
    }
    
   public void insert(Estudiante estudiante){
        
        Connection conn = null;
        try {
        	registrarDriver();
            // abrir la conexion 
            conn = DriverManager.getConnection(ConexionSQL.connectionUrl, ConexionSQL.user, ConexionSQL.pwd);
            // generar la query
            String query = "INSERT INTO estudiantes values(?, ?, ?, ?)";
            // preparar el statement, introduciendo los datos
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // enviar el commando insert
                        stmt.setInt(1, estudiante.getId());
                        stmt.setString(2, estudiante.getNombre());
                        stmt.setString(3, estudiante.getApellido());
                        stmt.setString(4, estudiante.getModulo());
                        // ejecutar la sentencia
                        stmt.executeUpdate();
            }
        } catch (SQLException e) {
            // si algo sale mal lanzar la excepción
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    // cerrar conexión
                    conn.close();
                } catch (SQLException e) {
                    // si algo falla al cerrar la conexión enviar salida
                    e.getMessage();
                }
            }
        }
    }
    
    @Override
    public void update(Estudiante estudiante){
        
        Connection conn = null;
        try {
        	registrarDriver();
            // abrir la conexion 
            conn = DriverManager.getConnection(ConexionSQL.connectionUrl, ConexionSQL.user, ConexionSQL.pwd);
            // generar la query
            String query = "UPDATE estudiantes set id = ?, set name = ?, set phone = ?,"
                    + " set country = ?, set years = ? where ID = ?";
            // preparar el statement, introduciendo los datos
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // enviar el commando insert
                        stmt.setInt(1, estudiante.getId());
                        stmt.setString(2, estudiante.getNombre());
                        stmt.setString(3, estudiante.getApellido());
                        stmt.setString(4, estudiante.getModulo());
                        // ejecutar la sentencia
                        stmt.executeUpdate();
            }
        } catch (SQLException e) {
            // si algo sale mal lanzar la excepción
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    // cerrar conexión
                    conn.close();
                } catch (SQLException e) {
                    // si algo falla al cerrar la conexión enviar salida
                    e.getMessage();
                }
            }
        }
    }
    
    @Override
    public void delete(Integer id){
        
        Connection conn = null;
        try {
            registrarDriver();
            // abrir la conexion 
            conn = DriverManager.getConnection(ConexionSQL.connectionUrl, ConexionSQL.user, ConexionSQL.pwd);
            // generar la query
            String query = "delete from estudiantes where ID = ?";
            // preparar el Statement
            PreparedStatement stmt = conn.prepareStatement(query);
           // Insertar el valor 
            stmt.setInt(1, id);
            // ejecutar
            int i = stmt.executeUpdate();
            if (i > 0){
                System.out.println("Datos borrados correctamente");
            }else{
                // lanzar excepción
                throw new SQLException("Error");
            }
        }catch(SQLException e){
            System.out.println("Error de base de datos");
        }
        
    }
    
    @Override
    public Estudiante select(Integer id){
        
        Connection conn = null;
        Estudiante estudiante = null;

        try {
            registrarDriver();
            // abrir la conexion
            conn = DriverManager.getConnection(ConexionSQL.connectionUrl, ConexionSQL.user, ConexionSQL.pwd);
            // consulta select (selecciona el producto con ID especificado)
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from estudiantes where ID = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, id);
                // ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Prueba
                        estudiante = new Estudiante(
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("modulo"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return estudiante;
    }
    
}