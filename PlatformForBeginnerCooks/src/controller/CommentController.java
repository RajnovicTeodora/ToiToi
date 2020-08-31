package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Comment;

public class CommentController {
	
	private Comment comment;
	private String commentFile;
	
	public CommentController(String file) {
		super();
		this.commentFile = file;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getCommentFile() {
		return commentFile;
	}

	public void setCommentFile(String commentFile) {
		this.commentFile = commentFile;
	}
	
	public void writeComments(ArrayList<Comment> commentList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(commentFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(commentList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comment> readComments() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Comment> commentList = null;
		try {
			FileInputStream fileIn = new FileInputStream(commentFile);
			objectIn = new ObjectInputStream(fileIn);
			commentList = (ArrayList<Comment>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return commentList;

	}

}
