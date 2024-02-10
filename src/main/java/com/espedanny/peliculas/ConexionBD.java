
package com.espedanny.peliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
   
    public static Connection getConnection(){
    
    Connection conexion = null;
    
    try{
    
        String urlbd = "jdbc:mysql://localhost:3306/peliculas";
        String usuariobd = "root";
        String passwordbd = "";
        
        conexion = DriverManager.getConnection(urlbd,usuariobd,passwordbd);
        System.out.println("Conectado a la base de datos con Exito!!");
    }catch(SQLException e){
        
        System.err.println(("Error al conectar con la base de datos!!")+ e.getMessage());
    }
    
    return conexion; 
    }
    
    
}
