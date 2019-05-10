package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.PersonaService;
import mueblesblanca.vo.PersonaVO;

/**
 *
 * @author Alexis Holguin
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

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
        try {
            if (isAuthenticated()) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
                return "/index.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("messagesApp",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return "";
    }

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
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
