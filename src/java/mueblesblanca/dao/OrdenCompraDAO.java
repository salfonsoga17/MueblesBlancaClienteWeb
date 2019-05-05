/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.OrdenCompraVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public interface OrdenCompraDAO {
    
    public int insertar(OrdenCompraVO ordenCompraVO)throws Exception;
    
    public int actualizar(OrdenCompraVO ordenCompraVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<OrdenCompraVO> listar() throws Exception; 
    
    public OrdenCompraVO consultarPorId(long id) throws Exception;
    
}
