/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.ArrayList;

public class ToiToi {
	private String name;

	private String telephone;

	public java.util.List<Tag> tags;

	public java.util.List<Akter> users;

	public java.util.List<Recipe> recipe;

	public java.util.List<Product> products;

	public java.util.List<Equipment> equipment;

	public java.util.List<CookBook> cookBooks;

	public ToiToi(String name, String telephone) {
		super();
		this.name = name;
		this.telephone = telephone;
	}

	public ToiToi() {
		super();
	}

	public java.util.List<Tag> getTags() {
		if (tags == null)
			tags = new java.util.ArrayList<Tag>();
		
		return tags;
	}

	public java.util.Iterator<Tag> getIteratorTags() {
		if (tags == null)
			tags = new java.util.ArrayList<Tag>();
		return tags.iterator();
	}

	public void setTags(java.util.List<Tag> newTags) {
		this.tags = newTags;
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

	public java.util.List<Akter> getUsers() {
		if (users == null)
			users = new java.util.ArrayList<Akter>();
		return users;
	}

	public java.util.Iterator<Akter> getIteratorUsers() {
		if (users == null)
			users = new java.util.ArrayList<Akter>();
		return users.iterator();
	}

	public void setUsers(java.util.List<Akter> newUsers) {
		removeAllUsers();
		for (java.util.Iterator<Akter> iter = newUsers.iterator(); iter.hasNext();)
			addUsers(iter.next());
	}

	public void addUsers(Akter newAkter) {
		if (newAkter == null)
			return;
		if (this.users == null)
			this.users = new java.util.ArrayList<Akter>();
		if (!this.users.contains(newAkter))
			this.users.add(newAkter);
	}

	public void removeUsers(Akter oldAkter) {
		if (oldAkter == null)
			return;
		if (this.users != null)
			if (this.users.contains(oldAkter))
				this.users.remove(oldAkter);
	}
	
	public void replaceUser(Akter newAkter) {
		if (newAkter == null)
			return;
		if (this.users != null) {
			for(Akter a : this.users) {
				if(a.getUsername().equals(newAkter.getUsername())) {
					this.users.remove(a);
					this.users.add(newAkter);
					break;
				}
			}
		}
	}

	public void removeAllUsers() {
		if (users != null)
			users.clear();
	}

	public java.util.List<Recipe> getRecipe() {
		if (recipe == null)
			recipe = new java.util.ArrayList<Recipe>();
		return recipe;
	}

	public java.util.Iterator<Recipe> getIteratorRecipe() {
		if (recipe == null)
			recipe = new java.util.ArrayList<Recipe>();
		return recipe.iterator();
	}

	public void setRecipe(java.util.List<Recipe> newRecipe) {
		removeAllRecipe();
		for (java.util.Iterator<Recipe> iter = newRecipe.iterator(); iter.hasNext();)
			addRecipe(iter.next());
	}

	public void addRecipe(Recipe newRecipe) {
		if (newRecipe == null)
			return;
		if (this.recipe == null)
			this.recipe = new java.util.ArrayList<Recipe>();
		if (!this.recipe.contains(newRecipe))
			this.recipe.add(newRecipe);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldRecipe
	 */
	public void removeRecipe(Recipe oldRecipe) {
		if (oldRecipe == null)
			return;
		if (this.recipe != null)
			for (Recipe recipe : this.recipe) {
				if(oldRecipe.getRecipeID() == recipe.getRecipeID()) {
					this.recipe.remove(recipe);
					break;
				}
			}				
	}
	
	public void replaceRecipe(Recipe oldRecipe, Recipe neww) {
		if (oldRecipe == null)
			return;
		if (this.recipe != null)
			for (Recipe recipe : this.recipe) {
				if(oldRecipe.getRecipeID() == recipe.getRecipeID()) {
					this.recipe.remove(recipe);
					this.recipe.add(neww);
					break;
				}
			}
	}
	
	public ArrayList<Recipe> updateMyRecipes(ArrayList<Recipe>myRecipes) {
		ArrayList<Recipe> retval = new ArrayList<Recipe>();
		for (int i=0; i<myRecipes.size();i++) {
			for (Recipe recipe2 : this.recipe) {
				if(recipe2.getRecipeID()==myRecipes.get(i).getRecipeID()) {
					retval.add(recipe2);
					break;
				}
			}
		}
		return retval;
	}

	/** @pdGenerated default removeAll */
	public void removeAllRecipe() {
		if (recipe != null)
			recipe.clear();
	}

	/** @pdGenerated default getter */
	public java.util.List<Product> getProducts() {
		if (products == null)
			products = new java.util.ArrayList<Product>();
		return products;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<Product> getIteratorProducts() {
		if (products == null)
			products = new java.util.ArrayList<Product>();
		return products.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newProducts
	 */
	public void setProducts(java.util.List<Product> newProducts) {
		removeAllProducts();
		for (java.util.Iterator<Product> iter = newProducts.iterator(); iter.hasNext();)
			addProducts(iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newProduct
	 */
	public void addProducts(Product newProduct) {
		if (newProduct == null)
			return;
		if (this.products == null)
			this.products = new java.util.ArrayList<Product>();
		if (!this.products.contains(newProduct))
			this.products.add(newProduct);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldProduct
	 */
	public void removeProducts(Product oldProduct) {
		if (oldProduct == null)
			return;
		if (this.products != null)
			if (this.products.contains(oldProduct))
				this.products.remove(oldProduct);
	}

	/** @pdGenerated default removeAll */
	public void removeAllProducts() {
		if (products != null)
			products.clear();
	}

	/** @pdGenerated default getter */
	public java.util.List<Equipment> getEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<Equipment> getIteratorEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newEquipment
	 */
	public void setEquipment(java.util.List<Equipment> newEquipment) {
		removeAllEquipment();
		for (java.util.Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
			addEquipment(iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newEquipment
	 */
	public void addEquipment(Equipment newEquipment) {
		if (newEquipment == null)
			return;
		if (this.equipment == null)
			this.equipment = new java.util.ArrayList<Equipment>();
		if (!this.equipment.contains(newEquipment))
			this.equipment.add(newEquipment);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldEquipment
	 */
	public void removeEquipment(Equipment oldEquipment) {
		if (oldEquipment == null)
			return;
		if (this.equipment != null)
			if (this.equipment.contains(oldEquipment))
				this.equipment.remove(oldEquipment);
	}

	/** @pdGenerated default removeAll */
	public void removeAllEquipment() {
		if (equipment != null)
			equipment.clear();
	}

	/** @pdGenerated default getter */
	public java.util.List<CookBook> getCookBooks() {
		if (cookBooks == null)
			cookBooks = new java.util.ArrayList<CookBook>();
		return cookBooks;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<CookBook> getIteratorCookBooks() {
		if (cookBooks == null)
			cookBooks = new java.util.ArrayList<CookBook>();
		return cookBooks.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newCookBooks
	 */
	public void setCookBooks(java.util.List<CookBook> newCookBooks) {
		removeAllCookBooks();
		for (java.util.Iterator<CookBook> iter = newCookBooks.iterator(); iter.hasNext();)
			addCookBooks(iter.next());
	}

	public void addCookBooks(CookBook newCookBook) {
		if (newCookBook == null)
			return;
		if (this.cookBooks == null)
			this.cookBooks = new java.util.ArrayList<CookBook>();
		if (!this.cookBooks.contains(newCookBook))
			this.cookBooks.add(newCookBook);
	}

	public void removeCookBooks(CookBook oldCookBook) {
		if (oldCookBook == null)
			return;
		if (this.cookBooks != null)
			if (this.cookBooks.contains(oldCookBook))
				this.cookBooks.remove(oldCookBook);
	}

	public void removeAllCookBooks() {
		if (cookBooks != null)
			cookBooks.clear();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}