/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.vo.PersonaVO;
import mueblesblanca.vo.RolVO;
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class PersonaDAOMS extends ConexionSQL implements PersonaDAO {

    @Override
    public int insertar(PersonaVO personaNaturalVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Persona (NumeroIdentificacionPersona, IdTipoDocumentoPersona, PrimerNombrePersona, "
                            + "SegundoNombrePersona, PrimerApellidoPersona, SegundoApellidoPersona, EmailPersona, CelularPersona, "
                            + "DireccionPersona, IdRolPersona, PasswordPersona, FechaCreacionPersona) "
                            + " VALUES(?,?,?,?,?,?,?,?,?,?,?,GETDATE()) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, personaNaturalVO.getNumeroIdentificacionPersona());
            pstm.setLong(2, personaNaturalVO.getIdTipoDocumentoPersona().getIdTipoDocumento());
            pstm.setString(3, personaNaturalVO.getPrimerNombrePersona());
            pstm.setString(4, personaNaturalVO.getSegundoNombrePersona());
            pstm.setString(5, personaNaturalVO.getPrimerApellidoPersona());  
            pstm.setString(6, personaNaturalVO.getSegundoApellidoPersona());  
            pstm.setString(7, personaNaturalVO.getEmailPersona());  
            pstm.setLong(8, personaNaturalVO.getCelularPersonaNatural());  
            pstm.setString(9, personaNaturalVO.getDireccionPersona());  
            pstm.setInt(10, personaNaturalVO.getIdRolPersona().getIdRol());   
            pstm.setString(11, personaNaturalVO.getPasswordPersona());                 

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al insertar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(PersonaVO personaNaturalVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Persona SET "
                            + " NumeroIdentificacionPersona = ?, "
                            + " IdTipoDocumentoPersona = ?, "
                            + " PrimerNombrePersona = ?, "
                            + " SegundoNombrePersona = ?, "
                            + " PrimerApellidoPersona = ?, "
                            + " SegundoApellidoPersona = ?, "
                            + " EmailPersona = ?, "
                            + " CelularPersona = ?, "
                            + " DireccionPersona = ?, "
                            + " IdRolPersona = ?, "
                            + " PasswordPersona = ?, "
                            + " FechaModificacionPersona = GETDATE() "
                            + " WHERE Id_PersonaNatural = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, personaNaturalVO.getNumeroIdentificacionPersona());
            pstm.setLong(2, personaNaturalVO.getIdTipoDocumentoPersona().getIdTipoDocumento());
            pstm.setString(3, personaNaturalVO.getPrimerNombrePersona());
            pstm.setString(4, personaNaturalVO.getSegundoNombrePersona());
            pstm.setString(5, personaNaturalVO.getPrimerApellidoPersona());  
            pstm.setString(6, personaNaturalVO.getSegundoApellidoPersona());  
            pstm.setString(7, personaNaturalVO.getEmailPersona());  
            pstm.setLong(8, personaNaturalVO.getCelularPersonaNatural());  
            pstm.setString(9, personaNaturalVO.getDireccionPersona());  
            pstm.setInt(10, personaNaturalVO.getIdRolPersona().getIdRol());   
            pstm.setString(11, personaNaturalVO.getPasswordPersona()); 
            
            pstm.setInt(14, personaNaturalVO.getIdPersona());  
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al actualizar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idPersona) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FROM Persona WHERE IdPersona = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idPersona);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al eliminar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<PersonaVO> listar() throws Exception {
        ArrayList<PersonaVO> lista = new ArrayList<PersonaVO>();
        PersonaVO personaNaturalVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdPersona, NumeroIdentificacionPersona, IdTipoDocumentoPersona, PrimerNombrePersona, "
                            + "SegundoNombrePersona, PrimerApellidoPersona, SegundoApellidoPersona, EmailPersona, CelularPersona, "
                            + "DireccionPersona, IdRolPersona, PasswordPersona, FechaCreacionPersona, FechaModificacionPersona"
                            + " FROM Persona";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                personaNaturalVO = new PersonaVO();
                personaNaturalVO.setIdPersona(rs.getInt(t++));
                personaNaturalVO.setNumeroIdentificacionPersona(rs.getLong(t++));
                personaNaturalVO.getIdTipoDocumentoPersona().setIdTipoDocumento(t++);
                personaNaturalVO.setPrimerNombrePersona(rs.getString(t++));
                personaNaturalVO.setSegundoNombrePersona(rs.getString(t++));
                personaNaturalVO.setPrimerApellidoPersona(rs.getString(t++));
                personaNaturalVO.setSegundoApellidoPersona(rs.getString(t++));
                personaNaturalVO.setEmailPersona(rs.getString(t++));
                personaNaturalVO.setCelularPersonaNatural(rs.getLong(t++));
                personaNaturalVO.setDireccionPersona(rs.getString(t++));
                personaNaturalVO.getIdRolPersona().setIdRol(t++);
                personaNaturalVO.setPasswordPersona(rs.getString(t++));
                personaNaturalVO.setFechaCreacionPersona(rs.getTimestamp(t++));
                personaNaturalVO.setFechaModificacionPersona(rs.getTimestamp(t++));

                lista.add(personaNaturalVO);
            }
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al consultar la tabla PersonaNatural. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public PersonaVO consultarPorId(long idPersona) throws Exception {
        PersonaVO personaNaturalVO = null;
        try {
            this.Conectar();         

            String consulta = "SELECT  pn.IdPersona, pn.NumeroIdentificacionPersona, pn.IdTipoDocumentoPersona, pn.PrimerNombrePersona, \n" +
"                            pn.SegundoNombrePersona, pn.PrimerApellidoPersona, pn.SegundoApellidoPersona, pn.EmailPersona, \n" +
"                            pn.CelularPersona, pn.DireccionPersona, pn.IdRolPersona, pn.PasswordPersona, \n" +
"                            pn.FechaCreacionPersona, pn.FechaModificacionPersona,\n" +
"                            td.DescripcionTipoDocumento as tipo_documento, r.EstadoRol as rol \n" +
"                             FROM Persona pn \n" +
"                            JOIN TipoDocumento td ON td.IdTipoDocumento = pn.IdTipoDocumentoPersona \n" +
"                             JOIN Rol r ON r.IdRol = pn.IdRolPersona \n" +
"                            WHERE IdPersona = ?";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idPersona);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                personaNaturalVO = new PersonaVO();
                personaNaturalVO.setIdPersona(rs.getInt(t++));
                personaNaturalVO.setNumeroIdentificacionPersona(rs.getLong(t++));
                personaNaturalVO.setTipoDocumentoPersona(new TipoDocumentoVO());
                personaNaturalVO.getTipoDocumentoPersona().setIdTipoDocumento(rs.getInt(t++));
                personaNaturalVO.setPrimerNombrePersona(rs.getString(t++));
                personaNaturalVO.setSegundoNombrePersona(rs.getString(t++));
                personaNaturalVO.setPrimerApellidoPersona(rs.getString(t++));
                personaNaturalVO.setSegundoApellidoPersona(rs.getString(t++));
                personaNaturalVO.setEmailPersona(rs.getString(t++));
                personaNaturalVO.setCelularPersonaNatural(rs.getLong(t++));
                personaNaturalVO.setDireccionPersona(rs.getString(t++));
                personaNaturalVO.setRolPersona(new RolVO());
                personaNaturalVO.getRolPersona().setIdRol(rs.getInt(t++));
                personaNaturalVO.setPasswordPersona(rs.getString(t++));
                personaNaturalVO.setFechaCreacionPersona(rs.getTimestamp(t++));
                personaNaturalVO.setFechaModificacionPersona(rs.getTimestamp(t++));
            }

        } catch (Exception e) {
            System.out.println("PersonaNaturalDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return personaNaturalVO;
    }
    public PersonaVO findByEmail(String email) throws Exception {
        PersonaVO user = null;
        try {
            this.Conectar();
            String query = "SELECT [IdPersona] FROM [dbo].[Persona] WHERE [EmailPersona] = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(query);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                user = consultarPorId(rs.getLong("IdPersona"));
            }
        } catch (Exception e) {
            System.out.println(" PersonaDao: Se presento un error al insertar un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return user;
    }
    
}
