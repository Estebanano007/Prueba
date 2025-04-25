/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import java.sql.*;

/**
 *
 * @author niño
 */
public class dbConnection {
    static String url="jdbc:mysql://localhost:3306/prueba";
    static String user="root";
    static String pass="German90";
    
    public static Connection conectar ()
    {
    Connection con=null;
    try
    {
     con=DriverManager.getConnection(url,user,pass);
     System.out.println("Conexion realizada");
    } catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return con; 
    }
}