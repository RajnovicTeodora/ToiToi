/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid ab715511-5db6-432b-a943-519e38801cb9 */
public class CookBook {
   /** @pdOid 558b23aa-b8b8-47d9-96dd-c77148f1461d */
   private String name;
   /** @pdOid 9180ce5a-49a3-433a-b1fc-5f4800bd1f16 */
   private java.util.Date date;
   /** @pdOid 00191b62-4c74-4a1c-94bc-69db7c6c0b0f */
   private int likes;
   
   /** @pdRoleInfo migr=no name=Comment assc=association12 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Comment> comments;
   /** @pdRoleInfo migr=no name=Recipe assc=association15 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Aggregation */
   public java.util.List<Recipe> recipes;
   
   
   /** @pdGenerated default getter */
   public java.util.List<Comment> getComments() {
      if (comments == null)
         comments = new java.util.ArrayList<Comment>();
      return comments;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorComments() {
      if (comments == null)
         comments = new java.util.ArrayList<Comment>();
      return comments.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newComments */
   public void setComments(java.util.List<Comment> newComments) {
      removeAllComments();
      for (java.util.Iterator iter = newComments.iterator(); iter.hasNext();)
         addComments((Comment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newComment */
   public void addComments(Comment newComment) {
      if (newComment == null)
         return;
      if (this.comments == null)
         this.comments = new java.util.ArrayList<Comment>();
      if (!this.comments.contains(newComment))
         this.comments.add(newComment);
   }
   
   /** @pdGenerated default remove
     * @param oldComment */
   public void removeComments(Comment oldComment) {
      if (oldComment == null)
         return;
      if (this.comments != null)
         if (this.comments.contains(oldComment))
            this.comments.remove(oldComment);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllComments() {
      if (comments != null)
         comments.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Recipe> getRecipes() {
      if (recipes == null)
         recipes = new java.util.ArrayList<Recipe>();
      return recipes;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRecipes() {
      if (recipes == null)
         recipes = new java.util.ArrayList<Recipe>();
      return recipes.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRecipes */
   public void setRecipes(java.util.List<Recipe> newRecipes) {
      removeAllRecipes();
      for (java.util.Iterator iter = newRecipes.iterator(); iter.hasNext();)
         addRecipes((Recipe)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRecipe */
   public void addRecipes(Recipe newRecipe) {
      if (newRecipe == null)
         return;
      if (this.recipes == null)
         this.recipes = new java.util.ArrayList<Recipe>();
      if (!this.recipes.contains(newRecipe))
         this.recipes.add(newRecipe);
   }
   
   /** @pdGenerated default remove
     * @param oldRecipe */
   public void removeRecipes(Recipe oldRecipe) {
      if (oldRecipe == null)
         return;
      if (this.recipes != null)
         if (this.recipes.contains(oldRecipe))
            this.recipes.remove(oldRecipe);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRecipes() {
      if (recipes != null)
         recipes.clear();
   }

}