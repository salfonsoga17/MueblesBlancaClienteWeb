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

public class CategoriaVO {
    
    private Integer idCategoria;
    private String nombreCategoria;
    private Timestamp fechaCreacionCategoria;
    private String usuarioCreacionCategoria;
    private Timestamp fechaModificacionCategoria;
    private String usuarioModificacionCategoria;
    private Integer estadoCategoria;

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

    public Timestamp getFechaCreacionCategoria() {
        return fechaCreacionCategoria;
    }

    public void setFechaCreacionCategoria(Timestamp fechaCreacionCategoria) {
        this.fechaCreacionCategoria = fechaCreacionCategoria;
    }

    public String getUsuarioCreacionCategoria() {
        return usuarioCreacionCategoria;
    }

    public void setUsuarioCreacionCategoria(String usuarioCreacionCategoria) {
        this.usuarioCreacionCategoria = usuarioCreacionCategoria;
    }

    public Timestamp getFechaModificacionCategoria() {
        return fechaModificacionCategoria;
    }

    public void setFechaModificacionCategoria(Timestamp fechaModificacionCategoria) {
        this.fechaModificacionCategoria = fechaModificacionCategoria;
    }

    public String getUsuarioModificacionCategoria() {
        return usuarioModificacionCategoria;
    }

    public void setUsuarioModificacionCategoria(String usuarioModificacionCategoria) {
        this.usuarioModificacionCategoria = usuarioModificacionCategoria;
    }

    public Integer getEstado() {
        return estadoCategoria;
    }

    public void setEstado(Integer estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    } 
      
}
