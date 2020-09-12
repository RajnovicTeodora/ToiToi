/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;

public class NeededQuantity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.Double quantity;

	private boolean essential = false;

	private Product ingredient;

	public NeededQuantity() {
		super();
	}

	public NeededQuantity(Double quantity, boolean essential, Product ingredient) {
		super();
		this.quantity = quantity;
		this.essential = essential;
		this.ingredient = ingredient;

	}

	public java.lang.Double getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Double quantity) {
		this.quantity = quantity;
	}

	public boolean isEssential() {
		return essential;
	}

	public void setEssential(boolean essential) {
		this.essential = essential;
	}

	public Product getIngredient() {
		return ingredient;
	}

	public void setIngredient(Product ingredient) {
		this.ingredient = ingredient;
	}

}