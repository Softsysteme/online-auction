/**
 */
package main.java.auction;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int category_id;

	protected String name;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Category_category_id")
	protected Category superCategory;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "Item_item_id")
	protected List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

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
