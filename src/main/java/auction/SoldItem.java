/**
 */
package auction;

import java.util.Date;

public class SoldItem {

	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected static final Date DATE_EDEFAULT = null;

	protected Date date = DATE_EDEFAULT;

	protected static final double PRICE_EDEFAULT = 0.0;

	protected double price = PRICE_EDEFAULT;

	protected User buyer;

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
