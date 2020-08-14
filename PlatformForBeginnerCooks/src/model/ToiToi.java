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
   
   /** @pdRoleInfo migr=no name=Tag assc=association20 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Tag> tags;
   /** @pdRoleInfo migr=no name=Akter assc=association3 coll=java.util.List mult=0..* */
   public java.util.List<Akter> users;
   /** @pdRoleInfo migr=no name=Recipe assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Recipe> recipe;
   /** @pdRoleInfo migr=no name=Product assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Product> products;
   /** @pdRoleInfo migr=no name=Equipment assc=association8 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Equipment> equipment;
   /** @pdRoleInfo migr=no name=CookBook assc=association14 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<CookBook> cookBooks;
   
   
   /** @pdGenerated default getter */
   public java.util.List<Tag> getTags() {
      if (tags == null)
         tags = new java.util.ArrayList<Tag>();
      return tags;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTags() {
      if (tags == null)
         tags = new java.util.ArrayList<Tag>();
      return tags.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTags */
   public void setTags(java.util.List<Tag> newTags) {
      removeAllTags();
      for (java.util.Iterator iter = newTags.iterator(); iter.hasNext();)
         addTags((Tag)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTag */
   public void addTags(Tag newTag) {
      if (newTag == null)
         return;
      if (this.tags == null)
         this.tags = new java.util.ArrayList<Tag>();
      if (!this.tags.contains(newTag))
         this.tags.add(newTag);
   }
   
   /** @pdGenerated default remove
     * @param oldTag */
   public void removeTags(Tag oldTag) {
      if (oldTag == null)
         return;
      if (this.tags != null)
         if (this.tags.contains(oldTag))
            this.tags.remove(oldTag);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTags() {
      if (tags != null)
         tags.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Akter> getUsers() {
      if (users == null)
         users = new java.util.Vector<Akter>();
      return users;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUsers() {
      if (users == null)
         users = new java.util.Vector<Akter>();
      return users.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUsers */
   public void setUsers(java.util.List<Akter> newUsers) {
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
         this.users = new java.util.Vector<Akter>();
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
   public java.util.List<Recipe> getRecipe() {
      if (recipe == null)
         recipe = new java.util.ArrayList<Recipe>();
      return recipe;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRecipe() {
      if (recipe == null)
         recipe = new java.util.ArrayList<Recipe>();
      return recipe.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRecipe */
   public void setRecipe(java.util.List<Recipe> newRecipe) {
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
         this.recipe = new java.util.ArrayList<Recipe>();
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
   public java.util.List<Product> getProducts() {
      if (products == null)
         products = new java.util.ArrayList<Product>();
      return products;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProducts() {
      if (products == null)
         products = new java.util.ArrayList<Product>();
      return products.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProducts */
   public void setProducts(java.util.List<Product> newProducts) {
      removeAllProducts();
      for (java.util.Iterator iter = newProducts.iterator(); iter.hasNext();)
         addProducts((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addProducts(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.products == null)
         this.products = new java.util.ArrayList<Product>();
      if (!this.products.contains(newProduct))
         this.products.add(newProduct);
   }
   
   /** @pdGenerated default remove
     * @param oldProduct */
   public void removeProducts(Product oldProduct) {
      if (oldProduct == null)
         return;
      if (this.products != null)
         if (this.products.contains(oldProduct))
            this.products.remove(oldProduct);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProducts() {
      if (products != null)
         products.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Equipment> getEquipment() {
      if (equipment == null)
         equipment = new java.util.ArrayList<Equipment>();
      return equipment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEquipment() {
      if (equipment == null)
         equipment = new java.util.ArrayList<Equipment>();
      return equipment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEquipment */
   public void setEquipment(java.util.List<Equipment> newEquipment) {
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
   /** @pdGenerated default getter */
   public java.util.List<CookBook> getCookBooks() {
      if (cookBooks == null)
         cookBooks = new java.util.ArrayList<CookBook>();
      return cookBooks;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCookBooks() {
      if (cookBooks == null)
         cookBooks = new java.util.ArrayList<CookBook>();
      return cookBooks.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCookBooks */
   public void setCookBooks(java.util.List<CookBook> newCookBooks) {
      removeAllCookBooks();
      for (java.util.Iterator iter = newCookBooks.iterator(); iter.hasNext();)
         addCookBooks((CookBook)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCookBook */
   public void addCookBooks(CookBook newCookBook) {
      if (newCookBook == null)
         return;
      if (this.cookBooks == null)
         this.cookBooks = new java.util.ArrayList<CookBook>();
      if (!this.cookBooks.contains(newCookBook))
         this.cookBooks.add(newCookBook);
   }
   
   /** @pdGenerated default remove
     * @param oldCookBook */
   public void removeCookBooks(CookBook oldCookBook) {
      if (oldCookBook == null)
         return;
      if (this.cookBooks != null)
         if (this.cookBooks.contains(oldCookBook))
            this.cookBooks.remove(oldCookBook);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCookBooks() {
      if (cookBooks != null)
         cookBooks.clear();
   }

}