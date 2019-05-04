/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.sql.Timestamp;

/**
 *
 * @author Sergio AlfonsoG
 */

public class DetalleOrdenVO {
       
    private Integer idDetalleOrden;
    private OrdenCompraVO idOrdenCompraDetalleCompra;
    private ProductoVO idProductoDetalleOrden;
    private Integer cantidadDetalleOrden;
    private Long subtotalDetalleOrden; 
    
    public Integer getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(Integer idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public OrdenCompraVO getIdOrdenCompraDetalleCompra() {
        return idOrdenCompraDetalleCompra;
    }

    public void setIdOrdenCompraDetalleCompra(OrdenCompraVO idOrdenCompraDetalleCompra) {
        this.idOrdenCompraDetalleCompra = idOrdenCompraDetalleCompra;
    }

    public ProductoVO getIdProductoDetalleOrden() {
        return idProductoDetalleOrden;
    }

    public void setIdProductoDetalleOrden(ProductoVO idProductoDetalleOrden) {
        this.idProductoDetalleOrden = idProductoDetalleOrden;
    }

    public Integer getCantidadDetalleOrden() {
        return cantidadDetalleOrden;
    }

    public void setCantidadDetalleOrden(Integer cantidadDetalleOrden) {
        this.cantidadDetalleOrden = cantidadDetalleOrden;
    }

    public Long getSubtotalDetalleOrden() {
        return subtotalDetalleOrden;
    }

    public void setSubtotalDetalleOrden(Long subtotalDetalleOrden) {
        this.subtotalDetalleOrden = subtotalDetalleOrden;
    }
    
}
