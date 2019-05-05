/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ConexionSQL extends Conexion {    
    //Metodo de conexión a la Bd
    @Override
    public void Conectar() throws Exception{
        try {
            //Drive de conexión
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Colocamos el servidor sql, nombre de nuestra base de datos, usuario y password
            //String conectionURL = "jdbc:sqlserver://SERGIO:1433;databasename=Bd_MueblesBlanca";
            //this.usuario = "root"; this.password = "";
            String conectionURL = "jdbc:sqlserver://DESKTOP-VQ758EM:1433;databasename=Bd_MueblesBlanca";
            //String conectionURL = "jdbc:sqlserver://172.16.1.64:1433;databasename=Bd_MueblesBlanca";
            this.usuario = "blanca"; this.password = "123456";
            
            this.conection = DriverManager.getConnection(conectionURL,usuario,password);       
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("ConexionSQL - ERROR: "+ e.getMessage());
            throw e;
        }
    }   
    
    //Metodo de desconexión de la Bd
    @Override
    public void Desconectar() throws Exception {
        try{
            if(this.conection != null && !this.conection.isClosed()){
                this.conection.close();
            }  
        }catch(SQLException e){
            System.out.println("ConexionSQL - ERROR : "+ e.getMessage());
            throw e;
        }
    }
    
    
}
