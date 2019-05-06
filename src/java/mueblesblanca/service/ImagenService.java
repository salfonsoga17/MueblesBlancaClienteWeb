/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ImagenDAO;
import mueblesblanca.dao.ImagenDAOMS;
import mueblesblanca.vo.ImagenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ImagenService {

    private static ImagenDAO imagenDAO;

    public ImagenService() {
        imagenDAO = new ImagenDAOMS();
    }

    public ImagenVO consultarPorId(long idImagen) throws Exception {
        ImagenVO imagenVO = new ImagenVO();
        try {
            imagenVO = imagenDAO.consultarPorId(idImagen);
        } catch (Exception e) {
            System.out.println("ImagenService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return imagenVO;
        }
    }

}


