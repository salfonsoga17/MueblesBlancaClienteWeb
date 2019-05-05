/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.PersonaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public interface PersonaDAO {
    
    public int insertar(PersonaVO personaNaturalVO)throws Exception;
    
    public int actualizar(PersonaVO personaNaturalVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<PersonaVO> listar() throws Exception; 
    
    public PersonaVO consultarPorId(long id) throws Exception;
    
}
