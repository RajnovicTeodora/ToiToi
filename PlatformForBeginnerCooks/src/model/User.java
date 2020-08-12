/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid b695a9ee-5175-4cf8-bd76-a37d0f496653 */
public class User extends Akter {
   /** @pdOid 6194bb1e-4af0-4ffd-9298-e40de0815c91 */
   private java.util.Date birthday;
   /** @pdOid af39f67c-94c0-4066-827f-000442131c75 */
   private String address;
   /** @pdOid aba2cebe-740c-462f-af27-ce64f7937c63 */
   private String telephone;
   /** @pdOid bbeb87af-bbe0-4ae3-82b9-cecd7507dc63 */
   private int points = 0;
   
   public java.util.Collection association1;
   /** @pdRoleInfo migr=no name=Product assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Product> alergies;
   /** @pdRoleInfo migr=no name=Equipment assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Equipment> equipment;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Product> getAlergies() {
      if (alergies == null)
         alergies = new java.util.HashSet<Product>();
      return alergies;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAlergies() {
      if (alergies == null)
         alergies = new java.util.HashSet<Product>();
      return alergies.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAlergies */
   public void setAlergies(java.util.Collection<Product> newAlergies) {
      removeAllAlergies();
      for (java.util.Iterator iter = newAlergies.iterator(); iter.hasNext();)
         addAlergies((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addAlergies(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.alergies == null)
         this.alergies = new java.util.HashSet<Product>();
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
   public java.util.Collection<Equipment> getEquipment() {
      if (equipment == null)
         equipment = new java.util.HashSet<Equipment>();
      return equipment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEquipment() {
      if (equipment == null)
         equipment = new java.util.HashSet<Equipment>();
      return equipment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEquipment */
   public void setEquipment(java.util.Collection<Equipment> newEquipment) {
      removeAllEquipment();
      for (java.util.Iterator iter = newEquipment.iterator(); iter.hasNext();)
         addEquipment((Equipment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEquipment */
   public void addEquipment(Equipment newEquipment) {
      if (newEquipment == null)
         return;
      if (this.equipment == null)
         this.equipment = new java.util.HashSet<Equipment>();
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

}