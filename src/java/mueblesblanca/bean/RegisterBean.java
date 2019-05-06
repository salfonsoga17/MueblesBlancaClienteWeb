/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.PersonaService;
import mueblesblanca.vo.PersonaVO;
import mueblesblanca.vo.RolVO;
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author Alexis Holguin
 */
@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {

    PersonaVO personaVO;
    PersonaService personaService;

    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String address;
    private String personalId;
    private String phoneNumber;

    @PostConstruct
    public void init() {
        personaService = new PersonaService();
    }

    private void resetInput() {
        email = new String();
        password = new String();
        firstName = new String();
        secondName = new String();
        firstSurname = new String();
        secondSurname = new String();
        address = new String();
        personalId = new String();
        phoneNumber = new String();
    }

    public String insertar() {
        try {
            personaVO = new PersonaVO();
            personaVO.setEmailPersona(email);
            personaVO.setPrimerNombrePersona(firstName);
            personaVO.setSegundoNombrePersona(secondName);
            personaVO.setPrimerApellidoPersona(firstSurname);
            personaVO.setSegundoApellidoPersona(secondSurname);
            personaVO.setNumeroIdentificacionPersona(new Long(personalId));
            personaVO.setPasswordPersona(personaService.convertSHA256(password));
            personaVO.setDireccionPersona(address);
            personaVO.setCelularPersonaNatural(new Long(phoneNumber));
            personaVO.setTipoDocumentoPersona(new TipoDocumentoVO());
            personaVO.getTipoDocumentoPersona().setIdTipoDocumento(1);
            personaVO.setRolPersona(new RolVO());
            personaVO.getRolPersona().setIdRol(1);
            if (personaService.insertar(personaVO) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha creado la Cuenta"));
                resetInput();
                return "/login.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error al registrarse"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        return "";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public PersonaVO getPersonaVO() {
        return personaVO;
    }

    public void setPersonaVO(PersonaVO personaVO) {
        this.personaVO = personaVO;
    }

    public PersonaService getPersonaService() {
        return personaService;
    }

    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName.trim();
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname.trim();
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId.trim();
    }
    public void eliminateSpaces(){
        
        
        firstName = new String();
        secondName = new String();
        firstSurname = new String();
        secondSurname = new String();
        address = new String();
        personalId = new String();
        phoneNumber = new String();
    }
}
