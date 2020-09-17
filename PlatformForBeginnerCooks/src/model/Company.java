package model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private String name;
	
	private String adress;
	
	private List<Equipment> equipment;
	
	private List<Product> products;
	
	private ArrayList<Pricelist> pricelists;
	
	private ArrayList<Advertisement> advertisements;

	public Company() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ArrayList<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(ArrayList<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

	public ArrayList<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(ArrayList<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	
	

}
