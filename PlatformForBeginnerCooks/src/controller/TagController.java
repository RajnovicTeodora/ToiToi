package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Tag;

public class TagController {

	private Tag tag;

	private String tagFile;

	public TagController(String tagfile) {

		super();
		this.tagFile = tagfile;

	}

	public void writeTags(ArrayList<Tag> tagList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(tagFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(tagList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Tag> readTags() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Tag> tagList = null;
		try {
			FileInputStream fileIn = new FileInputStream(tagFile);
			objectIn = new ObjectInputStream(fileIn);
			tagList = (ArrayList<Tag>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return tagList;

	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}

