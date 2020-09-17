package model;

import java.util.ArrayList;

public class Advertisement {
	
	private String image;
	
	private int revenue;
	
	private int timesDisplayed;
	
	private Equipment eqipment =null;
	
	private Product product = null;
	
	private boolean isProduct = true;
	
	private ArrayList<Pricelist> pricelists;

	public Advertisement() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getTimesDisplayed() {
		return timesDisplayed;
	}

	public void setTimesDisplayed(int timesDisplayed) {
		this.timesDisplayed = timesDisplayed;
	}

	public Equipment getEqipment() {
		return eqipment;
	}

	public void setEqipment(Equipment eqipment) {
		this.eqipment = eqipment;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isProduct() {
		return isProduct;
	}

	public void setProduct(boolean isProduct) {
		this.isProduct = isProduct;
	}
	
	public void calculateRevenue() {
		
		
	}

	public ArrayList<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(ArrayList<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

}
