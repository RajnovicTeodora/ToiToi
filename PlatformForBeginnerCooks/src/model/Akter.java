/***********************************************************************
 * Module:  Akter.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Akter
 ***********************************************************************/
package model;
import java.io.Serializable;
import java.util.*;

/** @pdOid 9be181c7-00da-4267-b5a6-afe96046afa0 */
public class Akter implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = -2395483226508813675L;
/** @pdOid be4a80a9-b656-4a13-a14d-2cc51b12938e */
   protected String name;
   /** @pdOid a07764ec-0cad-4fa0-90b1-c59cbba46ea5 */
   protected String surname;
   /** @pdOid ad965317-dcf9-44bd-9b5a-3500cd4da6d7 */
   protected String username;
   /** @pdOid d89806fd-9cb8-43bf-a67f-80c3d7ca7a39 */
   protected String password;
   /** @pdOid b10c4b15-80b1-4689-9173-c894fa260644 */
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