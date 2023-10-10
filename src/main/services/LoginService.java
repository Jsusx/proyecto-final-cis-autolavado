/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import main.connection.ConnectionDB;
import main.models.Empleado;



/**
 *
 * @author JESUS
 */
public class LoginService {
    public Empleado IniciarSesion(String usuario, String contrasena) {
        
        Empleado empleado = null;
        
        try {
            ConnectionDB conn = new ConnectionDB();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM empleado WHERE email = ? AND password = ?");
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                empleado = new Empleado();
                empleado.setId(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setEmail(rs.getString("email"));
                empleado.setTipoEmpleado(rs.getString("tipo_empleado"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setPassword(rs.getString("password"));
            }
            
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
        
        return empleado;
    }
}
