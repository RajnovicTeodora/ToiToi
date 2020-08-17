/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.*;

public class Recipe implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
    private int likes;
    
    private ArrayList<Taste> taste;
   
    public java.util.List<Tag> tags;
	
    public java.util.List<Equipment> equipment;
	
    public List<Comment> comment;
	
    public List<Product> products;
    
    
   
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
	@Override
	public String toString() {
		return "Recipe [name=" + name + ", description=" + description + ", likes=" + likes + ", taste=" + taste
				+ ", tags=" + tags + ", equipment=" + equipment + ", comment=" + comment + "]";
	}

	public java.util.List<Tag> getTags() {
		if (tags == null)
			tags = new java.util.ArrayList<Tag>();
		return tags;
	}
   
   public Iterator<Tag> getIteratorTags() {
      if (tags == null)
         tags = new java.util.ArrayList<Tag>();
      return tags.iterator();
   }
   
   public void setTastes(java.util.List<Taste> newTastes) {
	      removeAllTastes();
	      for (Iterator<Taste> iter = newTastes.iterator(); iter.hasNext();)
	         addTastes((Taste)iter.next());
	   }
	   
	   public void addTastes(Taste newTaste) {
	      if (newTaste == null)
	         return;
	      if (this.taste == null)
	         this.taste = new java.util.ArrayList<Taste>();
	      if (!this.taste.contains(newTaste))
	         this.taste.add(newTaste);
	   }
	   
	   public void removeTastes(Taste oldTaste) {
	      if (oldTaste == null)
	         return;
	      if (this.taste != null)
	         if (this.taste.contains(oldTaste))
	            this.taste.remove(oldTaste);
	   }
	   
	  public void removeAllTastes() {
	      if (taste != null)
	    	  taste.clear();
	   }
	  
	  public void setProducts(java.util.List<Product> newProducts) {
	      removeAllProducts();
	      for (Iterator<Product> iter = newProducts.iterator(); iter.hasNext();)
	         addProducts((Product)iter.next());
	   }
	   
	   public void addProducts(Product newProduct) {
	      if (newProduct == null)
	         return;
	      if (this.products == null)
	         this.products = new java.util.ArrayList<Product>();
	      if (!this.products.contains(newProduct))
	         this.products.add(newProduct);
	   }
	   
	   public void removeProducts(Product oldProduct) {
	      if (oldProduct == null)
	         return;
	      if (this.products != null)
	         if (this.products.contains(oldProduct))
	            this.products.remove(oldProduct);
	   }
	   
	  public void removeAllProducts() {
	      if (products != null)
	    	  products.clear();
	   }
   
   public void setTags(java.util.List<Tag> newTags) {
      removeAllTags();
      for (Iterator<Tag> iter = newTags.iterator(); iter.hasNext();)
         addTags((Tag)iter.next());
   }
   
   public void addTags(Tag newTag) {
      if (newTag == null)
         return;
      if (this.tags == null)
         this.tags = new java.util.ArrayList<Tag>();
      if (!this.tags.contains(newTag))
         this.tags.add(newTag);
   }
   
   public void removeTags(Tag oldTag) {
      if (oldTag == null)
         return;
      if (this.tags != null)
         if (this.tags.contains(oldTag))
            this.tags.remove(oldTag);
   }
   
  public void removeAllTags() {
      if (tags != null)
         tags.clear();
   }
   public java.util.List<Equipment> getEquipment() {
      if (equipment == null)
         equipment = new java.util.ArrayList<Equipment>();
      return equipment;
   }
   
   public Iterator<Equipment> getIteratorEquipment() {
      if (equipment == null)
         equipment = new java.util.ArrayList<Equipment>();
      return equipment.iterator();
   }
   
   public void setEquipment(List<Equipment> newEquipment) {
      removeAllEquipment();
      for (Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
         addEquipment((Equipment)iter.next());
   }
   
   public void addEquipment(Equipment newEquipment) {
      if (newEquipment == null)
         return;
      if (this.equipment == null)
         this.equipment = new java.util.ArrayList<Equipment>();
      if (!this.equipment.contains(newEquipment))
         this.equipment.add(newEquipment);
   }
   
   public void removeEquipment(Equipment oldEquipment) {
      if (oldEquipment == null)
         return;
      if (this.equipment != null)
         if (this.equipment.contains(oldEquipment))
            this.equipment.remove(oldEquipment);
   }
   
   public void removeAllEquipment() {
      if (equipment != null)
         equipment.clear();
   }
   public java.util.List<Comment> getComment() {
      if (comment == null)
         comment = new java.util.ArrayList<Comment>();
      return comment;
   }
   
   public Iterator<Comment> getIteratorComment() {
      if (comment == null)
         comment = new java.util.ArrayList<Comment>();
      return comment.iterator();
   }
   
   public void setComment(java.util.List<Comment> newComment) {
      removeAllComment();
      for (Iterator<Comment> iter = newComment.iterator(); iter.hasNext();)
         addComment((Comment)iter.next());
   }
   
   public void addComment(Comment newComment) {
      if (newComment == null)
         return;
      if (this.comment == null)
         this.comment = new java.util.ArrayList<Comment>();
      if (!this.comment.contains(newComment))
         this.comment.add(newComment);
   }
   
   public void removeComment(Comment oldComment) {
      if (oldComment == null)
         return;
      if (this.comment != null)
         if (this.comment.contains(oldComment))
            this.comment.remove(oldComment);
   }
   
   public void removeAllComment() {
      if (comment != null)
         comment.clear();
   }

}