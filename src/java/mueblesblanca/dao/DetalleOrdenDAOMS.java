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
import mueblesblanca.vo.DetalleOrdenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class DetalleOrdenDAOMS extends ConexionSQL implements DetalleOrdenDAO {

    @Override
    public int insertar(DetalleOrdenVO detalleOrdenVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta = "INSERT INTO DetalleOrden (IdOrdenCompraDetalleOrden, IdProductoDetalleOrden, "
                            + "CantidadDetalleOrden, Subtotal) "
                            + "VALUES(?, ?, ?, ?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, detalleOrdenVO.getIdOrdenCompraDetalleCompra().getIdOrdenCompra());
            pstm.setInt(2, detalleOrdenVO.getIdProductoDetalleOrden().getIdProducto());
            pstm.setInt(3, detalleOrdenVO.getCantidadDetalleOrden());
            pstm.setBigDecimal(3, detalleOrdenVO.getSubtotalDetalleOrden());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" DetalleOrdenDAOMS: Se presento un error al insertar un Detalle de Orden."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(DetalleOrdenVO detalleOrdenVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta
                    = "	UPDATE DetalleOrden SET "
                    + "	IdOrdenCompraDetalleOrden = ?, "
                    + " IdProductoDetalleOrden = ?, "
                    + "	CantidadDetalleOrden = ?, "
                    + "	Subtotal = ?, "
                    + "	WHERE IdDetalleOrden = ? ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, detalleOrdenVO.getIdOrdenCompraDetalleCompra().getIdOrdenCompra());
            pstm.setInt(2, detalleOrdenVO.getIdProductoDetalleOrden().getIdProducto());
            pstm.setInt(3, detalleOrdenVO.getCantidadDetalleOrden());
            pstm.setBigDecimal(4, detalleOrdenVO.getSubtotalDetalleOrden());
            
            pstm.setInt(5, detalleOrdenVO.getIdDetalleOrden());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleOrdenDAOMS: Se presento un error al insertar un Detalle de Compra."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idDetalleOrden) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FROM DetalleOrden WHERE IdDetalleOrden = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idDetalleOrden);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("DetalleOrdenDAOMS: Se presento un error al eliminar un Detalle de Compra."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;

    }

    @Override
    public ArrayList<DetalleOrdenVO> listar() throws Exception {
        ArrayList<DetalleOrdenVO> lista = new ArrayList<DetalleOrdenVO>();
        DetalleOrdenVO detalleOrdenVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdDetalleOrden, IdOrdenCompraDetalleOrden, IdProductoDetalleOrden, "
                            + "CantidadDetalleOrden, Subtotal"
                            + "FROM DetalleOrden ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                detalleOrdenVO = new DetalleOrdenVO();
                detalleOrdenVO.setIdDetalleOrden(rs.getInt(t++));
                detalleOrdenVO.getIdOrdenCompraDetalleCompra().setIdOrdenCompra(rs.getInt(t++));
                detalleOrdenVO.getIdProductoDetalleOrden().setIdProducto(rs.getInt(t++));
                detalleOrdenVO.setCantidadDetalleOrden(rs.getInt(t++));
                detalleOrdenVO.setSubtotalDetalleOrden(rs.getBigDecimal(t++));

                lista.add(detalleOrdenVO);
            }
        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS: Se presento un error al consultar la tabla OrdenCompra. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public DetalleOrdenVO consultarPorId(long idOrdenCompra) throws Exception {
        DetalleOrdenVO detalleOrdenVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT IdDetalleOrden, IdOrdenCompraDetalleOrden, IdProductoDetalleOrden, "
                            + "CantidadDetalleOrden, Subtotal"
                            + "FROM DetalleOrden WHERE IdDetalleOrden = ?  ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idOrdenCompra);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                detalleOrdenVO = new DetalleOrdenVO();
                detalleOrdenVO.setIdDetalleOrden(rs.getInt(t++));
                detalleOrdenVO.getIdOrdenCompraDetalleCompra().setIdOrdenCompra(rs.getInt(t++));
                detalleOrdenVO.getIdProductoDetalleOrden().setIdProducto(rs.getInt(t++));
                detalleOrdenVO.setCantidadDetalleOrden(rs.getInt(t++));
                detalleOrdenVO.setSubtotalDetalleOrden(rs.getBigDecimal(t++));
            }

        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return detalleOrdenVO;
    }

}
