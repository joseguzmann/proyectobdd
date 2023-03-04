/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectobdd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jg175
 */
public class Proyectobdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ConexionOracle conexion = new ConexionOracle();
            Connection conn = conexion.connectOracle();
            String query = "SELECT * FROM TWEET_MASTER";
            PreparedStatement prstm = conn.prepareStatement(query);
            ResultSet rs = prstm.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Proyectobdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
