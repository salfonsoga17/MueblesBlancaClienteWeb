package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.PersonaService;
import mueblesblanca.vo.PersonaVO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    
    public String recoveryPass() throws Exception{
        try {
            if (email != null) {
                PersonaVO persona = userService.consultByEmail(email);
                if (persona != null){
                    Properties props = new Properties();            
                    props.setProperty("mail.smtp.host", "smtp.gmail.com"); // Nombre del host de correo, es smtp.gmail.com
                    props.setProperty("mail.smtp.starttls.enable", "true"); // TLS si está disponible
                    props.setProperty("mail.smtp.port","587"); // Puerto de gmail para envio de correos
                    props.setProperty("mail.smtp.user", "muebles.blanca.sistema@gmail.com"); // Nombre del usuario
                    props.setProperty("mail.smtp.auth", "true"); // Si requiere o no usuario y password para conectarse.
                    Session session = Session.getDefaultInstance(props);
                    session.setDebug(true);

                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("muebles.blanca.sistema@gmail.com")); // Quien envia el correo                
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(persona.getEmailPersona())); // A quien va dirigido
                    message.setSubject("Recuperar contraseña cliente web");
                    message.setText("Su cuenta ha sido restablecida con exito."
                                  + "<h3><b>correo:</b> " + persona.getEmailPersona() + ".</h3>"
                                  + "<h3><b>contraseña:</b> " + persona.getPasswordPersona() + ".</h3>", "ISO-8859-1", "html");
                    Transport t = session.getTransport("smtp");
                    t.connect("muebles.blanca.sistema@gmail.com","Blanca123");
                    t.sendMessage(message,message.getAllRecipients());
                    t.close(); 
                    return "/login.xhtml?faces-redirect=true";
                } 
            }         
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("messagesApp",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
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
