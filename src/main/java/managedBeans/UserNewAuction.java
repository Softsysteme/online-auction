package main.java.managedBeans;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import main.java.auction.Item;
import main.java.auction.User;
import main.java.sessionBeans.UserSession;

@ManagedBean
public class UserNewAuction {

	@EJB
	private UserSession userSession;

	protected UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	protected double initialPrice;
	protected String name;
	protected byte[] photo;
	private int auctionDuration;

	public int getAuctionDuration() {
		return auctionDuration;
	}

	public void setAuctionDuration(int auctionDuration) {
		this.auctionDuration = auctionDuration;
	}

	protected String description;

	protected boolean available;

	protected Time startTime;
	protected Time endTime;
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	private String categoryTags = "Audio und Video, Bekleidung, Sport und Freizeit";

	private static String[] categories = { "AudioAndVideo", "Bekleidung", "Buecher", "Fahrzeuge", "FotoAndOptik",
			"Gesundheit", "HaendyAndTelefon", "Lebensmittel", "Musikinstrumente", "Schmuck", "Spielwaren",
			"SportAndFreizeit", "Werkzeuge", "Wohnene", "Sonstiges" };

	public String getCategoriesCSV() {
		StringBuilder b = new StringBuilder();
		for (String s : categories) {
			if (b.length() > 0) {
				b.append(",");
			}
			b.append(s);
		}
		return b.toString();
	}

	public String[] getCategories() {
		return categories;
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public String getCategoryTags() {
		return categoryTags;
	}

	public void setCategoryTags(String categoryTags) {
		this.categoryTags = categoryTags;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	protected User owner;

	@SuppressWarnings("resource")
	public void upload(FileUploadEvent event) {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			file=event.getFile();
			System.out.println(file+"weeeeeeeeeeeeeeee");
			this.setPhoto(file.getContents());
		}
	}

	public void createAuction() {
	
		Class<?> clazz = null;

		try {
			System.out.println(file+"weeeeeeeeeeeeeeee");
			System.out.println("main.java.auction." + this.getCategoryName());
			clazz = Class.forName("main.java.auction." + this.getCategoryName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constructor<?> ctor = null;
		try {
			ctor = clazz.getDeclaredConstructor();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Item item = null;
		try {
			item = (Item) ctor.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Item itemcasted = (Item) item;
		itemcasted.setName(this.getName());
		// ((Item) item).setCategory(this.category);
		itemcasted.setDescription(this.getDescription());
		itemcasted.setInitialPrice(this.getInitialPrice());
		itemcasted.setPhoto(this.getPhoto());
		itemcasted.setAuctionDuration(this.getAuctionDuration());
		itemcasted.setOwner(this.getUserSession().getCurrentuser());
		itemcasted.setCategory(this.userSession.searchCategory(this.getCategoryName()));
		userSession.postNewAuction(itemcasted);
	}

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < categories.length; i++) {
			if (categories[i].contains(query))
				results.add(categories[i]);
		}

		return results;
	}

	public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		UploadedFile file = (UploadedFile) value;
		if (file.getSize() > 1024) {
			msgs.add(new FacesMessage("file too big"));
		}
		if (!"text/plain".equals(file.getContentType())) {
			msgs.add(new FacesMessage("not a text file"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}

}
