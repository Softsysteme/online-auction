package main.java.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.auction.Item;
import main.java.sessionBeans.UserSession;

@ManagedBean
@ViewScoped
public class UserSelectCategory implements Serializable {

	private static final long serialVersionUID = 4306736592585602459L;
	@EJB
	private UserSession userSession;

	@PostConstruct
	public void init() {
		av = userSession.getItemsOfCategory("Audion Und Video");
		bkl = userSession.getItemsOfCategory("Bekleidung");
		bcher = userSession.getItemsOfCategory("Bücher");
		fahrzeuge = userSession.getItemsOfCategory("Fahrzeuge");
		fopt = userSession.getItemsOfCategory("Foto Und Optik");
		gesundheit = userSession.getItemsOfCategory("Gesundheit");
		haendTel = userSession.getItemsOfCategory("Händy Und Telefon");
		lbsmittel = userSession.getItemsOfCategory("Lebensmittel");
		msik = userSession.getItemsOfCategory("Musikinstrumente");
		schmuck = userSession.getItemsOfCategory("Schmuck");
		spielwaren = userSession.getItemsOfCategory("Spielwaren");
		sprtFrzeit = userSession.getItemsOfCategory("Sport Und Freizeit");
		wrkzge = userSession.getItemsOfCategory("Werkzeuge");
		whnen = userSession.getItemsOfCategory("Wohnen");
		sonstiges = userSession.getItemsOfCategory("Sonstiges");
	}

	private List<Item> av;
	private List<Item> bkl;
	private List<Item> bcher;
	private List<Item> fahrzeuge;
	private List<Item> fopt;
	private List<Item> gesundheit;
	private List<Item> haendTel;
	private List<Item> lbsmittel;
	private List<Item> msik;
	private List<Item> schmuck;
	private List<Item> spielwaren;
	private List<Item> sprtFrzeit;
	private List<Item> wrkzge;
	private List<Item> whnen;
	private List<Item> sonstiges;
	List<Item> items;
	private Item selectedItem;

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getAv() {
		return av;
	}

	public void setAv(List<Item> av) {
		this.av = av;
	}

	public List<Item> getBkl() {
		return bkl;
	}

	public void setBkl(List<Item> bkl) {
		this.bkl = bkl;
	}

	public List<Item> getBcher() {
		return bcher;
	}

	public void setBcher(List<Item> bcher) {
		this.bcher = bcher;
	}

	public List<Item> getFahrzeuge() {
		return fahrzeuge;
	}

	public void setFahrzeuge(List<Item> fahrzeuge) {
		this.fahrzeuge = fahrzeuge;
	}

	public List<Item> getFopt() {
		return fopt;
	}

	public void setFopt(List<Item> fopt) {
		this.fopt = fopt;
	}

	public List<Item> getGesundheit() {
		return gesundheit;
	}

	public void setGesundheit(List<Item> gesundheit) {
		this.gesundheit = gesundheit;
	}

	public List<Item> getHaendTel() {
		return haendTel;
	}

	public void setHaendTel(List<Item> haendTel) {
		this.haendTel = haendTel;
	}

	public List<Item> getLbsmittel() {
		return lbsmittel;
	}

	public void setLbsmittel(List<Item> lbsmittel) {
		this.lbsmittel = lbsmittel;
	}

	public List<Item> getMsik() {
		return msik;
	}

	public void setMsik(List<Item> msik) {
		this.msik = msik;
	}

	public List<Item> getSchmuck() {
		return schmuck;
	}

	public void setSchmuck(ArrayList<Item> schmuck) {
		this.schmuck = schmuck;
	}

	public List<Item> getSpielwaren() {
		return spielwaren;
	}

	public void setSpielwaren(List<Item> spielwaren) {
		this.spielwaren = spielwaren;
	}

	public List<Item> getSprtFrzeit() {
		return sprtFrzeit;
	}

	public void setSprtFrzeit(List<Item> sprtFrzeit) {
		this.sprtFrzeit = sprtFrzeit;
	}

	public List<Item> getWrkzge() {
		return wrkzge;
	}

	public void setWrkzge(List<Item> wrkzge) {
		this.wrkzge = wrkzge;
	}

	public List<Item> getWhnen() {
		return whnen;
	}

	public void setWhnen(List<Item> whnen) {
		this.whnen = whnen;
	}

	public List<Item> getSonstiges() {
		return sonstiges;
	}

	public void setSonstiges(List<Item> sonstiges) {
		this.sonstiges = sonstiges;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
