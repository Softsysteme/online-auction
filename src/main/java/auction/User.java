/**
 */
package main.java.auction;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int user_id;

	protected String username;

	protected String password;

	protected String strasse;
	protected String hausNummer;
	protected String stadt;
	protected String plz;

	protected String familyName;

	@OneToMany(mappedBy = "owner")
	protected List<Item> ownedItems;
	
	@OneToMany(mappedBy = "to")
	protected List<Message> sentMessages;
	
	@OneToMany(mappedBy = "from")
	protected List<Message> receivedMessages;

	public List<Item> getOwnedItems() {
		return ownedItems;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public void setOwnedItems(List<Item> ownedItems) {
		this.ownedItems = ownedItems;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String firstName;

	protected String email;

	protected boolean administrator;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int newUser_id) {

		user_id = newUser_id;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String newUsername) {
		username = newUsername;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {

		password = newPassword;

	}

	public String getAddress() {
		return strasse;
	}

	public void setAddress(String newAddress) {

		strasse = newAddress;

	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String newFamilyName) {

		familyName = newFamilyName;

	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean newAdministrator) {

		administrator = newAdministrator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {

		email = newEmail;

	}

} // UserImpl
