/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.vo.OrdenCompraVO;

/**
 *
 * @author Sergio AlfonsoG
 */
public class OrdenCompraDAOMS extends ConexionSQL implements OrdenCompraDAO {

    @Override
    public int insertar(OrdenCompraVO ordenCompraVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta = "INSERT INTO OrdenCompra (IdPersonaOrdenCompra, FechaCompraOrdenCompra, "
                    + "FechaPagoOrdenCompra, TotalOrdenCompra) "
                    + "VALUES(?, GETDATE(), ?, ?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, ordenCompraVO.getPersonaOrdenCompra().getIdPersona());
            pstm.setTimestamp(2, ordenCompraVO.getFechaPagoOrdenCompra());
            pstm.setBigDecimal(3, ordenCompraVO.getTotalOrdenCompra());

            resultado = pstm.executeUpdate();
            // esto se hace para recuperar el id de la orden
            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                resultado = generatedKeys.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println(" OrdenCompraDAOMS: Se presento un error al insertar una Orden de Compra."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(OrdenCompraVO ordenCompraVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta
                    = "	UPDATE OrdenCompra SET "
                    + "	IdPersonaOrdenCompra = ?, "
                    + " FechaCompraOrdenCompra = GETDATE(), "
                    + "	FechaPagoOrdenCompra = ?, "
                    + "	TotalOrdenCompra = ?, "
                    + "	WHERE IdOrdenCompra = ? ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, ordenCompraVO.getPersonaOrdenCompra().getIdPersona());
            pstm.setTimestamp(2, ordenCompraVO.getFechaPagoOrdenCompra());
            pstm.setBigDecimal(3, ordenCompraVO.getTotalOrdenCompra());

            pstm.setInt(4, ordenCompraVO.getIdOrdenCompra());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS: Se presento un error al insertar una Orden de Compra."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idOrdenCompra) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FROM OrdenCompra WHERE IdOrdenCompra = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idOrdenCompra);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS: Se presento un error al eliminar una Orden de Compra."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;

    }

    @Override
    public ArrayList<OrdenCompraVO> listar() throws Exception {
        ArrayList<OrdenCompraVO> lista = new ArrayList<OrdenCompraVO>();
        OrdenCompraVO ordenCompraVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdOrdenCompra, IdPersonaOrdenCompra, FechaCompraOrdenCompra, "
                    + "FechaPagoOrdenCompra, TotalOrdenCompra "
                    + "FROM OrdenCompra ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                ordenCompraVO = new OrdenCompraVO();
                ordenCompraVO.setIdOrdenCompra(rs.getInt(t++));
                ordenCompraVO.getPersonaOrdenCompra().setIdPersona(rs.getInt(t++));
                ordenCompraVO.setFechaCompraOrdenCompra(rs.getTimestamp(t++));
                ordenCompraVO.setFechaPagoOrdenCompra(rs.getTimestamp(t++));
                ordenCompraVO.setTotalOrdenCompra(rs.getBigDecimal(t++));

                lista.add(ordenCompraVO);
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
    public OrdenCompraVO consultarPorId(long idOrdenCompra) throws Exception {
        OrdenCompraVO ordenCompraVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT IdOrdenCompra, IdPersonaOrdenCompra, FechaCompraOrdenCompra, "
                    + "FechaPagoOrdenCompra, TotalOrdenCompra "
                    + "FROM OrdenCompra WHERE IdOrdenCompra = ?  ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idOrdenCompra);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                ordenCompraVO = new OrdenCompraVO();
                ordenCompraVO.setIdOrdenCompra(rs.getInt(t++));
                ordenCompraVO.getPersonaOrdenCompra().setIdPersona(rs.getInt(t++));
                ordenCompraVO.setFechaCompraOrdenCompra(rs.getTimestamp(t++));
                ordenCompraVO.setFechaPagoOrdenCompra(rs.getTimestamp(t++));
                ordenCompraVO.setTotalOrdenCompra(rs.getBigDecimal(t++));
            }

        } catch (Exception e) {
            System.out.println("OrdenCompraDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return ordenCompraVO;
    }

}
