/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

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
        } finally {
            return resultado;
        }
    }

    public int actualizar(PersonaVO personaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = personaDAO.actualizar(personaVO);
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<PersonaVO> listar() throws Exception {

        ArrayList<PersonaVO> lista = new ArrayList<PersonaVO>();
        try {
            lista = personaDAO.listar();
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public PersonaVO consultarPorId(long idPersona) throws Exception {
        PersonaVO personaVO = new PersonaVO();
        try {
            personaVO = personaDAO.consultarPorId(idPersona);
        } catch (Exception e) {
            System.out.println("PesonaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return personaVO;
        }
    }
    
    public int eliminarPorId(long idPersonaNatural) throws Exception {
        int resultado = -1;
        try {
            resultado = personaDAO.eliminar(idPersonaNatural);
        } catch (Exception e) {
            System.out.println("PersonaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


