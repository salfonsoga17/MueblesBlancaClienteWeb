/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.DetalleOrdenDAO;
import mueblesblanca.dao.DetalleOrdenDAOMS;
import mueblesblanca.vo.DetalleOrdenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class DetalleOrdenService {

    private static DetalleOrdenDAO detalleOrdenDAO;

    public DetalleOrdenService() {
        detalleOrdenDAO = new DetalleOrdenDAOMS();
    }

    public int insertar(DetalleOrdenVO detalleOrdenVO) throws Exception {
        int resultado = -1;
        try {
            resultado = detalleOrdenDAO.insertar(detalleOrdenVO);
        } catch (Exception e) {
            System.out.println("DetalleOrdenService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(DetalleOrdenVO detalleOrdenVO) throws Exception {
        int resultado = -1;
        try {
            resultado = detalleOrdenDAO.actualizar(detalleOrdenVO);
        } catch (Exception e) {
            System.out.println("DetalleOrdenService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<DetalleOrdenVO> listar() throws Exception {

        ArrayList<DetalleOrdenVO> lista = new ArrayList<DetalleOrdenVO>();
        try {
            lista = detalleOrdenDAO.listar();
        } catch (Exception e) {
            System.out.println("DetalleOrdenService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public DetalleOrdenVO consultarPorId(long idDetalleOrden) throws Exception {
        DetalleOrdenVO detalleOrdenVO = new DetalleOrdenVO();
        try {
            detalleOrdenVO = detalleOrdenDAO.consultarPorId(idDetalleOrden);
        } catch (Exception e) {
            System.out.println("DetalleOrdenService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return detalleOrdenVO;
        }
    }
    
    public int eliminarPorId(long idDetalleOrdenNatural) throws Exception {
        int resultado = -1;
        try {
            resultado = detalleOrdenDAO.eliminar(idDetalleOrdenNatural);
        } catch (Exception e) {
            System.out.println("DetalleOrdenService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


