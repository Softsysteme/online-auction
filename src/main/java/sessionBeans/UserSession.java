package main.java.sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.auction.Bid;
import main.java.auction.Category;
import main.java.auction.Item;
import main.java.auction.Message;
import main.java.auction.SoldItem;
import main.java.auction.User;
import main.java.exceptions.DAOException;

@Stateless
public class UserSession {
	private static final String SELECT_PER_EMAIL = "SELECT u FROM User WHERE u.email=:email AND u.password=:password";
	private static final String SELECT_PER_USERNAME = "from User u where  u.username=:username AND u.password=:password";
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_USERNAME = "username";
	private User currentUser;

	public User getCurrentuser() {
		return currentUser;
	}

	public void setCurrentuser(User user) {
		this.currentUser = user;
	}

	// Entity Manager injection
	@PersistenceContext(unitName = "online_auktion_PU")
	private EntityManager em;

	// register new user
	public void create(main.java.auction.User user) throws DAOException {
		try {
			em.persist(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	// find a user with his E-mail adress
	public User logOnPerEmail(String email, String password) throws DAOException {
		User user = null;
		Query requete = em.createQuery(SELECT_PER_EMAIL);
		requete.setParameter(PARAM_EMAIL, email);
		requete.setParameter("password", password);
		try {
			user = (User) requete.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return user;
	}

	// find a user with his user name
	public User logOnPerUserName(String username, String password) throws DAOException {
		User user = null;
		Query request = em.createQuery(SELECT_PER_USERNAME);
		request.setParameter("username", username);
		request.setParameter("password", password);
		try {
			user = (User) request.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		this.setCurrentuser(user);
		return user;
	}

	public void placeBid() {
		// TODO: implement this method

	}

	// search for a Item
	public List<Item> searachItem(String searchWord) {
		List<Item> result = new ArrayList<Item>();
		Query request = em.createQuery("SELECT i FROM Item WHERE i.name=:searchWord");
		request.setParameter("searchWord", searchWord);
		try {
			result.add((Item) request.getResultList());
		} catch (NoResultException e) {
			Query request2 = em
					.createQuery("SELECT i FROM Item WHERE i.owner IN (SELECT u FROM User WHERE u.stadt=:searchWord");
			request2.setParameter("searchWord", searchWord);
			try {
				result.add((Item) request.getResultList());
			} catch (NoResultException e2) {
				Query request3 = em.createQuery(
						"SELECT i FROM Item WHERE i.category  IN (SELECT c FROM Category WHERE u.name=:searchWord");
				request3.setParameter("searchWord", searchWord);
				try {
					result.add((Item) request.getResultList());
				} catch (NoResultException e3) {
					return null;
				}
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	public Category searchCategory(String name) {
		Category category = null;
		Query request = em.createQuery("from Category c where  c.name=:cname");
		request.setParameter("cname", name);
		try {
			category = (Category) request.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}

		return category;
	}

	public void placeBid(Bid bid) {
		try {
			em.persist(bid);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void postNewAuction(Item item) {
		try {
			em.persist(item);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void deleteItem(Item item) {
		try {
			em.remove(item);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void deleteUser(User user) {
		try {
			em.remove(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void createCategory(Category newCategory) {
		try {
			em.persist(newCategory);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void deleteCategory(Category category) {
		try {
			em.remove(category);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public void sendMessage(Message message) {
		try {
			em.persist(message);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public List<SoldItem> getSoldItems(User user) {
		List<SoldItem> result = new ArrayList<SoldItem>();
		Query request = em
				.createQuery("SELECT s FROM SoldItem WHERE s.item IN (SELECT i FROM Item WHERE i.owner =:user");
		request.setParameter("user", user);
		try {
			result.add((SoldItem) request.getResultList());
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	public List<?> getBuyedItems(User user) {
		List<SoldItem> result = new ArrayList<SoldItem>();
		Query request = em.createQuery("SELECT s FROM SoldItem WHERE s.buyer=:user");
		request.setParameter("user", user);
		try {
			result.add((SoldItem) request.getResultList());
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;

	}

}
