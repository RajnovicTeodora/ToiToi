/***********************************************************************
 * Module:  User.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.*;

/** @pdOid b695a9ee-5175-4cf8-bd76-a37d0f496653 */
public class User extends Akter implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = -6052040809605270549L;
/** @pdOid 6194bb1e-4af0-4ffd-9298-e40de0815c91 */
   private java.util.Date birthday;
   /** @pdOid af39f67c-94c0-4066-827f-000442131c75 */
   private String address;
   /** @pdOid aba2cebe-740c-462f-af27-ce64f7937c63 */
   private String telephone;
   /** @pdOid bbeb87af-bbe0-4ae3-82b9-cecd7507dc63 */
   private int points = 0;
   
   public java.util.List<Product> availableGroceries;
   /** @pdRoleInfo migr=no name=Product assc=association7 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Product> alergies;
   /** @pdRoleInfo migr=no name=Equipment assc=association9 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Equipment> equipment;
   
      
	public User() {
		super();
	}

	public User(String name, String surname, String username, String password, String mail, Date birthday, String address,
		String telephone, int points, List<Product> availableGroceries, List<Product> alergies, List<Equipment> equipment) {
		super(name, surname, username, password, mail);
			this.birthday = birthday;
			this.address = address;
			this.telephone = telephone;
			this.points = points;
			this.availableGroceries = availableGroceries;
			this.alergies = alergies;
			this.equipment = equipment;
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

/** @pdGenerated default getter */
   public java.util.List<Product> getAlergies() {
      if (alergies == null)
         alergies = new java.util.ArrayList<Product>();
      return alergies;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Product> getIteratorAlergies() {
      if (alergies == null)
         alergies = new java.util.ArrayList<Product>();
      return alergies.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAlergies */
   public void setAlergies(java.util.List<Product> newAlergies) {
      removeAllAlergies();
      for (Iterator<Product> iter = newAlergies.iterator(); iter.hasNext();)
         addAlergies((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addAlergies(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.alergies == null)
         this.alergies = new java.util.ArrayList<Product>();
      if (!this.alergies.contains(newProduct))
         this.alergies.add(newProduct);
   }
   
   /** @pdGenerated default remove
     * @param oldProduct */
   public void removeAlergies(Product oldProduct) {
      if (oldProduct == null)
         return;
      if (this.alergies != null)
         if (this.alergies.contains(oldProduct))
            this.alergies.remove(oldProduct);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAlergies() {
      if (alergies != null)
         alergies.clear();
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
   
   /** @pdGenerated default setter
     * @param newEquipment */
   public void setEquipment(java.util.List<Equipment> newEquipment) {
      removeAllEquipment();
      for (Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
         addEquipment((Equipment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEquipment */
   public void addEquipment(Equipment newEquipment) {
      if (newEquipment == null)
         return;
      if (this.equipment == null)
         this.equipment = new java.util.ArrayList<Equipment>();
      if (!this.equipment.contains(newEquipment))
         this.equipment.add(newEquipment);
   }
   
   /** @pdGenerated default remove
     * @param oldEquipment */
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

	@Override
	public String toString() {
		String retval= "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password +
				", mail=" + mail + ", birthday=" + birthday + ", address=" + address + ", telephone=" + telephone + ", points=" + points
				+ ", availableGroceries=" ;
		
		if(availableGroceries != null) {
			for(Product p : availableGroceries) {
				retval += p.getProductID() + ", ";
			}
		}
		
		retval += " alergies=";
		if(alergies != null) {
			for(Product p : alergies) {
				retval += p.getProductID() + ", ";
			}
		}
		
		retval += " equipment=";
		if(equipment !=null) {
			for(Equipment e : equipment) {
				retval += e.getEquipmentID() + ", ";
			}
		}
		retval = retval.substring(0, retval.length()-2) + "]";
				
		return retval;
	}

   
}