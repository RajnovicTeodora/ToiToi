package model;

import java.time.LocalDate;

public class Pricelist {
	
	private LocalDate validityDate;
	
	private int price;

	public Pricelist() {
		super();
	}

	public LocalDate getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
