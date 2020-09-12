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
public class Moderator extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2408783414252861824L;

	public Moderator() {
		super();
	}

	public Moderator(String name, String surname, String username, String password, String mail, Gender gender,
			LocalDate birthday, String address, String telephone, int points, List<ProductInfo> availableGroceries,
			List<String> alergies, List<Equipment> equipment) {
		super(name, surname, username, password, mail, gender, birthday, address, telephone, points, availableGroceries,
				alergies, equipment);
	}

	@Override
	public List<String> getAlergies() {
		return super.getAlergies();
	}

	@Override
	public Iterator<String> getIteratorAlergies() {
		return super.getIteratorAlergies();
	}

	@Override
	public void setAlergies(List<String> newAlergies) {
		super.setAlergies(newAlergies);
	}

	@Override
	public void addAlergies(String newProduct) {
		super.addAlergies(newProduct);
	}

	@Override
	public void removeAlergies(String oldProduct) {
		super.removeAlergies(oldProduct);
	}

	@Override
	public void removeAllAlergies() {
		super.removeAllAlergies();
	}

	@Override
	public List<Equipment> getEquipment() {
		return super.getEquipment();
	}

	@Override
	public Iterator<Equipment> getIteratorEquipment() {
		return super.getIteratorEquipment();
	}

	@Override
	public void setEquipment(List<Equipment> newEquipment) {

		super.setEquipment(newEquipment);
	}

	@Override
	public void addEquipment(Equipment newEquipment) {

		super.addEquipment(newEquipment);
	}

	@Override
	public void removeEquipment(Equipment oldEquipment) {

		super.removeEquipment(oldEquipment);
	}

	@Override
	public void removeAllEquipment() {

		super.removeAllEquipment();
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

	@Override
	public String toString() {
		String retval = super.toString();
		retval = "Moderator " + retval.substring(5, retval.length());
		return retval;
	}
}