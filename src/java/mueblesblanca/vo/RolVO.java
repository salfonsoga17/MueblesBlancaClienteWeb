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

public class RolVO {
    private Integer idRol;
    private String nombreRol;
    private Timestamp fechaCreacionRol;
    private String usuarioCreacionRol;
    private Timestamp fechaModificacionRol;
    private String usuarioModificacionRol;
    private Integer estadoRol;
    
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Timestamp getFechaCreacionRol() {
        return fechaCreacionRol;
    }

    public void setFechaCreacionRol(Timestamp fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public String getUsuarioCreacionRol() {
        return usuarioCreacionRol;
    }

    public void setUsuarioCreacionRol(String usuarioCreacionRol) {
        this.usuarioCreacionRol = usuarioCreacionRol;
    }

    public Timestamp getFechaModificacionRol() {
        return fechaModificacionRol;
    }

    public void setFechaModificacionRol(Timestamp fechaModificacionRol) {
        this.fechaModificacionRol = fechaModificacionRol;
    }

    public String getUsuarioModificacionRol() {
        return usuarioModificacionRol;
    }

    public void setUsuarioModificacionRol(String usuarioModificacionRol) {
        this.usuarioModificacionRol = usuarioModificacionRol;
    }

    public Integer getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Integer estadoRol) {
        this.estadoRol = estadoRol;
    }
    
}
