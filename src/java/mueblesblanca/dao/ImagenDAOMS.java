/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.vo.ImagenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ImagenDAOMS extends ConexionSQL implements ImagenDAO {

    @Override
    public ImagenVO consultarPorId(long idImagen) throws Exception {
        ImagenVO imagenVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT IdImagen, IdProductoImagen, TituloImagen, CodigoImagen, "
                            + "FechaCreacionImagen, UsuarioCreacionImagen, FechaModificacionImagen, "
                            + "UsuarioModificacionImagen, EstadoImagen "
                            + "FROM Imagen WHERE IdImagen = ?  ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idImagen);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                imagenVO = new ImagenVO();
                imagenVO.setIdImagen(rs.getInt(t++));
                imagenVO.getIdProductoImagen().setIdProducto(rs.getInt(t++));
                imagenVO.setTituloImagen(rs.getString(t++));
                imagenVO.setCodigoImagen(rs.getBytes(t++));
                imagenVO.setFechaCreacionImagen(rs.getTimestamp(t++));
                imagenVO.setUsuarioCreaciónImagen(rs.getString(t++));
                imagenVO.setFechaModificaciónImagen(rs.getTimestamp(t++));
                imagenVO.setUsuarioModificaciónImagen(rs.getString(t++));
                
            }

        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return imagenVO;
    }

}
