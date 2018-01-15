package main.java.managedBeans;

import java.io.File;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import main.java.auction.User;
import main.java.sessionBeans.UserSession;

@ManagedBean
public class UserRegister {

	@EJB
	private UserSession userSession;

	protected String username;

	protected String password;

	protected String strasse;
	protected String hausNummer;
	protected String stadt;
	protected String plz;

	protected String familyName;
	protected String firstName;

	protected String email;

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
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

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNummer() {
		return hausNummer;
	}

	public void setHausNummer(String hausNummer) {
		this.hausNummer = hausNummer;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void register() {

		if (userSession != null) {
			User user = new User();
			user.setAdministrator(false);
			user.setAddress(
					this.getStrasse() + " " + this.getHausNummer() + '\n' + this.getPlz() + ", " + this.getStadt());
			user.setFamilyName(this.getFamilyName());
			user.setFirstName(this.getFirstName());
			user.setHausNummer(this.getHausNummer());
			user.setEmail(this.email);
			user.setPassword(this.getPassword());
			user.setStrasse(this.getStrasse());
			user.setUsername(this.getUsername());
			userSession.create(user);
		}

	}
}
