/**
 */
package auction;

import java.util.List;

public class User {

	protected static final int USER_ID_EDEFAULT = 0;

	protected int user_id = USER_ID_EDEFAULT;

	protected static final String USERNAME_EDEFAULT = null;

	protected String username = USERNAME_EDEFAULT;

	protected static final String PASSWORD_EDEFAULT = null;

	protected String password = PASSWORD_EDEFAULT;

	protected static final String ADDRESS_EDEFAULT = null;

	protected String address = ADDRESS_EDEFAULT;

	protected static final String FAMILY_NAME_EDEFAULT = null;

	protected String familyName = FAMILY_NAME_EDEFAULT;

	protected static final boolean ADMINISTRATOR_EDEFAULT = false;

	protected boolean administrator = ADMINISTRATOR_EDEFAULT;

	protected static final String EMAIL_EDEFAULT = null;

	protected String email = EMAIL_EDEFAULT;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int newUser_id) {
		int oldUser_id = user_id;
		user_id = newUser_id;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;

	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String newFamilyName) {
		String oldFamilyName = familyName;
		familyName = newFamilyName;

	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean newAdministrator) {
		boolean oldAdministrator = administrator;
		administrator = newAdministrator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;

	}

	public void placeBid() {
		// TODO: implement this method

	}

	public List<?> getItemsOnAuction() {
		return null;
		// TODO: implement this method

	}

	public void postNewAuction(Item newItem) {
		// TODO: implement this method

	}

	public void deleteItem(int item_id) {
		// TODO: implement this method

	}

	public void deleteUser(int user_id) {
		// TODO: implement this method

	}

	public void createCategory() {
		// TODO: implement this method

	}

	public void deleteCategory() {
		// TODO: implement this method

	}

	public void sendMessage(Message message) {
		// TODO: implement this method

	}

	public List<?> getSoldItems() {
		return null;
		// TODO: implement this method

	}

	public List<?> getBuyedItems() {
		return null;

	}

} // UserImpl
