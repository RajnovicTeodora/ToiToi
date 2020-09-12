/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Recipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int recipeID;

	private String name;

	private String description;

	private int likes = 0;

	private String image;

	private LocalDate dateCreated;

	private User creator;

	private int servings;

	private int difficulty; // 1-5

	private int prepTime;

	private int cookTime;

	private List<Taste> taste;

	private List<Tag> tags;

	private List<Equipment> equipment;

	private List<Comment> comment;

<<<<<<< Updated upstream
	public ArrayList<NeededQuantity> neededProductQuantity;
	
	private Integer difficulty;
	
	private Integer prepTime;
	
	private Integer cookTime;
	
	private User creator;
=======
	private List<NeededQuantity> neededProductQuantity;
>>>>>>> Stashed changes

	public Recipe() {
		super();
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public Recipe(String name, String description, int likes, LocalDate dateCreated, ArrayList<Taste> taste,
			List<Tag> tags, List<Equipment> equipment, List<Comment> comment,
			ArrayList<NeededQuantity> neededProductQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.likes = likes;
		this.dateCreated = dateCreated;
		this.taste = taste;
		this.tags = tags;
		this.equipment = equipment;
		this.comment = comment;
		this.neededProductQuantity = neededProductQuantity;
	}

	public List<NeededQuantity> getNeededProductQuantity() {
		return neededProductQuantity;
	}

	public void setNeededProductQuantity(ArrayList<NeededQuantity> neededProductQuantity) {
		this.neededProductQuantity = neededProductQuantity;
	}

	public void addNeededQuantity(NeededQuantity nq) {
		if (nq == null)
			return;
		if (this.neededProductQuantity == null)
			this.neededProductQuantity = new java.util.ArrayList<NeededQuantity>();
		if (!this.neededProductQuantity.contains(nq))
			this.neededProductQuantity.add(nq);
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Taste> getTaste() {
		return taste;
	}

	public void setTaste(ArrayList<Taste> taste) {
		this.taste = taste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public LocalDate getDate() {
		return dateCreated;
	}

	public void setDate(LocalDate date) {
		this.dateCreated = date;
	}

	@Override
	public String toString() {
		return "Recipe [recipeID=" + recipeID + ", name=" + name + ", description=" + description + ", likes=" + likes
				+ ", image=" + image + ", creator=" + creator + ", date=" + dateCreated + ", servings=" + servings
				+ ", difficulty=" + difficulty + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", taste="
				+ taste + ", tags=" + tags + ", equipment=" + equipment + ", comment=" + comment
				+ ", neededProductQuantity=" + neededProductQuantity + "]";
	}

	public java.util.List<Tag> getTags() {
		if (tags == null)
			tags = new java.util.ArrayList<Tag>();
		return tags;
	}

	public Iterator<Tag> getIteratorTags() {
		if (tags == null)
			tags = new java.util.ArrayList<Tag>();
		return tags.iterator();
	}

	public void setTastes(java.util.List<Taste> newTastes) {
		removeAllTastes();
		for (Iterator<Taste> iter = newTastes.iterator(); iter.hasNext();)
			addTastes((Taste) iter.next());
	}

	public void addTastes(Taste newTaste) {
		if (newTaste == null)
			return;
		if (this.taste == null)
			this.taste = new java.util.ArrayList<Taste>();
		if (!this.taste.contains(newTaste))
			this.taste.add(newTaste);
	}

	public void removeTastes(Taste oldTaste) {
		if (oldTaste == null)
			return;
		if (this.taste != null)
			if (this.taste.contains(oldTaste))
				this.taste.remove(oldTaste);
	}

	public void removeAllTastes() {
		if (taste != null)
			taste.clear();
	}

	public void setTags(java.util.List<Tag> newTags) {
		removeAllTags();
		for (Iterator<Tag> iter = newTags.iterator(); iter.hasNext();)
			addTags((Tag) iter.next());
	}

	public void addTags(Tag newTag) {
		if (newTag == null)
			return;
		if (this.tags == null)
			this.tags = new java.util.ArrayList<Tag>();
		if (!this.tags.contains(newTag))
			this.tags.add(newTag);
	}

	public void removeTags(Tag oldTag) {
		if (oldTag == null)
			return;
		if (this.tags != null)
			if (this.tags.contains(oldTag))
				this.tags.remove(oldTag);
	}

	public void removeAllTags() {
		if (tags != null)
			tags.clear();
	}

	public java.util.List<Equipment> getEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment;
	}

	public Iterator<Equipment> getIteratorEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment.iterator();
	}

	public void setEquipment(List<Equipment> newEquipment) {
		removeAllEquipment();
		for (Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
			addEquipment((Equipment) iter.next());
	}

	public void addEquipment(Equipment newEquipment) {
		if (newEquipment == null)
			return;
		if (this.equipment == null)
			this.equipment = new java.util.ArrayList<Equipment>();
		if (!this.equipment.contains(newEquipment))
			this.equipment.add(newEquipment);
	}

	public void removeEquipment(Equipment oldEquipment) {
		if (oldEquipment == null)
			return;
		if (this.equipment != null)
			if (this.equipment.contains(oldEquipment))
				this.equipment.remove(oldEquipment);
	}

	public void removeAllEquipment() {
		if (equipment != null)
			equipment.clear();
	}

	public java.util.List<Comment> getComment() {
		if (comment == null)
			comment = new java.util.ArrayList<Comment>();
		return comment;
	}

	public Iterator<Comment> getIteratorComment() {
		if (comment == null)
			comment = new java.util.ArrayList<Comment>();
		return comment.iterator();
	}

	public void setComment(java.util.List<Comment> newComment) {
		removeAllComment();
		for (Iterator<Comment> iter = newComment.iterator(); iter.hasNext();)
			addComment((Comment) iter.next());
	}

	public void addComment(Comment newComment) {
		if (newComment == null)
			return;
		if (this.comment == null)
			this.comment = new java.util.ArrayList<Comment>();
		if (!this.comment.contains(newComment))
			this.comment.add(newComment);
	}

	public void removeComment(Comment oldComment) {
		if (oldComment == null)
			return;
		if (this.comment != null)
			if (this.comment.contains(oldComment))
				this.comment.remove(oldComment);
	}

	public void removeAllComment() {
		if (comment != null)
			comment.clear();
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

<<<<<<< Updated upstream
	public ArrayList<Taste> getTaste() {
		return taste;
	}

	public void setTaste(ArrayList<Taste> taste) {
		this.taste = taste;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	public ArrayList<Integer> getProductIds(){
		ArrayList<Integer> retval = new ArrayList<Integer>();
		for (NeededQuantity nq : getNeededProductQuantity()) {
			retval.add(nq.getIngredient().getProductID());
		}
		return retval;
	}
	
	public ArrayList<Integer> getEquipmentIds(){
		ArrayList<Integer> retval = new ArrayList<Integer>();
		for (Equipment eq : getEquipment()) {
			retval.add(eq.getEquipmentID());
		}
		return retval;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
	
=======
	public void setTaste(List<Taste> taste) {
		this.taste = taste;
	}

	public void setNeededProductQuantity(List<NeededQuantity> neededProductQuantity) {
		this.neededProductQuantity = neededProductQuantity;
	}
	

>>>>>>> Stashed changes
}