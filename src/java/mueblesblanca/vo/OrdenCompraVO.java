/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Sergio AlfonsoG
 */

public class OrdenCompraVO {
    
    private Integer idOrdenCompra;
    private PersonaVO personaOrdenCompra;
    private Timestamp fechaCompraOrdenCompra;
    private Timestamp fechaPagoOrdenCompra;
    private BigDecimal totalOrdenCompra;    
    
    public OrdenCompraVO(){
        personaOrdenCompra = new PersonaVO();
    }
    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public PersonaVO getPersonaOrdenCompra() {
        return personaOrdenCompra;
    }

    public void setPersonaOrdenCompra(PersonaVO PersonaOrdenCompra) {
        this.personaOrdenCompra = PersonaOrdenCompra;
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

    public BigDecimal getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(BigDecimal totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }
    
}
