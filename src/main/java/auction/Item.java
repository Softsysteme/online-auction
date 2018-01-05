
package main.java.auction;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Entity
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int item_id;
	protected double initialPrice;
	protected String name;
	protected String photo;

	protected String description;

	protected boolean available;

	protected Time startTime;
	protected Time endTime;
	
	protected int auctionDuration;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable=false)
	protected Category category;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	protected User owner;

	public int getAuctionDuration() {
		return auctionDuration;
	}

	public void setAuctionDuration(int auctionDuration) {
		this.auctionDuration = auctionDuration;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int newItem_id) {
		item_id = newItem_id;

	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double newInitialPrice) {
		initialPrice = newInitialPrice;

	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;

	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String newPhoto) {
		photo = newPhoto;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean newAvailable) {
		available = newAvailable;

	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Time newStartTime) {
		startTime = newStartTime;

	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Time newEndTime) {
		endTime = newEndTime;

	}

	public Category getCategory() {

		return category;
	}

	public Category basicGetCategory() {
		return category;
	}

	public void setCategory(Category newCategory) {
		category = newCategory;
	}

} // ItemImpl
