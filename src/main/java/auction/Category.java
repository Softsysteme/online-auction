/**
 */
package auction;

public class Category {

	protected static final int CATEGORY_ID_EDEFAULT = 0;

	protected int category_id = CATEGORY_ID_EDEFAULT;

	protected static final String NAME_EDEFAULT = null;

	protected String name = NAME_EDEFAULT;

	protected Category superCategory;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int newCategory_id) {
		int oldCategory_id = category_id;
		category_id = newCategory_id;

	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String oldName = name;
		name = newName;

	}

	public Category getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(Category newSuperCategory) {
		Category oldSuperCategory = superCategory;
		superCategory = newSuperCategory;

	}

} // CategoryImpl
