/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.vo.ArticuloVO;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio Alfonso G
 */

@ManagedBean(name = "carritoBean")
@ViewScoped
public class CarritoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;
    
    //Variables
    private List<ArticuloVO> articulo = new ArrayList<ArticuloVO>();
    private ArticuloVO selectedArticulo = new ArticuloVO();
    private float totalCarrito;
    
    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
        }
    }
    
    public List<ArticuloVO> AñadirAlCarrito (ProductoVO producto, Integer cantidad){
        for (ArticuloVO articulovo : articulo) {
            if (articulovo.getProducto().getIdProducto()==producto.getIdProducto()){
                articulovo.setCantidad(cantidad + articulovo.getCantidad());
                articulovo.setId(producto.getIdProducto());
                return articulo;
            }
        }
        ArticuloVO articulovo1 = new ArticuloVO();
        articulovo1.setCantidad(cantidad);
        articulovo1.setProducto(producto);
        articulovo1.setValorTotal(1);
        articulovo1.setId(producto.getIdProducto());
        articulo.add(articulovo1);
        
        return articulo;

    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public List<ArticuloVO> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<ArticuloVO> articulo) {
        this.articulo = articulo;
    }

    public float getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(float totalCarrito) {
        this.totalCarrito = totalCarrito;
    }

    public ArticuloVO getSelectedArticulo() {
        return selectedArticulo;
    }

    public void setSelectedArticulo(ArticuloVO selectedArticulo) {
        this.selectedArticulo = selectedArticulo;
    }
  
}
