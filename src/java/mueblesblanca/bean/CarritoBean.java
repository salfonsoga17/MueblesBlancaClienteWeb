/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.ProductoService;
import mueblesblanca.vo.Item;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Alexis Holguin github:MoraHol
 */
@ManagedBean(name = "CarritoBean")
@SessionScoped
public class CarritoBean implements Serializable{

    private ArrayList<Item> items;
    private ProductoService productoService;
    private BigDecimal total;

    @PostConstruct
    public void postConstruct() {
        if (FacesContext.getCurrentInstance() != null) {
            //FacesContext.getCurrentInstance().
            total = new BigDecimal(0);
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                ArrayList<Item> carrito = (ArrayList<Item>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("carrito");
                if(carrito != null){
                    items = carrito;
                }else{
                    items = new ArrayList<>();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito",items);
                }
                productoService = new ProductoService();
                calcularTotal();
            } catch (Exception e) {
            }
        }
    }

    public void agregarProducto(ProductoVO producto, int cantidad) throws Exception {
        for (Item item : items) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                item.setCantidad(item.getCantidad() + cantidad);
                calcularTotal();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito", this.items);
                return;
            }
        }
        items.add(new Item(producto, cantidad));
        calcularTotal();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito", this.items);
    }

    public void borrarProducto(ProductoVO producto) {
        for (Item item : items) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                item.setCantidad(item.getCantidad() - 1);
                
                if(item.getCantidad() <= 0){
                    items.remove(item);
                }       
            }
        }
        calcularTotal();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito", this.items);
    }

    public void calcularTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getValorTotal();
        }
        this.total = new BigDecimal(total);
    }

    public void borrarItem(Item item) {
        items.remove(item);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito", this.items);
        calcularTotal();
    }

        
    public void vaciarCarrito(){
        items = new ArrayList<>();
        calcularTotal();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("carrito", this.items);
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
