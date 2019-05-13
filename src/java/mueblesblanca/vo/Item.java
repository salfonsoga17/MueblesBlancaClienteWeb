/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

/**
 *
 * @author jhons
 */
public class Item {
    private Integer id;
    private ProductoVO producto;
    private Integer cantidad;

    public Item(ProductoVO producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
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
        return this.getCantidad() * this.producto.getValorUnitarioProducto().doubleValue();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
