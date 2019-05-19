/*
 * To change this license header;choose License Headers in Project Properties.
 * To change this template file;choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.PersonaService;
import mueblesblanca.vo.PersonaVO;
import mueblesblanca.vo.RolVO;
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

@ManagedBean(name = "personaBean")
@ViewScoped
public class PersonaBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    //Variables
    private Integer idPersona;
    private Long NumeroIdentificacionPersona;
    private Integer selectedIdTipoDocumentoPersona;
    private String primerNombrePersona;
    private String segundoNombrePersona;
    private String primerApellidoPersona;
    private String segundoApellidoPersona;
    private String EmailPersona;
    private Long celularPersona;
    private String direccionPersona;
    private Integer selectedIdRolPersona;
    private String passwordPersona;

    //objetos y listas/////////
    private PersonaVO personaVO;
    private PersonaVO selectedPersona;
    private List<PersonaVO> personasFiltro;
    private List<PersonaVO> personaNaturales;

    /// Services////////////
    private PersonaService personaService;


    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                personaService = new PersonaService();
                personaNaturales = personaService.listar();
            } catch (Exception e) {

            }
        }
    }

    public void actualizar(Integer id) {
        try {
            personaVO = new PersonaVO();
            
            personaVO.setIdPersona(id);

            personaVO.setNumeroIdentificacionPersona(NumeroIdentificacionPersona);
            personaVO.getTipoDocumentoPersona().setIdTipoDocumento(selectedIdTipoDocumentoPersona);
            personaVO.setPrimerNombrePersona(primerNombrePersona);
            personaVO.setSegundoNombrePersona(segundoNombrePersona);
            personaVO.setPrimerApellidoPersona(primerApellidoPersona);
            personaVO.setSegundoApellidoPersona(segundoApellidoPersona);
            personaVO.setEmailPersona(EmailPersona);
            personaVO.setCelularPersonaNatural(celularPersona);
            personaVO.setDireccionPersona(direccionPersona);
            personaVO.getRolPersona().setIdRol(selectedIdRolPersona);
            personaVO.setPasswordPersona(passwordPersona);

            if (personaService.actualizar(personaVO) > 0) {
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
            personaVO = new PersonaVO();
            idPersona = selectedPersona.getIdPersona();
            personaVO = personaService.consultarPorId(idPersona);
            
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            personaVO = new PersonaVO();

            personaVO.setNumeroIdentificacionPersona(NumeroIdentificacionPersona);
            personaVO.getTipoDocumentoPersona().setIdTipoDocumento(selectedIdTipoDocumentoPersona);
            personaVO.setPrimerNombrePersona(primerNombrePersona);
            personaVO.setSegundoNombrePersona(segundoNombrePersona);
            personaVO.setPrimerApellidoPersona(primerApellidoPersona);
            personaVO.setSegundoApellidoPersona(segundoApellidoPersona);
            personaVO.setEmailPersona(EmailPersona);
            personaVO.setCelularPersonaNatural(celularPersona);
            personaVO.setDireccionPersona(direccionPersona);
            personaVO.getRolPersona().setIdRol(selectedIdRolPersona);
            personaVO.setPasswordPersona(passwordPersona);

            if (personaService.insertar(personaVO) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

        } catch (Exception e) {
            System.out.println("error: "+ e.getMessage());
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Long getNumeroIdentificacionPersona() {
        return NumeroIdentificacionPersona;
    }

    public void setNumeroIdentificacionPersona(Long NumeroIdentificacionPersona) {
        this.NumeroIdentificacionPersona = NumeroIdentificacionPersona;
    }

    public Integer getSelectedIdTipoDocumentoPersona() {
        return selectedIdTipoDocumentoPersona;
    }

    public void setSelectedIdTipoDocumentoPersona(Integer selectedIdTipoDocumentoPersona) {
        this.selectedIdTipoDocumentoPersona = selectedIdTipoDocumentoPersona;
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
        return EmailPersona;
    }

    public void setEmailPersona(String EmailPersona) {
        this.EmailPersona = EmailPersona;
    }

    public Long getCelularPersona() {
        return celularPersona;
    }

    public void setCelularPersona(Long celularPersona) {
        this.celularPersona = celularPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public Integer getSelectedIdRolPersona() {
        return selectedIdRolPersona;
    }

    public void setSelectedIdRolPersona(Integer selectedIdRolPersona) {
        this.selectedIdRolPersona = selectedIdRolPersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }

    public PersonaVO getPersonaVO() {
        return personaVO;
    }

    public void setPersonaVO(PersonaVO personaVO) {
        this.personaVO = personaVO;
    }

    public PersonaVO getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(PersonaVO selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public List<PersonaVO> getPersonasFiltro() {
        return personasFiltro;
    }

    public void setPersonasFiltro(List<PersonaVO> personasFiltro) {
        this.personasFiltro = personasFiltro;
    }

    public List<PersonaVO> getPersonaNaturales() {
        return personaNaturales;
    }

    public void setPersonaNaturales(List<PersonaVO> personaNaturales) {
        this.personaNaturales = personaNaturales;
    }

}
