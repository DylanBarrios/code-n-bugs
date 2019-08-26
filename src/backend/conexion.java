package backend;

import java.sql.*;

public class conexion {
    
    public static Connection conectar(){
        Connection conecta = null;
        String usser = "root";
        String password = "061520";
        String ruta = "jdbc:mysql://localhost:3306/code";                       //datos para conectar con la base de datos llamada code
        
        try {
            conecta = DriverManager.getConnection(ruta,usser,password);         
            return conecta;                                                     //Retorna la conexion establecida para usar en todo lo de mas
                                                                                //del software
        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos"+e);
        }
        return null;
    }
}
