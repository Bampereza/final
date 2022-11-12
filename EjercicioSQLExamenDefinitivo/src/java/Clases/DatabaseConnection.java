/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author brand
 */
public class DatabaseConnection {
           private final String url="jdbc:mysql://localhost:3306/transportes_ultrarrapidos_sa";//url de MySQL
    private final String user="root";// user de mysql local
    private final String key="root"; 
    private Connection connection=null;  
    
    public Connection connection(){   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url, user,key);
        }  catch (SQLException | ClassNotFoundException ex) {
        }         
        return connection;        
    }
}
