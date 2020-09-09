/***********************************************************************
 * Module:  User.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class User extends Akter implements Serializable {
	/**
	 * 
	 */
	// yyyy-mm-dd
	private static final long serialVersionUID = -6052040809605270549L;

	private Gender gender;

	private LocalDate birthday;

	private String address;

	private String telephone;

	private int points = 0;

	public java.util.List<ProductInfo> availableGroceries;

	public java.util.List<Product> alergies;

	public java.util.List<Equipment> equipment;

	public String image;
	
	public ArrayList<Recipe> likedRecipes;
	
	public ArrayList<Recipe> recipes;
	
	public ArrayList<CookBook> cookBooks;
	
	
	public User() {
		super();
	}

	public User(String name, String surname, String username, String password, String mail, Gender gender, LocalDate birthday, String address,
		String telephone, int points, List<ProductInfo> availableGroceries, List<Product> alergies, List<Equipment> equipment) {
		super(name, surname, username, password, mail);
			this.birthday = birthday;
			this.address = address;
			this.telephone = telephone;
			this.points = points;
			this.availableGroceries = availableGroceries;
			this.alergies = alergies;
			this.equipment = equipment;
			this.gender = gender;
	}
	
	public ArrayList<CookBook> getCookBooks() {
		return cookBooks;
	}

	public void setCookBooks(ArrayList<CookBook> cookBooks) {
		this.cookBooks = cookBooks;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String getName() {

		return super.getName();
	}

	@Override
	public void setName(String name) {

		super.setName(name);
	}

	@Override
	public String getSurname() {

		return super.getSurname();
	}

	@Override
	public void setSurname(String surname) {

		super.setSurname(surname);
	}

	@Override
	public String getUsername() {

		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {

		super.setUsername(username);
	}

	@Override
	public String getPassword() {

		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {

		super.setPassword(password);
	}

	@Override
	public String getMail() {

		return super.getMail();
	}

	@Override
	public void setMail(String mail) {

		super.setMail(mail);
	}
	
	
	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public java.util.List<Product> getAlergies() {
		if (alergies == null)
			alergies = new java.util.ArrayList<Product>();
		return alergies;
	}

	public java.util.Iterator<Product> getIteratorAlergies() {
		if (alergies == null)
			alergies = new java.util.ArrayList<Product>();
		return alergies.iterator();
	}

	public void setAlergies(java.util.List<Product> newAlergies) {
		removeAllAlergies();
		for (Iterator<Product> iter = newAlergies.iterator(); iter.hasNext();)
			addAlergies((Product) iter.next());
	}

	public void addAlergies(Product newProduct) {
		if (newProduct == null)
			return;
		if (this.alergies == null)
			this.alergies = new java.util.ArrayList<Product>();
		if (!this.alergies.contains(newProduct))
			this.alergies.add(newProduct);
	}

	public void removeAlergies(Product oldProduct) {
		if (oldProduct == null)
			return;
		if (this.alergies != null)
			if (this.alergies.contains(oldProduct))
				this.alergies.remove(oldProduct);
	}

	public void removeAllAlergies() {
		if (alergies != null)
			alergies.clear();
	}

	public java.util.List<Equipment> getEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment;
	}

	public java.util.Iterator<Equipment> getIteratorEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment.iterator();
	}

	public void setEquipment(java.util.List<Equipment> newEquipment) {
		removeAllEquipment();
		for (Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
			addEquipment((Equipment) iter.next());
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

	@Override
	public String toString() {
		String retval = "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + ", mail=" + mail + ", birthday=" + birthday + ", address=" + address + ", telephone="
				+ telephone + ", points=" + points + ", availableGroceries=";

		if (availableGroceries != null) {
			for (ProductInfo p : availableGroceries) {
				retval += p.getIngredient().getName() + ", ";
			}
		}

		retval += " alergies=";
		if (alergies != null) {
			for (Product p : alergies) {
				retval += p.getProductID() + ", ";
			}
		}

		retval += " equipment=";
		if (equipment != null) {
			for (Equipment e : equipment) {
				retval += e.getEquipmentID() + ", ";
			}
		}
		retval += " recipes=";
		if (recipes != null) {
			for (Recipe e : recipes) {
				retval += e.getRecipeID() + ", ";
			}
		}
		retval += " cookbooks=";
		if (recipes != null) {
			for (CookBook e : cookBooks) {
				retval += e.getName() + ", ";
			}
		}
		retval = retval.substring(0, retval.length() - 2) + "]";

		return retval;
	}

	public ArrayList<Recipe> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(ArrayList<Recipe> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

   
}