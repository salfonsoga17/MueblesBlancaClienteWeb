/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.constante.EstadoEnumLista;
import mueblesblanca.service.DetalleOrdenService;
import mueblesblanca.vo.DetalleOrdenVO;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "detalleOrdenBean")
@ViewScoped
public class DetalleOrdenBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    //Variables
    private Integer idDetalleOrden;
    private Integer selectedIdOrdenCompraDetalleCompra;
    private Integer selectedIdProductoDetalleOrden;
    private Integer cantidadDetalleOrden;
    private BigDecimal SubtotalDetalleOrden;

    //objetos y listas/////////
    private DetalleOrdenVO detalleOrdenVO;
    private DetalleOrdenVO selectedDetalleOrden;
    private List<DetalleOrdenVO> detallesOrdenFiltro;
    private List<DetalleOrdenVO> detallesOrdenes;
    private Map<String, Integer> estadosEnum;

    /// Services////////////
    private DetalleOrdenService detalleOrdenService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                detalleOrdenService = new DetalleOrdenService();
                setDetallesOrdenes(detalleOrdenService.listar());
                
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
            setDetalleOrdenVO(new DetalleOrdenVO());

            getDetalleOrdenVO().setIdDetalleOrden(id);

            getDetalleOrdenVO().getIdOrdenCompraDetalleCompra().setIdOrdenCompra(selectedIdOrdenCompraDetalleCompra);
            getDetalleOrdenVO().getIdProductoDetalleOrden().setIdProducto(selectedIdProductoDetalleOrden);
            getDetalleOrdenVO().setCantidadDetalleOrden(cantidadDetalleOrden);
            getDetalleOrdenVO().setSubtotalDetalleOrden(SubtotalDetalleOrden);

            if (detalleOrdenService.actualizar(getDetalleOrdenVO()) > 0) {
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
            setDetalleOrdenVO(new DetalleOrdenVO());
            setIdDetalleOrden(getSelectedDetalleOrden().getIdDetalleOrden());
            setDetalleOrdenVO(detalleOrdenService.consultarPorId(getIdDetalleOrden()));

        } catch (Exception e) {
        }
    }
    
    public void insertar() {
        try {
            detalleOrdenVO = new DetalleOrdenVO();

            detalleOrdenVO.getIdOrdenCompraDetalleCompra().setIdOrdenCompra(selectedIdOrdenCompraDetalleCompra);
            detalleOrdenVO.getIdProductoDetalleOrden().setIdProducto(selectedIdProductoDetalleOrden);
            detalleOrdenVO.setCantidadDetalleOrden(cantidadDetalleOrden);
            detalleOrdenVO.setSubtotalDetalleOrden(SubtotalDetalleOrden);

            if (detalleOrdenService.insertar(getDetalleOrdenVO()) > 0) {
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

    public Integer getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(Integer idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public Integer getSelectedIdOrdenCompraDetalleCompra() {
        return selectedIdOrdenCompraDetalleCompra;
    }

    public void setSelectedIdOrdenCompraDetalleCompra(Integer selectedIdOrdenCompraDetalleCompra) {
        this.selectedIdOrdenCompraDetalleCompra = selectedIdOrdenCompraDetalleCompra;
    }

    public Integer getSelectedIdProductoDetalleOrden() {
        return selectedIdProductoDetalleOrden;
    }

    public void setSelectedIdProductoDetalleOrden(Integer selectedIdProductoDetalleOrden) {
        this.selectedIdProductoDetalleOrden = selectedIdProductoDetalleOrden;
    }

    public Integer getCantidadDetalleOrden() {
        return cantidadDetalleOrden;
    }

    public void setCantidadDetalleOrden(Integer cantidadDetalleOrden) {
        this.cantidadDetalleOrden = cantidadDetalleOrden;
    }

    public BigDecimal getSubtotalDetalleOrden() {
        return SubtotalDetalleOrden;
    }

    public void setSubtotalDetalleOrden(BigDecimal SubtotalDetalleOrden) {
        this.SubtotalDetalleOrden = SubtotalDetalleOrden;
    }

    public DetalleOrdenVO getDetalleOrdenVO() {
        return detalleOrdenVO;
    }

    public void setDetalleOrdenVO(DetalleOrdenVO detalleOrdenVO) {
        this.detalleOrdenVO = detalleOrdenVO;
    }

    public DetalleOrdenVO getSelectedDetalleOrden() {
        return selectedDetalleOrden;
    }

    public void setSelectedDetalleOrden(DetalleOrdenVO selectedDetalleOrden) {
        this.selectedDetalleOrden = selectedDetalleOrden;
    }

    public List<DetalleOrdenVO> getDetallesOrdenFiltro() {
        return detallesOrdenFiltro;
    }

    public void setDetallesOrdenFiltro(List<DetalleOrdenVO> detallesOrdenFiltro) {
        this.detallesOrdenFiltro = detallesOrdenFiltro;
    }

    public List<DetalleOrdenVO> getDetallesOrdenes() {
        return detallesOrdenes;
    }

    public void setDetallesOrdenes(List<DetalleOrdenVO> detallesOrdenes) {
        this.detallesOrdenes = detallesOrdenes;
    }

    public Map<String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

}
