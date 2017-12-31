package main.java.managedBeans;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;

import main.java.auction.Category;
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
	protected String photo;

	protected String description;

	protected boolean available;

	protected Time startTime;
	protected Time endTime;

	protected Category category;

	public UserSession getUserSession() {
		return userSession;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	protected User owner;

	@SuppressWarnings("resource")
	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			try {
				this.setPhoto(new Scanner(file.getInputstream()).useDelimiter("\\A").next());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void createAuction() {
		Class<?> clazz = null;
		Object item = null;
		try {
			clazz = Class.forName("main.java.sessionBeans" + this.getCategory());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			item = clazz.newInstance();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((Item) item).setName(this.getName());
		((Item) item).setCategory(this.category);
		((Item) item).setDescription(this.getDescription());
		((Item) item).setInitialPrice(this.getInitialPrice());
		((Item) item).setPhoto(this.getPhoto());

		userSession.postNewAuction((Item) item);
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
