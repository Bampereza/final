/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author brand
 */
public class UserArray {
    private DatabaseConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public UserArray(){
        this.connectDB=new DatabaseConnection();
    }
    
    public void openConnection(){
        connectDB= new DatabaseConnection();
        connection=connectDB.connection();
    }
    
    public String validarUsuario(String user, String pass){
        String sql = "SELECT * FROM usuario WHERE usuario = '" + user + "' AND contrasenia = '"+pass+"'";
        try{
            this.connection = this.connectDB.connection();
            this.statement = connection.prepareStatement(sql);
            this.resultSet=this.statement.executeQuery();
            if(resultSet != null){
                 String userFound="";
                while (resultSet.next()){
                    userFound= resultSet.getString("usuario");
                }
                return userFound;
            }
            return "Usuario no encontrado";
        }
        catch(SQLException e){
           return e.getMessage();
        }
    }
        public String registerUser(User user){  
     
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.usuario(usuario, contrasenia) ";
             sql += " VALUES( ?, ?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            
            int result = statement.executeUpdate(); 
            
                if(result > 0){
                    return String.valueOf(result);
                }else{
                    return String.valueOf(result);
                }
        }catch(SQLException e){
            return e.getMessage();
        }    
    }
}
