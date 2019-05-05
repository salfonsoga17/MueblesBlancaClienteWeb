/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.DetalleOrdenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public interface DetalleOrdenDAO {
    
    public int insertar(DetalleOrdenVO detalleOrdenVO)throws Exception;
    
    public int actualizar(DetalleOrdenVO detalleOrdenVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<DetalleOrdenVO> listar() throws Exception; 
    
    public DetalleOrdenVO consultarPorId(long id) throws Exception;
    
}
