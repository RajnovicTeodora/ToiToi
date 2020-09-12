/***********************************************************************
 * Module:  Akter.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Akter
 ***********************************************************************/
package model;

import java.io.Serializable;

public abstract class Akter implements Serializable {

	private static final long serialVersionUID = -2395483226508813675L;

	protected String name;

	protected String surname;

	protected String username;

	protected String password;

	protected String mail;

	public Akter() {
		super();
	}

	public Akter(String name, String surname, String username, String password, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Akter [name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password
				+ ", mail=" + mail + "]";
	}

}