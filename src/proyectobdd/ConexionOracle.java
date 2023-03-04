/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jg175
 */
public class ConexionOracle {
    private static final String USER = "master";
    private static final String PASSWORD = "master";

    public Connection connectOracle() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@26.222.46.190:1521:database", USER, PASSWORD);
            System.out.println("Conexion exitosa");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Conexion fallida");
        }
        return null;
    }



    
    public void executeCommit() {
        try {
            Connection conn = connectOracle();
            PreparedStatement ps = conn.prepareStatement("COMMIT");
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Cambios confirmados", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
