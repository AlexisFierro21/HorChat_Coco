/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_amigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class Connectar {
public Connection cone; 
    public Connectar() {

    }
    public Connection con_bd(){
                        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            cone =  DriverManager.getConnection("jdbc:mysql://localhost:3306/chatit", "root","");
        return cone;
                        }
        catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                        return null;
    }
    
    
}
