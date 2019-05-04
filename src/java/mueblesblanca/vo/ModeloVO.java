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

public class ModeloVO {

    private Integer idModelo;
    private ProductoVO idProductoModelo;
    private String tituloModelo;
    private String rutaModelo;
    private Timestamp fechaCreacionModelo;
    private String usuarioCreaciónModelo;
    private Timestamp fechaModificaciónModelo;
    private String usuarioModificaciónModelo;
    private Integer estadoModelo;
    
    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public ProductoVO getIdProductoModelo() {
        return idProductoModelo;
    }

    public void setIdProductoModelo(ProductoVO idProductoModelo) {
        this.idProductoModelo = idProductoModelo;
    }

    public String getTituloModelo() {
        return tituloModelo;
    }

    public void setTituloModelo(String tituloModelo) {
        this.tituloModelo = tituloModelo;
    }

    public String getRutaModelo() {
        return rutaModelo;
    }

    public void setRutaModelo(String RutaModelo) {
        this.rutaModelo = RutaModelo;
    }

    public Timestamp getFechaCreacionModelo() {
        return fechaCreacionModelo;
    }

    public void setFechaCreacionModelo(Timestamp fechaCreacionModelo) {
        this.fechaCreacionModelo = fechaCreacionModelo;
    }

    public String getUsuarioCreaciónModelo() {
        return usuarioCreaciónModelo;
    }

    public void setUsuarioCreaciónModelo(String usuarioCreaciónModelo) {
        this.usuarioCreaciónModelo = usuarioCreaciónModelo;
    }

    public Timestamp getFechaModificaciónModelo() {
        return fechaModificaciónModelo;
    }

    public void setFechaModificaciónModelo(Timestamp fechaModificaciónModelo) {
        this.fechaModificaciónModelo = fechaModificaciónModelo;
    }

    public String getUsuarioModificaciónModelo() {
        return usuarioModificaciónModelo;
    }

    public void setUsuarioModificaciónModelo(String usuarioModificaciónModelo) {
        this.usuarioModificaciónModelo = usuarioModificaciónModelo;
    }

    public Integer getEstadoModelo() {
        return estadoModelo;
    }

    public void setEstadoModelo(Integer estadoModelo) {
        this.estadoModelo = estadoModelo;
    }
    
}
