/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 6bd2980a-2daa-405e-948d-ee4b4751d709 */
public class Product {
   /** @pdOid d580cefc-99e8-4d7c-a04d-d617697a4088 */
   private String name;
   /** @pdOid 983a89e2-126d-4948-be7a-beb2d714a80e */
   private String producedBy;
   /** @pdOid dad12e77-0e91-4316-9b2f-c9aff403592f */
   private int productID;
   
   /** @pdRoleInfo migr=no name=Product assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Product> part;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Product> getPart() {
      if (part == null)
         part = new java.util.HashSet<Product>();
      return part;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPart() {
      if (part == null)
         part = new java.util.HashSet<Product>();
      return part.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPart */
   public void setPart(java.util.Collection<Product> newPart) {
      removeAllPart();
      for (java.util.Iterator iter = newPart.iterator(); iter.hasNext();)
         addPart((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addPart(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.part == null)
         this.part = new java.util.HashSet<Product>();
      if (!this.part.contains(newProduct))
         this.part.add(newProduct);
   }
   
   /** @pdGenerated default remove
     * @param oldProduct */
   public void removePart(Product oldProduct) {
      if (oldProduct == null)
         return;
      if (this.part != null)
         if (this.part.contains(oldProduct))
            this.part.remove(oldProduct);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPart() {
      if (part != null)
         part.clear();
   }

}