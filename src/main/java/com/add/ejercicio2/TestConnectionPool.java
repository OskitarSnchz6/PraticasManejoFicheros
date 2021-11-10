package com.add.ejercicio2;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author JorgeLPR
 */
public class TestConnectionPool {

    public static void main(String[] args) {
        
        try {
            Connection conn =  ConnectionPool.getInstance().getConnection();	//Conexion  
            if(conn!=null){
                System.out.println("Conectado");
                ConnectionPool.getInstance().closeConnection(conn);
            }else{
                System.out.println("No conectado");                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
}