/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public interface CategoriaDAO {
    
    public ArrayList<CategoriaVO> listar() throws Exception; 
    
    public CategoriaVO consultarPorId(long id) throws Exception;
    
}
