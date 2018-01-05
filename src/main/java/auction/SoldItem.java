/**
 */
package main.java.auction;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SoldItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected Date date;

	protected double price;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable=false)
	protected User buyer;

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable=false)
	protected Item item;

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date newDate) {
		date = newDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public User getBuyer() {

		return buyer;
	}

	public void setBuyer(User newBuyer) {
		buyer = newBuyer;

	}

} // SoldItemImpl
