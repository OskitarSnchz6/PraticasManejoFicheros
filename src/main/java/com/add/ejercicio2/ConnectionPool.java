package com.add.ejercicio2;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
    
    private final String URL="jdbc:h2:~";
    private final String USER="sa";
    private final String PSW=" ";
    
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource=null;	//Objeto tipo conexion pool
    
    private ConnectionPool(){
     
        basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PSW);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);			//Min conexiones inactivas
        basicDataSource.setMaxIdle(20);			//Max conexiones inactivas
        basicDataSource.setMaxTotal(50);		//Conexiones activas/inactivas permitidas
        basicDataSource.setMaxWaitMillis(-1);	//Tiempo de espera entre conexiones (-1 es que es infinito)
        
    }
    
    public static ConnectionPool getInstance() {
        if (dataSource == null) {
            dataSource = new ConnectionPool();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException{
      return this.basicDataSource.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }       
}


//El pool permite tener centralizado y controlado el manejo de las conexiones a la base de datos, 
//ya que el acceso a la misma no se hace desde el cliente, como en una aplicación en 2 capas, sino que en este tipo 
//de aplicación el acceso es realizado por el servidor de aplicaciones.


