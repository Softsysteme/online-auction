
package main.java.auction;

import java.util.Date;
import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	protected Date startTime;
	protected Date endTime;

	protected Category category;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int newItem_id) {
		int oldItem_id = item_id;
		item_id = newItem_id;

	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double newInitialPrice) {
		double oldInitialPrice = initialPrice;
		initialPrice = newInitialPrice;

	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;

	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String newPhoto) {
		String oldPhoto = photo;
		photo = newPhoto;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean newAvailable) {
		boolean oldAvailable = available;
		available = newAvailable;

	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date newStartTime) {
		Date oldStartTime = startTime;
		startTime = newStartTime;

	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date newEndTime) {
		Date oldEndTime = endTime;
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
