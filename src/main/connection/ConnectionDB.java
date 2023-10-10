package main.connection;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JESUS
 */
public class ConnectionDB {
    private Connection con = null;
    private String URL = "jdbc:mysql://localhost:3306/ciss_autolavado_db";
    
    public ConnectionDB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URL, "root", "");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexion!");
        }
    }
    
    
    public Connection getConnection() {
        return con;
    }
    
    
}
