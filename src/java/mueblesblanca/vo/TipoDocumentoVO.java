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

public class TipoDocumentoVO {
    
    private Integer idTipoDocumento;
    private String descripcionTipoDocumento;
    private Timestamp fechaCreacionTipoDocumento;
    private String usuarioCreacionTipoDocumento;
    private Timestamp fechaModificacionTipoDocumento;
    private String usuarioModificacionTipoDocumento;
    private Integer estadoTipoDocumento;

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcionTipoDocumento() {
        return descripcionTipoDocumento;
    }

    public void setDescripcionTipoDocumento(String descripcionTipoDocumento) {
        this.descripcionTipoDocumento = descripcionTipoDocumento;
    }

    public Timestamp getFechaCreacionTipoDocumento() {
        return fechaCreacionTipoDocumento;
    }

    public void setFechaCreacionTipoDocumento(Timestamp fechaCreacionTipoDocumento) {
        this.fechaCreacionTipoDocumento = fechaCreacionTipoDocumento;
    }

    public String getUsuarioCreacionTipoDocumento() {
        return usuarioCreacionTipoDocumento;
    }

    public void setUsuarioCreacionTipoDocumento(String usuarioCreacionTipoDocumento) {
        this.usuarioCreacionTipoDocumento = usuarioCreacionTipoDocumento;
    }

    public Timestamp getFechaModificacionTipoDocumento() {
        return fechaModificacionTipoDocumento;
    }

    public void setFechaModificacionTipoDocumento(Timestamp fechaModificacionTipoDocumento) {
        this.fechaModificacionTipoDocumento = fechaModificacionTipoDocumento;
    }

    public String getUsuarioModificacionTipoDocumento() {
        return usuarioModificacionTipoDocumento;
    }

    public void setUsuarioModificacionTipoDocumento(String usuarioModificacionTipoDocumento) {
        this.usuarioModificacionTipoDocumento = usuarioModificacionTipoDocumento;
    }

    public Integer getEstadoTipoDocumento() {
        return estadoTipoDocumento;
    }

    public void setEstadoTipoDocumento(Integer estadoTipoDocumento) {
        this.estadoTipoDocumento = estadoTipoDocumento;
    }
    
    
}
