/***********************************************************************
 * Module:  Admin.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Admin
 ***********************************************************************/
package model;
import java.io.Serializable;
import java.util.*;

/** @pdOid 154dd9ea-4a7f-448f-a623-0820d023ea8c */
public class Admin extends Akter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2784823711938776780L;

	public Admin(String name, String surname, String username, String password, String mail) {
		super(name, surname, username, password, mail);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
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

	public String toString() {
		return "Admin [name=" + this.getName() + ", surname=" + this.getSurname() + ", username=" + this.getUsername() + ", password=" + this.getPassword()
				+ ", mail=" + this.getMail() + "]";
	}
	
	
}