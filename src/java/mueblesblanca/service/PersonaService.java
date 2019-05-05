/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import mueblesblanca.dao.PersonaDAO;
import mueblesblanca.dao.PersonaDAOMS;
import mueblesblanca.vo.PersonaVO;

/**
 *
 * @author Sergio AlfonsoG
 */
public class PersonaService {

    private static PersonaDAO personaDAO;

    public PersonaService() {
        personaDAO = new PersonaDAOMS();
    }

    public int insertar(PersonaVO personaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = personaDAO.insertar(personaVO);
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        }
        return resultado;

    }

    public int actualizar(PersonaVO personaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = personaDAO.actualizar(personaVO);
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        }
        return resultado;

    }

    public ArrayList<PersonaVO> listar() throws Exception {

        ArrayList<PersonaVO> lista = new ArrayList<PersonaVO>();
        try {
            lista = personaDAO.listar();
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        }
        return lista;

    }

    public PersonaVO consultarPorId(long idPersona) throws Exception {
        PersonaVO personaVO = new PersonaVO();
        try {
            personaVO = personaDAO.consultarPorId(idPersona);
        } catch (Exception e) {
            System.out.println("PesonaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        }
        return personaVO;

    }

    public int eliminarPorId(long idPersonaNatural) throws Exception {
        int resultado = -1;
        try {
            resultado = personaDAO.eliminar(idPersonaNatural);
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        }
        return resultado;

    }

    public PersonaVO consultByEmail(String email) throws Exception {
        PersonaVO user = new PersonaVO();
        try {
            user = personaDAO.findByEmail(email);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        }

        return user;

    }

    public PersonaVO authenticateUser(String email, String password) throws Exception {
        PersonaVO usuario = consultByEmail(email);
        if (usuario != null) {
            if (usuario.getPasswordPersona().equals(convertSHA256(password))) {
                return usuario;
            }
        }
        return null;

    }

    public String convertSHA256(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
