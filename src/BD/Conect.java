/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author neyra
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conect {
     //Atributos
    public static String Usuario="cnc72982_cneyra";
    public static String Clave="Asternax12543!";
    public static String Url="jdbc:mysql://ncconsulting.cl:3306/cnc72982_relojcontrol";
    public static String Clase="com.mysql.jdbc.Driver";
    public static Connection Conn;
    
    //Método Conexión
    public static Connection Conecta_BD(){
        try {
            Class.forName(Clase);
            Conn=DriverManager.getConnection(Url, Usuario, Clave);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Conn=null;
        }    
        return Conn;
    }
}
