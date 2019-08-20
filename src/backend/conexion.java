/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;

/**
 *
 * @author dylan
 */
public class conexion {
    
    public static Connection conectar(){
        Connection conecta = null;
        String usser = "root";
        String password = "061520";
        String ruta = "jdbc:mysql://localhost:3306/code";
        
        try {
            conecta = DriverManager.getConnection(ruta,usser,password);
            return conecta;
            
        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos"+e);
        }
        return null;
    }
}
