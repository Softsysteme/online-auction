package main.java.auction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int bidId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_user_id")
	protected User bidder;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Item_item_id")
	protected Item item;

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User bidder) {
		this.bidder = bidder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	protected double offer;

}
