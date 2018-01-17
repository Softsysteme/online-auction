package main.test;

import org.junit.Assert;
import org.junit.Test;

import javax.ejb.EJB;

import main.java.auction.User;
import main.java.sessionBeans.UserSession;

public class ConnectionTests {

	@EJB
	private UserSession userSession;

	@Test
	public void UserAreCorrectlyInsertedInTheDataBase() {
		User user = new User();
		user.setAdministrator(false);
		user.setAddress("Emil-Figge-str." + " " + 3 + '\n' + 44227 + ", " + "Dortmund");
		user.setFamilyName("Müller");
		user.setFirstName("Alexander");
		user.setHausNummer("3");
		user.setEmail("poumaiori@yahoo.fr");
		user.setPassword("password");
		user.setStrasse("Emil-Figge-str.");
		user.setUsername("user");
		userSession.create(user);
		
		Assert.assertEquals(userSession.logOnPerUserName("user","password"),user);
	}

}
