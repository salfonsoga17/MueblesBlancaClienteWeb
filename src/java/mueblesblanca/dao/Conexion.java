/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mueblesblanca.dao;
import java.sql.Connection;
/**
 *
 * @author Sergio AlfonsoG
 */
public abstract class Conexion {
    public Connection conection;
    String usuario;
    String password;
    public abstract void Conectar() throws Exception;
    public abstract void Desconectar() throws Exception;
}
