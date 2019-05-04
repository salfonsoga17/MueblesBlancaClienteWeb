/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.sql.Timestamp;

/**
 *
 * @author Sergio AlfonsoG
 */

public class OrdenCompraVO {
    
    private Integer idOrdenCompra;
    private PersonaVO idPersonaOrdenCompra;
    private Timestamp fechaCompraOrdenCompra;
    private Timestamp fechaPagoOrdenCompra;
    private Long totalOrdenCompra;    
    
    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public PersonaVO getIdPersonaOrdenCompra() {
        return idPersonaOrdenCompra;
    }

    public void setIdPersonaOrdenCompra(PersonaVO idPersonaOrdenCompra) {
        this.idPersonaOrdenCompra = idPersonaOrdenCompra;
    }

    public Timestamp getFechaCompraOrdenCompra() {
        return fechaCompraOrdenCompra;
    }

    public void setFechaCompraOrdenCompra(Timestamp fechaCompraOrdenCompra) {
        this.fechaCompraOrdenCompra = fechaCompraOrdenCompra;
    }

    public Timestamp getFechaPagoOrdenCompra() {
        return fechaPagoOrdenCompra;
    }

    public void setFechaPagoOrdenCompra(Timestamp fechaPagoOrdenCompra) {
        this.fechaPagoOrdenCompra = fechaPagoOrdenCompra;
    }

    public Long getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(Long totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }
    
}
