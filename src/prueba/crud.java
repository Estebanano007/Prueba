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
public class crud {
    
    public void insertarDato(int id, String user, String password)
   {
      String query="insert into usuario (userid, username, userpassword) Values (?,?,?)";
      try
      {
         Connection con=dbConnection.conectar();
         PreparedStatement ps=con.prepareStatement(query);
         ps.setInt(1,id);
         ps.setString(2,user);
         ps.setString(3,password);
         
         ps.executeUpdate();
           System.out.println("Insertado con exito");
         
      }
      catch(SQLException ex)
      {
           System.out.println("Error no se inserto el dato");
           ex.printStackTrace();
      }
   }
    
    public void leerDatos()
    {
        String query="select * from usuario";
        try
      {
          Connection con=dbConnection.conectar();
         PreparedStatement ps=con.prepareStatement(query);
         
         ResultSet rs=ps.executeQuery();
         
         while(rs.next ())
        {
         int id=rs.getInt("userid");
         String user=rs.getString("username");
         String password=rs.getString("userpassword");
            System.out.println("ID: "+id + "USER: "+user + "PASS:"+password);
        }  
      }
      catch(SQLException ex)
      {
           System.out.println("Error no se puede mostrar el dato");
           ex.printStackTrace();
      } 
    }
    
    public void actualizacionDato(int id, String user, String password)
{
      String query="update usuario set username=? ,userpassword=? where userid=?";
      try
      {
         Connection con=dbConnection.conectar();
         PreparedStatement ps=con.prepareStatement(query);
         ps.setInt(3,id);
         ps.setString(1,user);
         ps.setString(2,password);
         
         ps.executeUpdate();
           System.out.println("Actualizado con exito");
         
      }
      catch(SQLException ex)
      {
           System.out.println("Error al actualizar el dato");
           ex.printStackTrace();
      }
   }
    
   public void eliminarDato(int id)
{
      String query="delete from usuario where userid=?";
      try
      {
         Connection con=dbConnection.conectar();
         PreparedStatement ps=con.prepareStatement(query);
         ps.setInt(1,id);
         
         ps.executeUpdate();
           System.out.println("Eliminado con exito");
         
      }
      catch(SQLException ex)
      {
           System.out.println("Error al eliminar el dato");
           ex.printStackTrace();
      }
   }
}
