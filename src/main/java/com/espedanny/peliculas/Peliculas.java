
package com.espedanny.peliculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Peliculas {

    public Peliculas(String titulo, String director, String descripcion, int duracion, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.genero = genero;
    }
   
    public Peliculas(){
    
    }
                  
    String titulo;
    String director;
    String descripcion;
    int duracion;
    String genero; 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void GuardarPeliculas(){
        Connection conexionBD = ConexionBD.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "INSERT INTO camisas (Titulo, Director, Descripcion,Duracion,Genero) VALUES (?,?,?,?,?)";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexionBD.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getTitulo());
            parametro.setString(2, this.getDirector());
            parametro.setString(3, this.getDescripcion());
            parametro.setInt(4, this.getDuracion());
            parametro.setString(5,this.getGenero());

            //Ejecutar la sentecia SQL
            parametro.execute();
            conexionBD.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void ModificarPeliculas() { 
        Connection conexionBD = ConexionBD.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "UPDATE peliculas SET Titulo=?, Director=?,Descripcion=?,Duracion=?,Genero=? WHERE 1";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexionBD.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getTitulo());
            parametro.setString(2, this.getDirector());
            parametro.setString(3, this.getDescripcion());
            parametro.setInt(4, this.getDuracion());
            parametro.setString(5,this.getGenero());


            //Ejecutar la sentecia SQL
            parametro.execute();
            conexionBD.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
     public ArrayList<Peliculas> ObtenerPeliculas(){
        Connection conexionBD = ConexionBD.getConnection();
        ResultSet rsPeliculas;
        
        var Peliculas = new ArrayList<Peliculas>();
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "SELECT * FROM peliculas ";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexionBD.prepareStatement(sentenciaSql);
            
            //Ejecutar la sentecia SQL
             rsPeliculas=parametro.executeQuery();           
            
            while(rsPeliculas.next()){              
                    Peliculas.add(new Peliculas(rsPeliculas.getString("Titulo"),rsPeliculas.getString("Director"),rsPeliculas.getString("Descripcion"),rsPeliculas.getInt("Duracion"),rsPeliculas.getString("Genero")));

            }
            
            conexionBD.close();
            return Peliculas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
    public void EliminarPeliculas(){
        Connection conexionBD = ConexionBD.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "DELETE FROM peliculas WHERE 0";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexionBD.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getTitulo());

            //Ejecutar la sentecia SQL
            parametro.execute();
            conexionBD.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
