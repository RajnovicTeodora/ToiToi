/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 930ff152-8efa-4b95-8f5d-87b8650c1ff8 */
public class ToiToi {
   /** @pdOid ed03089b-0831-4721-89cb-715a95f5cef3 */
   private String name;
   /** @pdOid abc56e73-0c3b-4361-96bb-de05ce0919f8 */
   private String telephone;
   
   /** @pdRoleInfo migr=no name=Akter assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Akter> users;
   /** @pdRoleInfo migr=no name=Recipe assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Recipe> recipe;
   /** @pdRoleInfo migr=no name=Product assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Product> product;
   /** @pdRoleInfo migr=no name=Equipment assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Equipment> equipment;
   /** @pdRoleInfo migr=no name=CookBook assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<CookBook> cookBook;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Akter> getUsers() {
      if (users == null)
         users = new java.util.HashSet<Akter>();
      return users;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUsers() {
      if (users == null)
         users = new java.util.HashSet<Akter>();
      return users.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUsers */
   public void setUsers(java.util.Collection<Akter> newUsers) {
      removeAllUsers();
      for (java.util.Iterator iter = newUsers.iterator(); iter.hasNext();)
         addUsers((Akter)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAkter */
   public void addUsers(Akter newAkter) {
      if (newAkter == null)
         return;
      if (this.users == null)
         this.users = new java.util.HashSet<Akter>();
      if (!this.users.contains(newAkter))
         this.users.add(newAkter);
   }
   
   /** @pdGenerated default remove
     * @param oldAkter */
   public void removeUsers(Akter oldAkter) {
      if (oldAkter == null)
         return;
      if (this.users != null)
         if (this.users.contains(oldAkter))
            this.users.remove(oldAkter);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUsers() {
      if (users != null)
         users.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Recipe> getRecipe() {
      if (recipe == null)
         recipe = new java.util.HashSet<Recipe>();
      return recipe;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRecipe() {
      if (recipe == null)
         recipe = new java.util.HashSet<Recipe>();
      return recipe.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRecipe */
   public void setRecipe(java.util.Collection<Recipe> newRecipe) {
      removeAllRecipe();
      for (java.util.Iterator iter = newRecipe.iterator(); iter.hasNext();)
         addRecipe((Recipe)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRecipe */
   public void addRecipe(Recipe newRecipe) {
      if (newRecipe == null)
         return;
      if (this.recipe == null)
         this.recipe = new java.util.HashSet<Recipe>();
      if (!this.recipe.contains(newRecipe))
         this.recipe.add(newRecipe);
   }
   
   /** @pdGenerated default remove
     * @param oldRecipe */
   public void removeRecipe(Recipe oldRecipe) {
      if (oldRecipe == null)
         return;
      if (this.recipe != null)
         if (this.recipe.contains(oldRecipe))
            this.recipe.remove(oldRecipe);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRecipe() {
      if (recipe != null)
         recipe.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Product> getProduct() {
      if (product == null)
         product = new java.util.HashSet<Product>();
      return product;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProduct() {
      if (product == null)
         product = new java.util.HashSet<Product>();
      return product.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProduct */
   public void setProduct(java.util.Collection<Product> newProduct) {
      removeAllProduct();
      for (java.util.Iterator iter = newProduct.iterator(); iter.hasNext();)
         addProduct((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addProduct(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.product == null)
         this.product = new java.util.HashSet<Product>();
      if (!this.product.contains(newProduct))
         this.product.add(newProduct);
   }
   
   /** @pdGenerated default remove
     * @param oldProduct */
   public void removeProduct(Product oldProduct) {
      if (oldProduct == null)
         return;
      if (this.product != null)
         if (this.product.contains(oldProduct))
            this.product.remove(oldProduct);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProduct() {
      if (product != null)
         product.clear();
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
   /** @pdGenerated default getter */
   public java.util.Collection<CookBook> getCookBook() {
      if (cookBook == null)
         cookBook = new java.util.HashSet<CookBook>();
      return cookBook;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCookBook() {
      if (cookBook == null)
         cookBook = new java.util.HashSet<CookBook>();
      return cookBook.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCookBook */
   public void setCookBook(java.util.Collection<CookBook> newCookBook) {
      removeAllCookBook();
      for (java.util.Iterator iter = newCookBook.iterator(); iter.hasNext();)
         addCookBook((CookBook)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCookBook */
   public void addCookBook(CookBook newCookBook) {
      if (newCookBook == null)
         return;
      if (this.cookBook == null)
         this.cookBook = new java.util.HashSet<CookBook>();
      if (!this.cookBook.contains(newCookBook))
         this.cookBook.add(newCookBook);
   }
   
   /** @pdGenerated default remove
     * @param oldCookBook */
   public void removeCookBook(CookBook oldCookBook) {
      if (oldCookBook == null)
         return;
      if (this.cookBook != null)
         if (this.cookBook.contains(oldCookBook))
            this.cookBook.remove(oldCookBook);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCookBook() {
      if (cookBook != null)
         cookBook.clear();
   }

}