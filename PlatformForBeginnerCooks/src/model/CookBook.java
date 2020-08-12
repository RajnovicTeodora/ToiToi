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
   
   /** @pdRoleInfo migr=no name=Comment assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Comment> comment;
   /** @pdRoleInfo migr=no name=Recipe assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Recipe> recipe;
   
   
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

}