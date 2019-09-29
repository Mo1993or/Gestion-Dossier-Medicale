/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author serignemor
 */
public class  connexion {
private static Connection con;
static{
 try{
     try { 
         Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
     }
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionetsuivies", "root", ""); 
   
 
 }  catch (SQLException ex) {
      System.out.println("Error connexion"+ex);
    }}

    public static Connection getCon() {
        return con;
    }
   
}
