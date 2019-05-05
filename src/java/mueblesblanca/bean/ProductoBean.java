/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.constante.EstadoEnumLista;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.ProductoService;
import mueblesblanca.vo.ProductoVO;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    //Variables
    private Integer idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String altoProducto;
    private String anchoProducto;
    private String colorProducto;
    private String materialProducto;
    private Integer garantiaMesesProducto;
    private BigDecimal valorUnitarioProducto;
    private Integer selectedImagen;
    private Integer selectedModelo;
    private Integer selectedCategoria;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private Integer estadoProducto;
    private Integer selectedEstado;

    //objetos y listas/////////
    private ProductoVO productoVO;
    private ProductoVO selectedProducto;
    private List<ProductoVO> productosFiltro;
    private List<ProductoVO> productos;
    private Map<String, Integer> estadosEnum;

    /// Services////////////
    private ProductoService productoService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                productoService = new ProductoService();
                setProductos(productoService.listar());
                
                setEstadosEnum(new HashMap< String, Integer>());
                for (EstadoEnumLista enl : EstadoEnumLista.values()) {
                    getEstadosEnum().put(enl.getNombre(), enl.getIndex());
                }

            } catch (Exception e) {

            }
        }
    }

    public void consultarPorId() {
        try {
            setProductoVO(new ProductoVO());
            setIdProducto(getSelectedProducto().getIdProducto());
            setProductoVO(productoService.consultarPorId(getIdProducto()));

        } catch (Exception e) {
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getAltoProducto() {
        return altoProducto;
    }

    public void setAltoProducto(String altoProducto) {
        this.altoProducto = altoProducto;
    }

    public String getAnchoProducto() {
        return anchoProducto;
    }

    public void setAnchoProducto(String anchoProducto) {
        this.anchoProducto = anchoProducto;
    }

    public String getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(String colorProducto) {
        this.colorProducto = colorProducto;
    }

    public String getMaterialProducto() {
        return materialProducto;
    }

    public void setMaterialProducto(String materialProducto) {
        this.materialProducto = materialProducto;
    }

    public Integer getGarantiaMesesProducto() {
        return garantiaMesesProducto;
    }

    public void setGarantiaMesesProducto(Integer garantiaMesesProducto) {
        this.garantiaMesesProducto = garantiaMesesProducto;
    }

    public BigDecimal getValorUnitarioProducto() {
        return valorUnitarioProducto;
    }

    public void setValorUnitarioProducto(BigDecimal valorUnitarioProducto) {
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public Integer getSelectedImagen() {
        return selectedImagen;
    }

    public void setSelectedImagen(Integer selectedImagen) {
        this.selectedImagen = selectedImagen;
    }

    public Integer getSelectedModelo() {
        return selectedModelo;
    }

    public void setSelectedModelo(Integer selectedModelo) {
        this.selectedModelo = selectedModelo;
    }

    public Integer getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Integer selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Integer getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(Integer estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Integer getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Integer selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public ProductoVO getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(ProductoVO selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public List<ProductoVO> getProductosFiltro() {
        return productosFiltro;
    }

    public void setProductosFiltro(List<ProductoVO> productosFiltro) {
        this.productosFiltro = productosFiltro;
    }

    public List<ProductoVO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }

    public Map<String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

}
