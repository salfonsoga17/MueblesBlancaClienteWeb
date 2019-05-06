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

public class ImagenVO {

    private Integer idImagen;
    private ProductoVO idProductoImagen;
    private String tituloImagen;
    private byte[] codigoImagen;
    private Timestamp fechaCreacionImagen;
    private String usuarioCreaciónImagen;
    private Timestamp fechaModificaciónImagen;
    private String usuarioModificaciónImagen;
    private Integer estadoImagen;
    private String imagenFoto;
    
    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public ProductoVO getIdProductoImagen() {
        return idProductoImagen;
    }

    public void setIdProductoImagen(ProductoVO idProductoImagen) {
        this.idProductoImagen = idProductoImagen;
    }

    public String getTituloImagen() {
        return tituloImagen;
    }

    public void setTituloImagen(String tituloImagen) {
        this.tituloImagen = tituloImagen;
    }

    public byte[] getCodigoImagen() {
        return codigoImagen;
    }

    public void setCodigoImagen(byte[] codigoImagen) {
        this.codigoImagen = codigoImagen;
    }

    public Timestamp getFechaCreacionImagen() {
        return fechaCreacionImagen;
    }

    public void setFechaCreacionImagen(Timestamp fechaCreacionImagen) {
        this.fechaCreacionImagen = fechaCreacionImagen;
    }

    public String getUsuarioCreaciónImagen() {
        return usuarioCreaciónImagen;
    }

    public void setUsuarioCreaciónImagen(String usuarioCreaciónImagen) {
        this.usuarioCreaciónImagen = usuarioCreaciónImagen;
    }

    public Timestamp getFechaModificaciónImagen() {
        return fechaModificaciónImagen;
    }

    public void setFechaModificaciónImagen(Timestamp fechaModificaciónImagen) {
        this.fechaModificaciónImagen = fechaModificaciónImagen;
    }

    public String getUsuarioModificaciónImagen() {
        return usuarioModificaciónImagen;
    }

    public void setUsuarioModificaciónImagen(String usuarioModificaciónImagen) {
        this.usuarioModificaciónImagen = usuarioModificaciónImagen;
    }

    public Integer getEstadoImagen() {
        return estadoImagen;
    }

    public void setEstadoImagen(Integer estadoImagen) {
        this.estadoImagen = estadoImagen;
    }

    public String getImagenFoto() {
        return imagenFoto;
    }

    public void setImagenFoto(String imagenFoto) {
        this.imagenFoto = imagenFoto;
    }

    public void getCodigoImagen(byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
