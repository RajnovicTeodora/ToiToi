/***********************************************************************
 * Module:  Admin.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Admin
 ***********************************************************************/
package model;

import java.io.Serializable;

public class Admin extends Akter implements Serializable {

	private static final long serialVersionUID = 2784823711938776780L;

	public Admin(String name, String surname, String username, String password, String mail) {
		super(name, surname, username, password, mail);

	}

	public Admin() {
		super();
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

	public String toString() {
		return "Admin [name=" + this.getName() + ", surname=" + this.getSurname() + ", username=" + this.getUsername()
				+ ", password=" + this.getPassword() + ", mail=" + this.getMail() + "]";
	}

}