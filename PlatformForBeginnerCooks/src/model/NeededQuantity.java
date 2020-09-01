/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.*;

/** @pdOid f7253fd0-ad2c-4678-89d0-b2139878e4bf */
public class NeededQuantity implements Serializable{
   /** @pdOid e1cf8aab-b7a7-4ce7-91a1-d2165af7a2df */
   private java.lang.Double quantity;
   /** @pdOid ff681ad1-e216-4311-89a3-5aa7ac6094d7 */
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