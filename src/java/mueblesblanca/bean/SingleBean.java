/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.ProductoService;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "singleBean")
@ViewScoped
public class SingleBean {

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
    private ProductoService productoService;
    private ProductoVO productoVO;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                setProductoService(new ProductoService());
                setProductoVO(new ProductoVO());

            } catch (Exception e) {

            }
        }
    }

    public void preRenderView() throws Exception {
        System.out.println("HOla " + getIdProducto());
        int idProductoVista;

        idProductoVista = getIdProducto();
        setProductoVO(getProductoService().consultarPorId(idProductoVista));
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

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

}
