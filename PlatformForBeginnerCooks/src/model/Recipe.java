/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 66500644-528a-40c5-a193-1d78386a3686 */
public class Recipe {
   /** @pdOid 9dfa473f-f35f-4f46-986d-b10ac6b20ea9 */
   private String name;
   /** @pdOid 2f7f2510-8ad5-41e7-9c5f-f88b5c92dda0 */
   private String description;
   /** @pdOid 18ba5f08-42cf-458c-b39d-95bb061fd99d */
   private int likes;
   /** @pdOid 9c2eafe3-83c6-4307-b9c4-4c5f19c77a61 */
   private ArrayList<Cuisine> cuisine;
   /** @pdOid aa7acd76-c9fb-45ab-8bd2-d03fdb7bc5c2 */
   private ArrayList<Diet> diet;
   /** @pdOid 08c0ef64-31ff-4a4b-9e0d-a3121bf1b34e */
   private ArrayList<Taste> taste;
   
   /** @pdRoleInfo migr=no name=Equipment assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Equipment> equipment;
   /** @pdRoleInfo migr=no name=Comment assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Comment> comment;
   public java.util.Collection association2;
   
   
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
   /** @pdGenerated default getter */
   public java.util.Collection<Comment> getComment() {
      if (comment == null)
         comment = new java.util.HashSet<Comment>();
      return comment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorComment() {
      if (comment == null)
         comment = new java.util.HashSet<Comment>();
      return comment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newComment */
   public void setComment(java.util.Collection<Comment> newComment) {
      removeAllComment();
      for (java.util.Iterator iter = newComment.iterator(); iter.hasNext();)
         addComment((Comment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newComment */
   public void addComment(Comment newComment) {
      if (newComment == null)
         return;
      if (this.comment == null)
         this.comment = new java.util.HashSet<Comment>();
      if (!this.comment.contains(newComment))
         this.comment.add(newComment);
   }
   
   /** @pdGenerated default remove
     * @param oldComment */
   public void removeComment(Comment oldComment) {
      if (oldComment == null)
         return;
      if (this.comment != null)
         if (this.comment.contains(oldComment))
            this.comment.remove(oldComment);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllComment() {
      if (comment != null)
         comment.clear();
   }

}