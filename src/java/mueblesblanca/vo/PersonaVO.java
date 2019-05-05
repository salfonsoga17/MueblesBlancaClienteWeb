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
public class PersonaVO {

    private Integer idPersona;
    private Long numeroIdentificacionPersona;
    private TipoDocumentoVO TipoDocumentoPersona;
    private String primerNombrePersona;
    private String segundoNombrePersona;
    private String primerApellidoPersona;
    private String segundoApellidoPersona;
    private String emailPersona;
    private Long celularPersonaNatural;
    private String direccionPersona;
    private RolVO RolPersona;

    public RolVO getRolPersona() {
        return RolPersona;
    }

    public void setRolPersona(RolVO RolPersona) {
        this.RolPersona = RolPersona;
    }
    private String passwordPersona;
    private Timestamp fechaCreacionPersona;
    private Timestamp fechaModificacionPersona;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Long getNumeroIdentificacionPersona() {
        return numeroIdentificacionPersona;
    }

    public void setNumeroIdentificacionPersona(Long numeroIdentificacionPersona) {
        this.numeroIdentificacionPersona = numeroIdentificacionPersona;
    }

    public TipoDocumentoVO getTipoDocumentoPersona() {
        return TipoDocumentoPersona;
    }

    public void setTipoDocumentoPersona(TipoDocumentoVO TipoDocumentoPersona) {
        this.TipoDocumentoPersona = TipoDocumentoPersona;
    }

    public String getPrimerNombrePersona() {
        return primerNombrePersona;
    }

    public void setPrimerNombrePersona(String primerNombrePersona) {
        this.primerNombrePersona = primerNombrePersona;
    }

    public String getSegundoNombrePersona() {
        return segundoNombrePersona;
    }

    public void setSegundoNombrePersona(String segundoNombrePersona) {
        this.segundoNombrePersona = segundoNombrePersona;
    }

    public String getPrimerApellidoPersona() {
        return primerApellidoPersona;
    }

    public void setPrimerApellidoPersona(String primerApellidoPersona) {
        this.primerApellidoPersona = primerApellidoPersona;
    }

    public String getSegundoApellidoPersona() {
        return segundoApellidoPersona;
    }

    public void setSegundoApellidoPersona(String segundoApellidoPersona) {
        this.segundoApellidoPersona = segundoApellidoPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public Long getCelularPersonaNatural() {
        return celularPersonaNatural;
    }

    public void setCelularPersonaNatural(Long celularPersonaNatural) {
        this.celularPersonaNatural = celularPersonaNatural;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }

    public Timestamp getFechaCreacionPersona() {
        return fechaCreacionPersona;
    }

    public void setFechaCreacionPersona(Timestamp fechaCreacionPersona) {
        this.fechaCreacionPersona = fechaCreacionPersona;
    }

    public Timestamp getFechaModificacionPersonaNatural() {
        return fechaModificacionPersona;
    }

    public void setFechaModificacionPersona(Timestamp fechaModificacionPersona) {
        this.fechaModificacionPersona = fechaModificacionPersona;
    }

}
