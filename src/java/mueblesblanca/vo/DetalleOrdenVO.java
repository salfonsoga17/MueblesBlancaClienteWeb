/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.math.BigDecimal;

/**
 *
 * @author Sergio AlfonsoG
 */

public class DetalleOrdenVO {
       
    private Integer idDetalleOrden;
    private OrdenCompraVO idOrdenCompraDetalleCompra;
    private ProductoVO idProductoDetalleOrden;
    private Integer cantidadDetalleOrden;
    private BigDecimal subtotalDetalleOrden; 
    
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

    public BigDecimal getSubtotalDetalleOrden() {
        return subtotalDetalleOrden;
    }

    public void setSubtotalDetalleOrden(BigDecimal subtotalDetalleOrden) {
        this.subtotalDetalleOrden = subtotalDetalleOrden;
    }
    
}
