/***********************************************************************
 * Module:  CookBook.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class CookBook implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String image;

	private LocalDate date;

	private int likes;

	public java.util.List<Comment> comments;

	public java.util.List<Recipe> recipes;

	private User creator;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CookBook [name=" + name + ", date=" + date + ", likes=" + likes + ", comments=" + comments
				+ ", recipes=" + recipes + ", creator=" + creator + "]";
	}

	public java.util.List<Comment> getComments() {
		if (comments == null)
			comments = new java.util.ArrayList<Comment>();
		return comments;
	}

	public Iterator<Comment> getIteratorComments() {
		if (comments == null)
			comments = new java.util.ArrayList<Comment>();
		return comments.iterator();
	}

	public void setComments(java.util.List<Comment> newComments) {
		removeAllComments();
		for (Iterator<Comment> iter = newComments.iterator(); iter.hasNext();)
			addComments((Comment) iter.next());
	}

	public void addComments(Comment newComment) {
		if (newComment == null)
			return;
		if (this.comments == null)
			this.comments = new java.util.ArrayList<Comment>();
		if (!this.comments.contains(newComment))
			this.comments.add(newComment);
	}

	public void removeComments(Comment oldComment) {
		if (oldComment == null)
			return;
		if (this.comments != null)
			if (this.comments.contains(oldComment))
				this.comments.remove(oldComment);
	}

	public void removeAllComments() {
		if (comments != null)
			comments.clear();
	}

	public java.util.List<Recipe> getRecipes() {
		if (recipes == null)
			recipes = new java.util.ArrayList<Recipe>();
		return recipes;
	}

	public Iterator<Recipe> getIteratorRecipes() {
		if (recipes == null)
			recipes = new java.util.ArrayList<Recipe>();
		return recipes.iterator();
	}

	public void setRecipes(java.util.List<Recipe> newRecipes) {
		removeAllRecipes();
		for (Iterator<Recipe> iter = newRecipes.iterator(); iter.hasNext();)
			addRecipes((Recipe) iter.next());
	}

	public void addRecipes(Recipe newRecipe) {
		if (newRecipe == null)
			return;
		if (this.recipes == null)
			this.recipes = new java.util.ArrayList<Recipe>();
		if (!this.recipes.contains(newRecipe))
			this.recipes.add(newRecipe);
	}

	public void removeRecipes(Recipe oldRecipe) {
		if (oldRecipe == null)
			return;
		if (this.recipes != null)
			if (this.recipes.contains(oldRecipe))
				this.recipes.remove(oldRecipe);
	}

	public void removeAllRecipes() {
		if (recipes != null)
			recipes.clear();
	}

}