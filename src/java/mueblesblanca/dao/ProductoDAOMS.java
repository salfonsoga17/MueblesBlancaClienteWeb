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
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ProductoDAOMS extends ConexionSQL implements ProductoDAO {

    @Override
    public ArrayList<ProductoVO> listar() throws Exception {
        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdProducto, NombreProducto, DescripcionProducto, AltoProducto, AnchoProducto, ColorProducto, "
                            + "MaterialProducto, GarantiaMesesProducto, ValorUnitarioProducto, IdImagenProducto, IdModeloProducto, "
                            + "IdCategoriaProducto, FechaCreacionProducto, UsuarioCreacionProducto, FechaModificacionProducto, "
                            + "UsuarioModificacionProducto, EstadoProducto, im.CodigoImagen FROM Producto "
                            + " JOIN Imagen im ON Producto.IdProducto = im.IdProductoImagen "
                            + "WHERE EstadoProducto <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                productoVO = new ProductoVO();
                productoVO.setIdProducto(rs.getInt(t++));
                productoVO.setNombreProducto(rs.getString(t++));
                productoVO.setDescripcionProducto(rs.getString(t++));
                productoVO.setAltoProducto(rs.getString(t++));
                productoVO.setAnchoProducto(rs.getString(t++));
                productoVO.setColorProducto(rs.getString(t++));
                productoVO.setMaterialProducto(rs.getString(t++));
                productoVO.setGarantiaMesesProducto(rs.getInt(t++));
                productoVO.setValorUnitarioProducto(rs.getBigDecimal(t++));
                productoVO.getImagenProducto().setIdImagen(rs.getInt(t++));
                productoVO.getModeloProducto().setIdModelo(rs.getInt(t++));
                productoVO.getCategoriaProducto().setIdCategoria(rs.getInt(t++));               
                productoVO.setFechaCreacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioCreacionProducto(rs.getString(t++));
                productoVO.setFechaModificacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioModificacionProducto(rs.getString(t++));
                productoVO.setEstadoProducto(rs.getInt(t++));
                productoVO.getImagenProducto().setCodigoImagen(rs.getBytes(t++));
                
                lista.add(productoVO);
            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al consultar la tabla Producto. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ProductoVO consultarPorId(long idProducto) throws Exception {
        ProductoVO productoVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT IdProducto, NombreProducto, DescripcionProducto, AltoProducto, AnchoProducto, ColorProducto, "
                            + "MaterialProducto, GarantiaMesesProducto, ValorUnitarioProducto, IdImagenProducto, IdModeloProducto, "
                            + "IdCategoriaProducto, FechaCreacionProducto, UsuarioCreacionProducto, FechaModificacionProducto, "
                            + "UsuarioModificacionProducto, EstadoProducto, im.CodigoImagen FROM Producto "
                            + " JOIN Imagen im ON Producto.IdProducto = im.IdProductoImagen "
                            + "WHERE IdProducto = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                productoVO = new ProductoVO();
                productoVO.setIdProducto(rs.getInt(t++));
                productoVO.setNombreProducto(rs.getString(t++));
                productoVO.setDescripcionProducto(rs.getString(t++));
                productoVO.setAltoProducto(rs.getString(t++));
                productoVO.setAnchoProducto(rs.getString(t++));
                productoVO.setColorProducto(rs.getString(t++));
                productoVO.setMaterialProducto(rs.getString(t++));
                productoVO.setGarantiaMesesProducto(rs.getInt(t++));
                productoVO.setValorUnitarioProducto(rs.getBigDecimal(t++));
                productoVO.getImagenProducto().setIdImagen(rs.getInt(t++));
                productoVO.getModeloProducto().setIdModelo(rs.getInt(t++));
                productoVO.getCategoriaProducto().setIdCategoria(rs.getInt(t++));               
                productoVO.setFechaCreacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioCreacionProducto(rs.getString(t++));
                productoVO.setFechaModificacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioModificacionProducto(rs.getString(t++));
                productoVO.setEstadoProducto(rs.getInt(t++));
                productoVO.getImagenProducto().setCodigoImagen(rs.getBytes(t++));
                
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return productoVO;
    }
    
    @Override
    public ArrayList<ProductoVO> listarPorCategoria(long idCategoria) throws Exception {
        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdProducto, NombreProducto, DescripcionProducto, AltoProducto, AnchoProducto, ColorProducto, "
                            + "MaterialProducto, GarantiaMesesProducto, ValorUnitarioProducto, IdImagenProducto, IdModeloProducto, "
                            + "IdCategoriaProducto, FechaCreacionProducto, UsuarioCreacionProducto, FechaModificacionProducto, "
                            + "UsuarioModificacionProducto, EstadoProducto, im.CodigoImagen FROM Producto "
                            + " JOIN Imagen im ON Producto.IdProducto = im.IdProductoImagen "
                            + "WHERE IdCategoriaProducto = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idCategoria);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                productoVO = new ProductoVO();
                productoVO.setIdProducto(rs.getInt(t++));
                productoVO.setNombreProducto(rs.getString(t++));
                productoVO.setDescripcionProducto(rs.getString(t++));
                productoVO.setAltoProducto(rs.getString(t++));
                productoVO.setAnchoProducto(rs.getString(t++));
                productoVO.setColorProducto(rs.getString(t++));
                productoVO.setMaterialProducto(rs.getString(t++));
                productoVO.setGarantiaMesesProducto(rs.getInt(t++));
                productoVO.setValorUnitarioProducto(rs.getBigDecimal(t++));
                productoVO.getImagenProducto().setIdImagen(rs.getInt(t++));
                productoVO.getModeloProducto().setIdModelo(rs.getInt(t++));
                productoVO.getCategoriaProducto().setIdCategoria(rs.getInt(t++));               
                productoVO.setFechaCreacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioCreacionProducto(rs.getString(t++));
                productoVO.setFechaModificacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioModificacionProducto(rs.getString(t++));
                productoVO.setEstadoProducto(rs.getInt(t++));
                productoVO.getImagenProducto().setCodigoImagen(rs.getBytes(t++));
                
                lista.add(productoVO);
            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al consultar la tabla Producto por categoria. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }
}
