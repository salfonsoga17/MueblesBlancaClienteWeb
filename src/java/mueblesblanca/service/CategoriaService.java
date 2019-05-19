/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.CategoriaDAO;
import mueblesblanca.dao.CategoriaDAOMS;
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class CategoriaService {

    private static CategoriaDAO categoriaDAO;

    public CategoriaService() {
        categoriaDAO = new CategoriaDAOMS();
    }
    
    public ArrayList<CategoriaVO> listar() throws Exception {

        ArrayList<CategoriaVO> lista = new ArrayList<CategoriaVO>();
        try {
            lista = categoriaDAO.listar();
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public CategoriaVO consultarPorId(long idDetalleOrden) throws Exception {
        CategoriaVO categoriaVO = new CategoriaVO();
        try {
            categoriaVO = categoriaDAO.consultarPorId(idDetalleOrden);
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return categoriaVO;
        }
    }

}
