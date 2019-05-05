/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.OrdenCompraDAO;
import mueblesblanca.dao.OrdenCompraDAOMS;
import mueblesblanca.vo.OrdenCompraVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class OrdenCompraService {

    private static OrdenCompraDAO ordenCompraDAO;

    public OrdenCompraService() {
        ordenCompraDAO = new OrdenCompraDAOMS();
    }

    public int insertar(OrdenCompraVO ordenCompraVO) throws Exception {
        int resultado = -1;
        try {
            resultado = ordenCompraDAO.insertar(ordenCompraVO);
        } catch (Exception e) {
            System.out.println("OrdenCompraService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(OrdenCompraVO ordenCompraVO) throws Exception {
        int resultado = -1;
        try {
            resultado = ordenCompraDAO.actualizar(ordenCompraVO);
        } catch (Exception e) {
            System.out.println("OrdenCompraService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<OrdenCompraVO> listar() throws Exception {

        ArrayList<OrdenCompraVO> lista = new ArrayList<OrdenCompraVO>();
        try {
            lista = ordenCompraDAO.listar();
        } catch (Exception e) {
            System.out.println("OrdenCompraService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public OrdenCompraVO consultarPorId(long idOrdenCompra) throws Exception {
        OrdenCompraVO ordenCompraVO = new OrdenCompraVO();
        try {
            ordenCompraVO = ordenCompraDAO.consultarPorId(idOrdenCompra);
        } catch (Exception e) {
            System.out.println("OrdenCompraService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return ordenCompraVO;
        }
    }
    
    public int eliminarPorId(long idOrdenCompraNatural) throws Exception {
        int resultado = -1;
        try {
            resultado = ordenCompraDAO.eliminar(idOrdenCompraNatural);
        } catch (Exception e) {
            System.out.println("OrdenCompraService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


