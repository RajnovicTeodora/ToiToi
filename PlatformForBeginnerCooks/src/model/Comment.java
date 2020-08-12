/***********************************************************************
 * Module:  Comment.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Comment
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 1cfa9572-b2d0-44cc-8982-c6a2ebb2f4e1 */
public class Comment {
   /** @pdOid f8c7de89-eea8-4192-93de-061edfdf17d3 */
   private String text;
   /** @pdOid b65852b4-96ad-4dc7-833c-626be70b5490 */
   private java.util.Date date;
   
   /** @pdRoleInfo migr=no name=Comment assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Comment> child;
   /** @pdRoleInfo migr=no name=User assc=association17 mult=1..1 */
   public User commentator;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Comment> getChild() {
      if (child == null)
         child = new java.util.HashSet<Comment>();
      return child;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorChild() {
      if (child == null)
         child = new java.util.HashSet<Comment>();
      return child.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newChild */
   public void setChild(java.util.Collection<Comment> newChild) {
      removeAllChild();
      for (java.util.Iterator iter = newChild.iterator(); iter.hasNext();)
         addChild((Comment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newComment */
   public void addChild(Comment newComment) {
      if (newComment == null)
         return;
      if (this.child == null)
         this.child = new java.util.HashSet<Comment>();
      if (!this.child.contains(newComment))
         this.child.add(newComment);
   }
   
   /** @pdGenerated default remove
     * @param oldComment */
   public void removeChild(Comment oldComment) {
      if (oldComment == null)
         return;
      if (this.child != null)
         if (this.child.contains(oldComment))
            this.child.remove(oldComment);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllChild() {
      if (child != null)
         child.clear();
   }

}