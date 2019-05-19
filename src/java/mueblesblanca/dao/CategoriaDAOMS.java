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
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class CategoriaDAOMS extends ConexionSQL implements CategoriaDAO {

    @Override
    public ArrayList<CategoriaVO> listar() throws Exception {
        ArrayList<CategoriaVO> lista = new ArrayList<CategoriaVO>();
        CategoriaVO categoriaVO;
        try {
            this.Conectar();
            String consulta = "SELECT IdCategoria, NombreCategoria, FechaCreacionCategoria, UsuarioCreacionCategoria, "
                            + "FechaModificacionCategoria, UsuarioModificacionCategoria, EstadoCategoria FROM Categoria "
                            + "WHERE EstadoCategoria <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                categoriaVO = new CategoriaVO();
                categoriaVO.setIdCategoria(rs.getInt(t++));
                categoriaVO.setNombreCategoria(rs.getString(t++));
                categoriaVO.setFechaCreacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioCreacionCategoria(rs.getString(t++));
                categoriaVO.setFechaModificacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioModificacionCategoria(rs.getString(t++));
                categoriaVO.setEstado(rs.getInt(t++));
                
                lista.add(categoriaVO);
            }
        } catch (Exception e) {
            System.out.println(" CategoriaDAOMS: Se presento un error al consultar la tabla Categoria. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public CategoriaVO consultarPorId(long idCategoria) throws Exception {
        CategoriaVO categoriaVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT IdCategoria, NombreCategoria, FechaCreacionCategoria, UsuarioCreacionCategoria, "
                            + "FechaModificacionCategoria, UsuarioModificacionCategoria, EstadoCategoria FROM Categoria "
                            + "WHERE IdCategoria = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idCategoria);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                categoriaVO = new CategoriaVO();
                categoriaVO.setIdCategoria(rs.getInt(t++));
                categoriaVO.setNombreCategoria(rs.getString(t++));
                categoriaVO.setFechaCreacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioCreacionCategoria(rs.getString(t++));
                categoriaVO.setFechaModificacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioModificacionCategoria(rs.getString(t++));
                categoriaVO.setEstado(rs.getInt(t++));
                
            }

        } catch (Exception e) {
            System.out.println("CategoriaDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return categoriaVO;
    }
}
