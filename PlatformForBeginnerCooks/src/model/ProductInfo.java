/***********************************************************************
 * Module:  ProductInfo.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/** @pdOid 61c4ae9a-2e7d-44ab-960a-23ec0093c458 */
public class ProductInfo implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 7563701281802226438L;
	/** @pdOid f04e608d-14fd-4302-8d92-8fd48a803451 */
	   private java.lang.Double quantity;
	   /** @pdOid c2201182-f1c3-4dea-a43a-022dfc74adb4 */
	   private LocalDate expires;
	   
	   public Product ingredient;

	public ProductInfo(Double quantity, LocalDate expires, Product ingredients) {
		super();
		this.quantity = quantity;
		this.expires = expires;
		this.ingredient = ingredients;
	}

	public ProductInfo() {
		super();
	}

	public java.lang.Double getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Double quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpires() {
		return expires;
	}

	public void setExpires(LocalDate expires) {
		this.expires = expires;
	}

	public Product getIngredient() {
		return ingredient;
	}

	public void setIngredient(Product ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "ProductInfo [quantity=" + quantity + ", expires=" + expires + ", ingredient=" + ingredient + "]";
	}
	   
	
	   

}