package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.PersonaService;
import mueblesblanca.vo.PersonaVO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean  implements Serializable{

    private String email;
    private String password;
    private PersonaService userService;
    private PersonaVO user;


    @PostConstruct
    public void init() {
        email = new String();
        password = new String();
        userService = new PersonaService();
    }

    public boolean isAuthenticated() throws Exception {
        user = userService.authenticateUser(email, password);
        return user != null;
    }

    public String doLogin() throws Exception {
        if (isAuthenticated()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            return "/index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Correo o clave incorrecto"));
        }
        return "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public PersonaService getUserService() {
        return userService;
    }

    public void setUserService(PersonaService userService) {
        this.userService = userService;
    }

    public PersonaVO getUser() {
        return user;
    }

    public void setUser(PersonaVO user) {
        this.user = user;
    }
}