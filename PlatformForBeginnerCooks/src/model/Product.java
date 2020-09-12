/***********************************************************************
 * Module:  Product.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.*;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String producedBy;

	private int productID;

	public java.util.List<Product> part;

	public Product() {
		super();
	}

	public Product(String name, String producedBy, int productID) {
		super();
		this.name = name;
		this.producedBy = producedBy;
		this.productID = productID;
	}

	public Product(String name, String producedBy, int productID, List<Product> part) {
		super();
		this.name = name;
		this.producedBy = producedBy;
		this.productID = productID;
		this.part = part;
	}
	

	public Product(String name, String producedBy, List<Product> part) {
		super();
		this.name = name;
		this.producedBy = producedBy;
		this.part = part;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public java.util.List<Product> getPart() {
		if (part == null)
			part = new java.util.ArrayList<Product>();
		return part;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorPart() {
		if (part == null)
			part = new java.util.ArrayList<Product>();
		return part.iterator();
	}

	public void setPart(java.util.List<Product> newPart) {
		removeAllPart();
		for (Iterator<Product> iter = newPart.iterator(); iter.hasNext();)
			addPart((Product) iter.next());
	}

	public void addPart(Product newProduct) {
		if (newProduct == null)
			return;
		if (this.part == null)
			this.part = new java.util.ArrayList<Product>();
		if (!this.part.contains(newProduct))
			this.part.add(newProduct);
	}

	public void removePart(Product oldProduct) {
		if (oldProduct == null)
			return;
		if (this.part != null)
			if (this.part.contains(oldProduct))
				this.part.remove(oldProduct);
	}

	public void removeAllPart() {
		if (part != null)
			part.clear();
	}

	@Override
	public String toString() {
		String first = "Product [productID=" + productID + " name=" + name + ", producedBy=" + producedBy + ", part=";
		if (part != null) {
			for (Product product : part) {
				first += product.getProductID() + ", ";
			}
			first = first.substring(0, first.length()-2);
		}
		first += "]";
		return first;
	}

}