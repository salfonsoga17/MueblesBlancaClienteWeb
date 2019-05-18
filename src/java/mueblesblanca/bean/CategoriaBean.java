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
import mueblesblanca.service.CategoriaService;
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    //Variables
    private Integer idCategoria;
    private String nombreCategoria;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private Integer estadoCategoria;
    private Integer selectedEstado;

    //objetos y listas/////////
    private CategoriaVO categoriaVO;
    private CategoriaVO selectedCategoria;
    private List<CategoriaVO> categoriasFiltro;
    private List<CategoriaVO> categorias;
    private Map<String, Integer> estadosEnum;

    /// Services////////////
    private CategoriaService categoriaService;
    
    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                categoriaService = new CategoriaService();
                setCategorias(categoriaService.listar());
                
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
            setCategoriaVO(new CategoriaVO());
            setIdCategoria(getSelectedCategoria().getIdCategoria());
            setCategoriaVO(categoriaService.consultarPorId(getIdCategoria()));

        } catch (Exception e) {
        }
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

    public Integer getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(Integer estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    public Integer getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Integer selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public CategoriaVO getCategoriaVO() {
        return categoriaVO;
    }

    public void setCategoriaVO(CategoriaVO categoriaVO) {
        this.categoriaVO = categoriaVO;
    }

    public CategoriaVO getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(CategoriaVO selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public List<CategoriaVO> getCategoriasFiltro() {
        return categoriasFiltro;
    }

    public void setCategoriasFiltro(List<CategoriaVO> categoriasFiltro) {
        this.categoriasFiltro = categoriasFiltro;
    }

    public List<CategoriaVO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaVO> categorias) {
        this.categorias = categorias;
    }

    public Map<String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }
    
}
