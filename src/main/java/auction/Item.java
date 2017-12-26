
package auction;

import java.util.Date;
import java.util.Locale.Category;

public class Item {

	protected static final int ITEM_ID_EDEFAULT = 0;

	protected int item_id = ITEM_ID_EDEFAULT;

	protected static final double INITIAL_PRICE_EDEFAULT = 0.0;

	protected double initialPrice = INITIAL_PRICE_EDEFAULT;

	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected static final String PHOTO_EDEFAULT = null;

	protected String photo = PHOTO_EDEFAULT;

	protected static final String DESCRIPTION_EDEFAULT = null;

	protected String description = DESCRIPTION_EDEFAULT;

	protected static final boolean AVAILABLE_EDEFAULT = false;

	protected boolean available = AVAILABLE_EDEFAULT;

	protected static final Date START_TIME_EDEFAULT = null;

	protected Date startTime = START_TIME_EDEFAULT;

	protected static final Date END_TIME_EDEFAULT = null;

	protected Date endTime = END_TIME_EDEFAULT;

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
