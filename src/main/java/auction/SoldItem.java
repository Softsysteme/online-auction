/**
 */
package main.java.auction;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SoldItem {

	protected String name;
	protected Date date;

	protected double price;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_user_id")
	protected User buyer;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_user_id")
	protected User seller;

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		double oldPrice = price;
		price = newPrice;
	}

	public User getBuyer() {

		return buyer;
	}

	public void setBuyer(User newBuyer) {
		User oldBuyer = buyer;
		buyer = newBuyer;

	}

	public User getSeller() {

		return seller;
	}

	public void setSeller(User newSeller) {
		User oldSeller = seller;
		seller = newSeller;

	}

} // SoldItemImpl
