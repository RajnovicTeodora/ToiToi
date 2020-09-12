/***********************************************************************
 * Module:  Comment.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class Comment
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;

	private LocalDate date;

	public java.util.List<Comment> child;

	public User commentator;

	public List<Comment> getChild() {
		if (child == null)
			child = new java.util.ArrayList<Comment>();
		return child;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [text=" + text + ", date=" + date + ", child=" + child + ", commentator=" + commentator + "]";
	}

	public void addChild(Comment newComment) {
		if (newComment == null)
			return;
		if (this.child == null)
			this.child = new java.util.ArrayList<Comment>();
		if (!this.child.contains(newComment))
			this.child.add(newComment);
	}

	public void removeChild(Comment oldComment) {
		if (oldComment == null)
			return;
		if (this.child != null)
			if (this.child.contains(oldComment))
				this.child.remove(oldComment);
	}

	public void removeAllChild() {
		if (child != null)
			child.clear();
	}

	public User getCommentator() {
		return commentator;
	}

	public void setCommentator(User commentator) {
		this.commentator = commentator;
	}

}