/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author r.cortez
 */
public class Conexion {
    
    public Connection get_connection() {
        Connection conection = null;
        try{
     conection = DriverManager.getConnection("jdbc:mysql://localhost8080:3306/mensajes_app", "root","");
            
              }catch(SQLException e) {
            System.out.println(e);
            
            
        }
                    return  conection;
        
    }
}

