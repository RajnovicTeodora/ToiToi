/***********************************************************************
 * Module:  Moderator.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/** @pdOid a478c37f-e225-412d-9b63-7e0bf797efba */
public class Moderator extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2408783414252861824L;


	public Moderator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moderator(String name, String surname, String username, String password, String mail, Gender gender, LocalDate birthday,
			String address, String telephone, int points, List<ProductInfo> availableGroceries, List<String> alergies,
			List<Equipment> equipment) {
		super(name, surname, username, password, mail, gender, birthday, address, telephone, points, availableGroceries, alergies,
				equipment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> getAlergies() {
		// TODO Auto-generated method stub
		return super.getAlergies();
	}

	@Override
	public Iterator<String> getIteratorAlergies() {
		// TODO Auto-generated method stub
		return super.getIteratorAlergies();
	}

	@Override
	public void setAlergies(List<String> newAlergies) {
		// TODO Auto-generated method stub
		super.setAlergies(newAlergies);
	}

	@Override
	public void addAlergies(String newProduct) {
		// TODO Auto-generated method stub
		super.addAlergies(newProduct);
	}

	@Override
	public void removeAlergies(Product oldProduct) {
		// TODO Auto-generated method stub
		super.removeAlergies(oldProduct);
	}

	@Override
	public void removeAllAlergies() {
		// TODO Auto-generated method stub
		super.removeAllAlergies();
	}

	@Override
	public List<Equipment> getEquipment() {
		// TODO Auto-generated method stub
		return super.getEquipment();
	}

	@Override
	public Iterator<Equipment> getIteratorEquipment() {
		// TODO Auto-generated method stub
		return super.getIteratorEquipment();
	}

	@Override
	public void setEquipment(List<Equipment> newEquipment) {
		// TODO Auto-generated method stub
		super.setEquipment(newEquipment);
	}

	@Override
	public void addEquipment(Equipment newEquipment) {
		// TODO Auto-generated method stub
		super.addEquipment(newEquipment);
	}

	@Override
	public void removeEquipment(Equipment oldEquipment) {
		// TODO Auto-generated method stub
		super.removeEquipment(oldEquipment);
	}

	@Override
	public void removeAllEquipment() {
		// TODO Auto-generated method stub
		super.removeAllEquipment();
	}

	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return super.getSurname();
	}

	@Override
	public void setSurname(String surname) {
		// TODO Auto-generated method stub
		super.setSurname(surname);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getMail() {
		// TODO Auto-generated method stub
		return super.getMail();
	}

	@Override
	public void setMail(String mail) {
		// TODO Auto-generated method stub
		super.setMail(mail);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String retval =  super.toString();
		retval = "Moderator " + retval.substring(5, retval.length());
		return retval;
	}
}