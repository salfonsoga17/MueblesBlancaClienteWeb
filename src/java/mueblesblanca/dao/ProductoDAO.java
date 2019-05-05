/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public interface ProductoDAO {

    public ArrayList<ProductoVO> listar() throws Exception;

    public ProductoVO consultarPorId(long id) throws Exception;
}
