package main.java.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import main.java.sessionBeans.UserSession;

@ManagedBean
public class UserLogin {

	@EJB
	private UserSession userSession;
	private String username;

	private String password;
	private boolean loggedIn = false;

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent event) {
		FacesMessage message = null;

		// if (username != null && password != null && userSession != null
		// && username.equals(userSession.logOnPerUserName(username,
		// password).getUsername())) {
		if (username != null && password != null && username.equals("admin") && password.equals("admin")) {
			this.setLoggedIn(true);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Willkommen", username);
		} else {
			this.setLoggedIn(false);
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Fehler",
					"Benutzername  oder Passwort falsch");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		// PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
	}
}