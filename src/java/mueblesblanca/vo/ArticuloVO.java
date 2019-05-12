/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.math.BigDecimal;

/**
 *
 * @author Sergio Alfonso G
 */

public class ArticuloVO {
    
    private Integer id;
    private ProductoVO producto;
    private Integer cantidad;
    private double valorTotal;

    //se instancian clases u objetos de llaves foraneas para evitar null 
    public ArticuloVO(){
        this.producto = new ProductoVO();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
 
}
