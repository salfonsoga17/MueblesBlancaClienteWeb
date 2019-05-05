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
import java.sql.Timestamp;
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
import mueblesblanca.service.OrdenCompraService;
import mueblesblanca.vo.OrdenCompraVO;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "ordenCompraBean")
@ViewScoped
public class OrdenCompraBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    //Variables
    private Integer idOrdenCompra;
    private Integer selectedPersonaOrdenCompra;
    private Timestamp fechaPagoOrdenCompra;
    private BigDecimal totalOrdenCompra;

    //objetos y listas/////////
    private OrdenCompraVO ordenCompraVO;
    private OrdenCompraVO selectedOrdenCompra;
    private List<OrdenCompraVO> ordenesCompraFiltro;
    private List<OrdenCompraVO> ordenesCompras;
    private Map<String, Integer> estadosEnum;

    /// Services////////////
    private OrdenCompraService ordenCompraService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                ordenCompraService = new OrdenCompraService();
                setOrdenesCompras(ordenCompraService.listar());
                
                setEstadosEnum(new HashMap< String, Integer>());
                for (EstadoEnumLista enl : EstadoEnumLista.values()) {
                    getEstadosEnum().put(enl.getNombre(), enl.getIndex());
                }

            } catch (Exception e) {

            }
        }
    }
    
    public void actualizar(Integer id) {
        try {
            setOrdenCompraVO(new OrdenCompraVO());

            getOrdenCompraVO().setIdOrdenCompra(id);

            getOrdenCompraVO().getIdPersonaOrdenCompra().setIdPersona(selectedPersonaOrdenCompra);
            getOrdenCompraVO().setFechaPagoOrdenCompra(fechaPagoOrdenCompra);
            getOrdenCompraVO().setTotalOrdenCompra(totalOrdenCompra);

            if (ordenCompraService.actualizar(getOrdenCompraVO()) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se actualizo "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }
        } catch (Exception e) {
        }
    }

    public void consultarPorId() {
        try {
            setOrdenCompraVO(new OrdenCompraVO());
            setIdOrdenCompra(getSelectedOrdenCompra().getIdOrdenCompra());
            setOrdenCompraVO(ordenCompraService.consultarPorId(getIdOrdenCompra()));

        } catch (Exception e) {
        }
    }
    
    public void insertar() {
        try {
            ordenCompraVO = new OrdenCompraVO();

            ordenCompraVO.getIdPersonaOrdenCompra().setIdPersona(selectedPersonaOrdenCompra);
            ordenCompraVO.setFechaPagoOrdenCompra(fechaPagoOrdenCompra);
            ordenCompraVO.setTotalOrdenCompra(totalOrdenCompra);

            if (ordenCompraService.insertar(getOrdenCompraVO()) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Integer getSelectedPersonaOrdenCompra() {
        return selectedPersonaOrdenCompra;
    }

    public void setSelectedPersonaOrdenCompra(Integer selectedPersonaOrdenCompra) {
        this.selectedPersonaOrdenCompra = selectedPersonaOrdenCompra;
    }

    public Timestamp getFechaPagoOrdenCompra() {
        return fechaPagoOrdenCompra;
    }

    public void setFechaPagoOrdenCompra(Timestamp fechaPagoOrdenCompra) {
        this.fechaPagoOrdenCompra = fechaPagoOrdenCompra;
    }

    public BigDecimal getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(BigDecimal totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }

    public OrdenCompraVO getOrdenCompraVO() {
        return ordenCompraVO;
    }

    public void setOrdenCompraVO(OrdenCompraVO ordenCompraVO) {
        this.ordenCompraVO = ordenCompraVO;
    }

    public OrdenCompraVO getSelectedOrdenCompra() {
        return selectedOrdenCompra;
    }

    public void setSelectedOrdenCompra(OrdenCompraVO selectedOrdenCompra) {
        this.selectedOrdenCompra = selectedOrdenCompra;
    }

    public List<OrdenCompraVO> getOrdenesCompraFiltro() {
        return ordenesCompraFiltro;
    }

    public void setOrdenesCompraFiltro(List<OrdenCompraVO> ordenesCompraFiltro) {
        this.ordenesCompraFiltro = ordenesCompraFiltro;
    }

    public List<OrdenCompraVO> getOrdenesCompras() {
        return ordenesCompras;
    }

    public void setOrdenesCompras(List<OrdenCompraVO> ordenesCompras) {
        this.ordenesCompras = ordenesCompras;
    }

    public Map<String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

}
