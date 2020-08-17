/***********************************************************************
 * Module:  ProductInfo.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
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
	   private java.util.Date expires;
	   
	   public Product ingredients;

	public ProductInfo(Double quantity, Date expires, Product ingredients) {
		super();
		this.quantity = quantity;
		this.expires = expires;
		this.ingredients = ingredients;
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

	public java.util.Date getExpires() {
		return expires;
	}

	public void setExpires(java.util.Date expires) {
		this.expires = expires;
	}

	public Product getIngredients() {
		return ingredients;
	}

	public void setIngredients(Product ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "ProductInfo [quantity=" + quantity + ", expires=" + expires + ", ingredients=" + ingredients + "]";
	}
	   
	
	   

}