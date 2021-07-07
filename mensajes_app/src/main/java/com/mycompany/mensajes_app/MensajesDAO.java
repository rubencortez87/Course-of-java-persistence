/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author r.cortez
 */
public class MensajesDAO {

    private static boolean e;
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection())  {
            PreparedStatement  ps=null;
            try{
                String query="INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps =null;
        Resulset rs=null;
        
        
        try(Connection conexion = db_connect.get_connection())  {
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=(Resulset) ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getINT("id mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
            }catch(SQLException ex) {
            System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
           
            }
    }
    
    public static void borrarMensajeDB(int id_mensaje) throws SQLException{
        Conexion db_conexion = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            
            try {
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                        ps=conexion.prepareStatement(query);
                        ps.setInt(1, id_mensaje);
                        ps.executeUpdate();
                        System.out.println("el mensaje ha sido borrado");  
        }catch(SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo borrar el mensaje");
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_conexion = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            
            try {
               String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = 3;";
               ps=conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
               ps.executeUpdate();
               System.out.println("mensaje se actualizo correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
            
        }
    }

    private static class Resulset {

        public Resulset() {
        }

        private boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getINT(String id_mensaje) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getString(String mensaje) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class db_connect {

        private static Connection get_connection() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public db_connect() {
        }
    }
    
}